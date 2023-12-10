package com.example.framework.service;

import com.example.framework.common.Result;
import com.example.framework.dal.dto.SendMessageDTO;

public interface WebSocketService {

    /**
     * 执行发送人发送消息接口
     *
     * @param message 入参
     * @return 成功提示
     */
    Result<Object> sendOneMessage(SendMessageDTO message);


    /**
     * 群发所有人
     *
     * @param message 入参
     */
    void batchSendInfo(SendMessageDTO message);
}
