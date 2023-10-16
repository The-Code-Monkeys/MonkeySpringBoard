package com.nighthawk.nettyserver;

@Component
public class SocketEventListeners {

    private final SocketIOServer server;

    @Autowired
    public SocketEventListeners(SocketIOServer server) {
        this.server = server;
        registerEvents();
    }

    private void registerEvents() {
        server.addEventListener("some_event", Main.class, (client, data, ackRequest) -> {
            // handle the event
        });
    }
}
