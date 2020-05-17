package pl.pawelec97.webApplication4PW.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/chatRoom")
    public Chat chatMessage(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Chat(HtmlUtils.htmlEscape(message.getName()) + ": " + HtmlUtils.htmlEscape(message.getMsg()));
    }

}
