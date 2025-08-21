package com.xyy.codeai.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xyy.codeai.model.dto.chathistory.ChatHistoryQueryRequest;
import com.xyy.codeai.model.entity.ChatHistory;
import com.xyy.codeai.model.entity.User;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author java_boy
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     *  添加历史对话
     * @param appId 应用id
     * @param message 对话内容
     * @param messageType 对话类型
     * @param userId   用户id
     * @return
     */
     boolean addChatMessage(Long appId, String message, String messageType, Long userId);


    /**
     * 根据应用id删除历史对话
     * @param appId 应用id
     * @return
     */
    boolean deleteByAppId(Long appId);

    /**
     * 获取查询条件
     * @param chatHistoryQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    /**
     * 分页获取应用历史对话
     * @param appId 应用id
     * @param pageSize 页大小
     * @param lastCreateTime 最后创建时间
     * @param loginUser 登录用户
     * @return
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    /**
     *  加载历史对话到内存
     * @param appId 应用id
     * @param chatMemory 对话内存
     * @param maxCount  最大数量
     * @return
     */
    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);



}
