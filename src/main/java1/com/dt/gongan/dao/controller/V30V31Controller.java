package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.V30V31Entity;
import com.dt.gongan.dao.service.V30V31Service;
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
 * VIEW 前端控制器
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-26
 */
@Slf4j
@RestController
@Api(tags = "30 VIEW", description = "/gongan/v30-v31-entity")
@RequestMapping("/gongan/v30-v31-entity")
public class V30V31Controller {
    @Autowired
    private V30V31Service v30V31Service;

    @Autowired
    private DatabaseManager databaseManager;

    @ApiOperation(value = "VIEW分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<V30V31Entity>> page(
            @RequestBody PageRequest<V30V31Entity> pageRequest,
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

        IPage<V30V31Entity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        V30V31Entity v30V31Entity = pageRequest.getData();
        IPage<V30V31Entity> resultPage = v30V31Service.selectPage(page, v30V31Entity);

        return PageReplyResponse.page(resultPage);
    }

    @ApiOperation(value = "VIEW列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<V30V31Entity>> list(
            @RequestBody RequestWrapper<V30V31Entity> requestWrapper,
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

        V30V31Entity v30V31Entity = requestWrapper.getData();
        List<V30V31Entity> resultList =
            v30V31Service.selectList(v30V31Entity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<V30V31Entity> detail(
            @RequestBody RequestWrapper<Long> requestWrapper,
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
        V30V31Entity result = v30V31Service.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
