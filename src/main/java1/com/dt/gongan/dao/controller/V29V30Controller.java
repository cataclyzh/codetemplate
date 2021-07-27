package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.V29V30Entity;
import com.dt.gongan.dao.service.V29V30Service;
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
@Api(tags = "29 VIEW", description = "/gongan/v29-v30-entity")
@RequestMapping("/gongan/v29-v30-entity")
public class V29V30Controller {
    @Autowired
    private V29V30Service v29V30Service;

    @Autowired
    private DatabaseManager databaseManager;

    @ApiOperation(value = "VIEW分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<V29V30Entity>> page(
            @RequestBody PageRequest<V29V30Entity> pageRequest,
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

        IPage<V29V30Entity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        V29V30Entity v29V30Entity = pageRequest.getData();
        IPage<V29V30Entity> resultPage = v29V30Service.selectPage(page, v29V30Entity);

        return PageReplyResponse.page(resultPage);
    }

    @ApiOperation(value = "VIEW列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<V29V30Entity>> list(
            @RequestBody RequestWrapper<V29V30Entity> requestWrapper,
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

        V29V30Entity v29V30Entity = requestWrapper.getData();
        List<V29V30Entity> resultList =
            v29V30Service.selectList(v29V30Entity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<V29V30Entity> detail(
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
        V29V30Entity result = v29V30Service.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
