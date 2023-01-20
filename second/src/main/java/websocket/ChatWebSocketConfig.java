package websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 내가 설정파일이야~ 알려주는 어노테이션
@EnableWebSocket
public class ChatWebSocketConfig implements WebSocketConfigurer{
// ws요청시 ChatWebSocketHandler
	private final WebSocketHandler handler;

	public ChatWebSocketConfig(WebSocketHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/ws").setAllowedOrigins("*");
	}

}
