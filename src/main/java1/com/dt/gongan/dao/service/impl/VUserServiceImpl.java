package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.VUserEntity;
import com.dt.gongan.dao.mapper.VUserMapper;
import com.dt.gongan.dao.service.VUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.dt.core.tools.MyDateUtil;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-26
 */
@Slf4j
@Service
public class VUserServiceImpl extends ServiceImpl<VUserMapper, VUserEntity> implements VUserService {
    @Override
    public IPage<VUserEntity> selectPage(IPage<VUserEntity> page, VUserEntity vUserEntity){
        return page(page, getSelectQueryWrapper(vUserEntity));
    }

    @Override
    public List<VUserEntity> selectList(VUserEntity vUserEntity){
        return list(getSelectQueryWrapper(vUserEntity));
    }

    private QueryWrapper<VUserEntity> getSelectQueryWrapper(VUserEntity vUserEntity){
        QueryWrapper<VUserEntity> queryWrapper = new QueryWrapper<>();
        if(vUserEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        if(vUserEntity.getUserId() != null){
            queryWrapper.eq("user_id", vUserEntity.getUserId());
        }
        if(StringUtils.isNotBlank(vUserEntity.getUserName())){
            queryWrapper.eq("user_name", vUserEntity.getUserName());
        }
        if(StringUtils.isNotBlank(vUserEntity.getMobile())){
            queryWrapper.eq("mobile", vUserEntity.getMobile());
        }
        //编号 org_id bigint(20) orgId Long
        if(vUserEntity.getOrgId() != null){
            queryWrapper.eq("org_id", vUserEntity.getOrgId());
        }
        //机构名称 org_name varchar(64) orgName String
        if(StringUtils.isNotBlank(vUserEntity.getOrgName())){
            queryWrapper.eq("org_name", vUserEntity.getOrgName());
        }
        //机构类型 org_type varchar(64) orgType String
        if(StringUtils.isNotBlank(vUserEntity.getOrgType())){
            queryWrapper.eq("org_type", vUserEntity.getOrgType());
        }
        return queryWrapper;
    }

}
