package com.nighthawk.nettyserver;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class NettySocketService {

    @Autowired
    private SocketIOServer socketIOServer;

    @PostConstruct
    public void start() {
        socketIOServer.addEventListener("message", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient client, String data, AckRequest ackRequest) {
                client.sendEvent("message", data);
            }
        });
        
        socketIOServer.start();
    }

    @PreDestroy
    public void stop() {
        socketIOServer.stop();
    }
}