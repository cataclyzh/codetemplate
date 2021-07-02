package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.T22TelLeaderCommentEntity;
import com.dt.gongan.dao.service.T22TelLeaderCommentService;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dt.core.model.RequestWrapper;
import com.dt.core.model.PageReplyResponse;
import com.dt.core.model.PageRequest;
import com.dt.core.model.ReplyResponse;

import com.dt.core.tools.MyHttpTools;
import com.dt.gongan.model.session.LoginUserDto;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import com.dt.gongan.model.dto.rest.LoginUserRestVo;
import com.dt.gongan.manager.DatabaseManager;

/**
 * <p>
 * 电话申请的领导批示 前端控制器
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-02
 */
@Slf4j
@RestController
@Api(tags = "22 电话申请的领导批示", description = "/gongan/t22-tel-leader-comment-entity")
@RequestMapping("/gongan/t22-tel-leader-comment-entity")
public class T22TelLeaderCommentController {
    @Autowired
    private T22TelLeaderCommentService t22TelLeaderCommentService;

    @Autowired
    private DatabaseManager databaseManager;

    @ApiOperation(value = "电话申请的领导批示分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<T22TelLeaderCommentEntity>> page(@RequestBody PageRequest<T22TelLeaderCommentEntity> pageRequest,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", pageRequest, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("page request: {}", pageRequest);

        IPage<T22TelLeaderCommentEntity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        T22TelLeaderCommentEntity t22TelLeaderCommentEntity = pageRequest.getData();
        IPage<T22TelLeaderCommentEntity> resultList = t22TelLeaderCommentService.selectPage(page, t22TelLeaderCommentEntity);

        return PageReplyResponse.page(resultList);
    }

    @ApiOperation(value = "电话申请的领导批示列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<T22TelLeaderCommentEntity>> list(
            @RequestBody RequestWrapper<T22TelLeaderCommentEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("list request: {}", requestWrapper);

        T22TelLeaderCommentEntity t22TelLeaderCommentEntity = requestWrapper.getData();
        List<T22TelLeaderCommentEntity> resultList =
            t22TelLeaderCommentService.selectList(t22TelLeaderCommentEntity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "增加记录", notes = "insert")
    @PostMapping("/insert")
    public ReplyResponse<T22TelLeaderCommentEntity> insert(@RequestBody RequestWrapper<T22TelLeaderCommentEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("insert request: {}", requestWrapper);
        t22TelLeaderCommentService.insert(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "修改记录", notes = "update")
    @PostMapping("/update")
    public ReplyResponse<T22TelLeaderCommentEntity> update(@RequestBody RequestWrapper<T22TelLeaderCommentEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("update request: {}", requestWrapper);
        t22TelLeaderCommentService.update(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "删除记录", notes = "delete")
    @PostMapping("/delete")
    public ReplyResponse<T22TelLeaderCommentEntity> delete(@RequestBody RequestWrapper<Long> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("update request: {}", requestWrapper);
        t22TelLeaderCommentService.removeById(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<T22TelLeaderCommentEntity> detail(@RequestBody RequestWrapper<Long> requestWrapper,
        @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        //接口获取完整的当前用户信息
        LoginUserRestVo user = databaseManager.queryUserDetail(loginUserDto.getId());
        log.info("user: {}", user);

        log.info("detail request: {}", requestWrapper);
        T22TelLeaderCommentEntity result = t22TelLeaderCommentService.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
