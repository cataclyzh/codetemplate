package com.dt.gongan.dao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.gongan.dao.entity.VUserEntity;
import com.dt.gongan.dao.service.VUserService;
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
@Api(tags = "Us VIEW", description = "/gongan/v-user-entity")
@RequestMapping("/gongan/v-user-entity")
public class VUserController {
    @Autowired
    private VUserService vUserService;

    @Autowired
    private DatabaseManager databaseManager;

    @ApiOperation(value = "VIEW分页查询", notes = "page")
    @PostMapping("/page")
    public PageReplyResponse<List<VUserEntity>> page(
            @RequestBody PageRequest<VUserEntity> pageRequest,
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

        IPage<VUserEntity> page = new Page<>(pageRequest.getCurrentPage(),
                pageRequest.getPageSize(), true);
        VUserEntity vUserEntity = pageRequest.getData();
        IPage<VUserEntity> resultPage = vUserService.selectPage(page, vUserEntity);

        return PageReplyResponse.page(resultPage);
    }

    @ApiOperation(value = "VIEW列表查询", notes = "list")
    @PostMapping("/list")
    public ReplyResponse<List<VUserEntity>> list(
            @RequestBody RequestWrapper<VUserEntity> requestWrapper,
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

        VUserEntity vUserEntity = requestWrapper.getData();
        List<VUserEntity> resultList =
            vUserService.selectList(vUserEntity);

        return ReplyResponse.ok(resultList);
    }

    @ApiOperation(value = "明细记录", notes = "detail")
    @PostMapping("/detail")
    public ReplyResponse<VUserEntity> detail(
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
        VUserEntity result = vUserService.getById(requestWrapper.getData());
        return ReplyResponse.ok(result);
    }

}
