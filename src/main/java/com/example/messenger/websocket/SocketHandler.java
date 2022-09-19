package com.example.messenger.websocket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@NoArgsConstructor
@RestController
public class SocketHandler {

    public static final ConcurrentMap<String, SocketIOClient> sessions = new ConcurrentHashMap<>();
    @OnConnect
    public void onConnect(SocketIOClient socketIOClient) {
        String clientId = socketIOClient.getHandshakeData().getSingleUrlParam("id");
        sessions.put(clientId, socketIOClient);
        socketIOClient.set("user", clientId);
        log.info("Connected" + clientId);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient socketIOClient) {
        String uk = socketIOClient.get("user");
        sessions.remove(uk);
        log.info("Disconnected" + uk);
    }
}
