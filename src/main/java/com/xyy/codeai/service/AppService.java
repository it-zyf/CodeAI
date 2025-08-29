package com.xyy.codeai.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xyy.codeai.model.dto.app.AppAddRequest;
import com.xyy.codeai.model.dto.app.AppQueryRequest;
import com.xyy.codeai.model.entity.App;
import com.xyy.codeai.model.entity.User;
import com.xyy.codeai.model.vo.app.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author java_boy
 */
public interface AppService extends IService<App> {


    /**
     * 通过对话生成应用代码
     *
     * @param appId     应用 ID
     * @param message   提示词
     * @param loginUser 登录用户
     * @return
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 获取应用封装类
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);



    /**
     * 获取应用封装类列表
     *
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造应用查询条件
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);


    /**
     *  部署应用
     * @param appId 应用 ID
     * @param loginUser 登录用户
     * @return
     */
    String deployApp(Long appId, User loginUser);

    /**
     * 创建应用
     * @param appAddRequest 应用信息
     * @param loginUser 登录用户
     * @return
     */
    Long createApp(AppAddRequest appAddRequest, User loginUser);


}
