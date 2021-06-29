package com.dt.gongan.dao.service.impl;

import com.dt.gongan.dao.entity.T18SysUpdateEntity;
import com.dt.gongan.dao.mapper.T18SysUpdateMapper;
import com.dt.gongan.dao.service.T18SysUpdateService;
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
 * 热线信息表 服务实现类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-29
 */
@Slf4j
@Service
public class T18SysUpdateServiceImpl extends ServiceImpl<T18SysUpdateMapper, T18SysUpdateEntity> implements T18SysUpdateService {
    @Override
    public IPage<T18SysUpdateEntity> selectPage(IPage<T18SysUpdateEntity> page, T18SysUpdateEntity t18SysUpdateEntity){
        return page(page, getSelectQueryWrapper(t18SysUpdateEntity));
    }

    @Override
    public List<T18SysUpdateEntity> selectList(T18SysUpdateEntity t18SysUpdateEntity){
        return list(getSelectQueryWrapper(t18SysUpdateEntity));
    }

    @Override
    public void insert(T18SysUpdateEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isBlank(o.getUpdateTime())){
            o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        }
        save(o);
    }

    @Override
        public void insert(List<T18SysUpdateEntity> list){
            for(T18SysUpdateEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T18SysUpdateEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T18SysUpdateEntity> getSelectQueryWrapper(T18SysUpdateEntity t18SysUpdateEntity){
        QueryWrapper<T18SysUpdateEntity> queryWrapper = new QueryWrapper<>();
        if(t18SysUpdateEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //自增id id bigint(20) id Long
        //日期 record_day varchar(20) recordDay String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getRecordDay())){
            queryWrapper.eq("record_day", t18SysUpdateEntity.getRecordDay());
        }
        //模块 module_name varchar(255) moduleName String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getModuleName())){
            queryWrapper.eq("module_name", t18SysUpdateEntity.getModuleName());
        }
        //描述 description varchar(2000) description String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getDescription())){
            queryWrapper.eq("description", t18SysUpdateEntity.getDescription());
        }
        //类型 type varchar(30) type String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getType())){
            queryWrapper.eq("type", t18SysUpdateEntity.getType());
        }
        //排序字段 sort int(11) sort Integer
        if(t18SysUpdateEntity.getSort() != null){
            queryWrapper.eq("sort", t18SysUpdateEntity.getSort());
        }
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getCreateTime())){
            queryWrapper.eq("create_time", t18SysUpdateEntity.getCreateTime());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getUpdateTime())){
            queryWrapper.eq("update_time", t18SysUpdateEntity.getUpdateTime());
        }
        //删除标记 del_flag char(1) delFlag String
        if(StringUtils.isNotBlank(t18SysUpdateEntity.getDelFlag())){
            queryWrapper.eq("del_flag", t18SysUpdateEntity.getDelFlag());
        }
        queryWrapper.orderByDesc("update_time");
        return queryWrapper;
    }

    @Override
    public void addTestData(){
        for(int i=0; i<30; i++){
            addOneTestData(i);
        }
    }

    private void addOneTestData(int i) {
        T18SysUpdateEntity o = new T18SysUpdateEntity();

        //自增id id bigint(20) id Long

        //日期 record_day varchar(20) recordDay String
        o.setRecordDay("recordDay");

        //模块 module_name varchar(255) moduleName String
        o.setModuleName("moduleName");

        //描述 description varchar(2000) description String
        o.setDescription("description");

        //类型 type varchar(30) type String
        o.setType("type");

        //排序字段 sort int(11) sort Integer
        o.setSort(111 + i);

        //创建时间 create_time char(19) createTime String

        //更新时间 update_time char(19) updateTime String

        //删除标记 del_flag char(1) delFlag String

        insert(o);
    }


}
