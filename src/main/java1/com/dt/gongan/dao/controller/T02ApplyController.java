package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.T02ApplyEntity;
import com.dt.gongan.dao.service.T02ApplyService;
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
 * 申请记录 前端控制器
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@RestController
@Api(tags = "02 申请记录", description = "/gongan/t02-apply-entity")
@RequestMapping("/gongan/t02-apply-entity")
public class T02ApplyController {
    @Autowired
    private T02ApplyService t02ApplyService;

    @ApiOperation(value = "申请记录分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<T02ApplyEntity>> page(@RequestBody PageRequest<T02ApplyEntity> pageRequest,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", pageRequest, loginUserDto, sessionToken);

        log.info("page request: {}", pageRequest);

        IPage<T02ApplyEntity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        T02ApplyEntity t02ApplyEntity = pageRequest.getData();
        IPage<T02ApplyEntity> resultList = t02ApplyService.selectPage(page, t02ApplyEntity);

        return PageReplyResponse.page(resultList);
    }

    @ApiOperation(value = "申请记录列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<T02ApplyEntity>> list(
            @RequestBody RequestWrapper<T02ApplyEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("list request: {}", requestWrapper);

        T02ApplyEntity t02ApplyEntity = requestWrapper.getData();
        List<T02ApplyEntity> resultList =
            t02ApplyService.selectList(t02ApplyEntity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "增加记录", notes = "insert")
    @PostMapping("/insert")
    public ReplyResponse<T02ApplyEntity> insert(@RequestBody RequestWrapper<T02ApplyEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("insert request: {}", requestWrapper);
        t02ApplyService.insert(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "修改记录", notes = "update")
    @PostMapping("/update")
    public ReplyResponse<T02ApplyEntity> update(@RequestBody RequestWrapper<T02ApplyEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t02ApplyService.update(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "删除记录", notes = "delete")
    @PostMapping("/delete")
    public ReplyResponse<T02ApplyEntity> delete(@RequestBody RequestWrapper<Long> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t02ApplyService.removeById(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<T02ApplyEntity> detail(@RequestBody RequestWrapper<Long> requestWrapper,
        @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("detail request: {}", requestWrapper);
        T02ApplyEntity result = t02ApplyService.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
