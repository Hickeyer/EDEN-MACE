package com.stylefeng.guns.config;

import com.stylefeng.guns.core.shiro.ShiroKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xiaojiang
 * 实现websocket通信
 */
@Component
@ServerEndpoint(value = "/ws/statis",configurator = WebSocketConfig.class)
public class StatisticsWebSocket {


    private Logger logger =  LoggerFactory.getLogger(StatisticsWebSocket.class);

    //每个客户端的标志
    private Session session;

    private String account;

    private static CopyOnWriteArraySet<StatisticsWebSocket> copyOnWriteArraySet = new CopyOnWriteArraySet<StatisticsWebSocket>();

    /**
     * 打开页面会自动进入此方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig config){
        String account = (String) config.getUserProperties().get("account");
        this.session = session;
        this.account = account;
        copyOnWriteArraySet.add(this);
        logger.info("新的连接进入，总数:{}",copyOnWriteArraySet.size());
    }

    @OnClose
    public void onClose(){
        copyOnWriteArraySet.remove(this);
        logger.info("连接断开,总数:{}",copyOnWriteArraySet.size());
    }

    /**
     * 接收消息
     */
    @OnMessage
    public void onMessage(String message){
        logger.info("接收到新的消息:{}",message);
    }

    @OnError
    public void onError(Session session,Throwable e){
        logger.error("发生错误,{},{}",e.getMessage(),session.getId());
        e.printStackTrace();
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message) {
      //  String account = ShiroKit.getUser().getAccount();
        //遍历客户端
        for (StatisticsWebSocket webSocket : copyOnWriteArraySet) {
            logger.info("广播消息：" + message);
            try {
                //服务器主动推送
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        //这个对象说一下，貌似只有服务器是tomcat的时候才需要配置,具体我没有研究
        return new ServerEndpointExporter();
    }




















}
