package com.example.messenger.chat;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    @OnEvent("chat")
    public void chat(SocketIOClient socketIOClient, @RequestBody String msg) {
        socketIOClient.sendEvent("chat", msg);
    }
}
