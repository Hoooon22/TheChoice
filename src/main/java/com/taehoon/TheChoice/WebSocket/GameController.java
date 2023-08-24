package com.taehoon.TheChoice.WebSocket;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    private SimpMessagingTemplate messageTemplate;

    public GameController(SimpMessagingTemplate messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    @MessageMapping("/game")
    @SendTo("/topic/game")
    public GameMessage game(GameMessage gameMessage) {
        return gameMessage;
    }
}
