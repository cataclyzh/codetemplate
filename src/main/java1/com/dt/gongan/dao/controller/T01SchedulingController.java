package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.T01SchedulingEntity;
import com.dt.gongan.dao.service.T01SchedulingService;
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

/**
 * <p>
 * 排班信息 前端控制器
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@RestController
@Api(tags = "01 排班信息", description = "/gongan/t01-scheduling-entity")
@RequestMapping("/gongan/t01-scheduling-entity")
public class T01SchedulingController {
    @Autowired
    private T01SchedulingService t01SchedulingService;

    @ApiOperation(value = "排班信息分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<T01SchedulingEntity>> page(@RequestBody PageRequest<T01SchedulingEntity> pageRequest,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", pageRequest, loginUserDto, sessionToken);

        log.info("page request: {}", pageRequest);

        IPage<T01SchedulingEntity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        T01SchedulingEntity t01SchedulingEntity = pageRequest.getData();
        IPage<T01SchedulingEntity> resultList = t01SchedulingService.selectPage(page, t01SchedulingEntity);

        return PageReplyResponse.page(resultList);
    }

    @ApiOperation(value = "排班信息列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<T01SchedulingEntity>> list(
            @RequestBody RequestWrapper<T01SchedulingEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("list request: {}", requestWrapper);

        T01SchedulingEntity t01SchedulingEntity = requestWrapper.getData();
        List<T01SchedulingEntity> resultList =
            t01SchedulingService.selectList(t01SchedulingEntity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "增加记录", notes = "insert")
    @PostMapping("/insert")
    public ReplyResponse<T01SchedulingEntity> insert(@RequestBody RequestWrapper<T01SchedulingEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("insert request: {}", requestWrapper);
        t01SchedulingService.insert(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "修改记录", notes = "update")
    @PostMapping("/update")
    public ReplyResponse<T01SchedulingEntity> update(@RequestBody RequestWrapper<T01SchedulingEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t01SchedulingService.update(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "删除记录", notes = "delete")
    @PostMapping("/delete")
    public ReplyResponse<T01SchedulingEntity> delete(@RequestBody RequestWrapper<Long> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t01SchedulingService.removeById(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<T01SchedulingEntity> detail(@RequestBody RequestWrapper<Long> requestWrapper,
        @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("detail request: {}", requestWrapper);
        T01SchedulingEntity result = t01SchedulingService.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
