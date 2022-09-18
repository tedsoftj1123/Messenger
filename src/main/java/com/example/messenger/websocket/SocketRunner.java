package com.example.messenger.websocket;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@RequiredArgsConstructor
public class SocketRunner implements CommandLineRunner {
    private final SocketIOServer socketIOServer;
    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
    }
}
