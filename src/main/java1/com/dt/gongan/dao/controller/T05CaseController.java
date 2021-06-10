package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.T05CaseEntity;
import com.dt.gongan.dao.service.T05CaseService;
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
 * 战果案例填报 前端控制器
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
@Slf4j
@RestController
@Api(tags = "05 战果案例填报", description = "/gongan/t05-case-entity")
@RequestMapping("/gongan/t05-case-entity")
public class T05CaseController {
    @Autowired
    private T05CaseService t05CaseService;

    @ApiOperation(value = "战果案例填报分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<T05CaseEntity>> page(@RequestBody PageRequest<T05CaseEntity> pageRequest,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", pageRequest, loginUserDto, sessionToken);

        log.info("page request: {}", pageRequest);

        IPage<T05CaseEntity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        T05CaseEntity t05CaseEntity = pageRequest.getData();
        IPage<T05CaseEntity> resultList = t05CaseService.selectPage(page, t05CaseEntity);

        return PageReplyResponse.page(resultList);
    }

    @ApiOperation(value = "战果案例填报列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<T05CaseEntity>> list(
            @RequestBody RequestWrapper<T05CaseEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("list request: {}", requestWrapper);

        T05CaseEntity t05CaseEntity = requestWrapper.getData();
        List<T05CaseEntity> resultList =
            t05CaseService.selectList(t05CaseEntity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "增加记录", notes = "insert")
    @PostMapping("/insert")
    public ReplyResponse<T05CaseEntity> insert(@RequestBody RequestWrapper<T05CaseEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("insert request: {}", requestWrapper);
        t05CaseService.insert(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "修改记录", notes = "update")
    @PostMapping("/update")
    public ReplyResponse<T05CaseEntity> update(@RequestBody RequestWrapper<T05CaseEntity> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t05CaseService.update(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "删除记录", notes = "delete")
    @PostMapping("/delete")
    public ReplyResponse<T05CaseEntity> delete(@RequestBody RequestWrapper<Long> requestWrapper,
            @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("update request: {}", requestWrapper);
        t05CaseService.removeById(requestWrapper.getData());
        return ReplyResponse.ok();
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<T05CaseEntity> detail(@RequestBody RequestWrapper<Long> requestWrapper,
        @RequestHeader(value = "current-user") String userJson,
            @RequestHeader(value = "sessionToken") String sessionToken,
            HttpServletRequest request) {
        MyHttpTools.printHeaderInfo(request);
        //用户信息处理
        LoginUserDto loginUserDto = MyHttpTools.convertLoginUserDto(userJson);
        log.info("requestWrapper: {}, login user: {}, sessionToken: {}", requestWrapper, loginUserDto, sessionToken);

        log.info("detail request: {}", requestWrapper);
        T05CaseEntity result = t05CaseService.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
