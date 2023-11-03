package com.example.framework.service;

import com.example.framework.common.Result;
import com.example.framework.dal.dto.SendMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@ServerEndpoint("/websocket/{userId}")
public class WebsocketImpl {
    private static final ConcurrentHashMap<String, WebsocketImpl> websocketMap = new ConcurrentHashMap<>();

    /**
     * 当前连接数
     */
    private static final AtomicInteger count = new AtomicInteger(0);

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 对应的用户ID
     */
    private String userId = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        try {
            this.session = session;
            this.userId = userId;
            websocketMap.put(userId, this);
            // 数量+1
            count.getAndIncrement();
            log.info("websocket 新连接：{}", userId);
        } catch (Exception e) {
            log.error("websocket 新建连接 IO异常");
        }
    }

    /**
     * 连接错误调用方法
     */
    @OnError
    public void onError(Throwable error) {
        log.info("链接错误");
    }

    /**
     * 发送消息方法
     *
     * @param message 入参
     */
    public void send(String message) {
        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 执行发送人发送消息接口
     *
     * @param message 入参
     * @return 成功提示
     */
    public Result<Object> sendOneMessage(SendMessageDTO message) {
        if (websocketMap.containsKey(message.getUserId().toString())) {
            websocketMap.get(message.getUserId().toString()).send(message.getMessage());
        }
        return Result.success(message);
    }
}
