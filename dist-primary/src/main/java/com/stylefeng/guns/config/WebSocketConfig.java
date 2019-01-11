package com.stylefeng.guns.config;

import com.stylefeng.guns.core.shiro.ShiroKit;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Configuration;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {

    private static final String HttpSession = null;

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        String account = ShiroKit.getUser().getAccount();
        sec.getUserProperties().put("account", account);
        super.modifyHandshake(sec, request, response);
    }
}
