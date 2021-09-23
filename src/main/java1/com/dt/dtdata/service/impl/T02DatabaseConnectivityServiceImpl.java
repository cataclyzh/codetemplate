package com.dt.dtdata.service.impl;

import com.dt.dtdata.dao.entity.T02DatabaseConnectivityEntity;
import com.dt.dtdata.dao.mapper.T02DatabaseConnectivityMapper;
import com.dt.dtdata.service.T02DatabaseConnectivityService;
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
 *  服务实现类
 * </p>
 *
 * @author 铠甲
 * @since 2021-09-22
 */
@Slf4j
@Service
public class T02DatabaseConnectivityServiceImpl extends ServiceImpl<T02DatabaseConnectivityMapper, T02DatabaseConnectivityEntity> implements T02DatabaseConnectivityService {
    @Override
    public IPage<T02DatabaseConnectivityEntity> selectPage(IPage<T02DatabaseConnectivityEntity> page, T02DatabaseConnectivityEntity t02DatabaseConnectivityEntity){
        return page(page, getSelectQueryWrapper(t02DatabaseConnectivityEntity));
    }

    @Override
    public List<T02DatabaseConnectivityEntity> selectList(T02DatabaseConnectivityEntity t02DatabaseConnectivityEntity){
        return list(getSelectQueryWrapper(t02DatabaseConnectivityEntity));
    }

    @Override
    public void insert(T02DatabaseConnectivityEntity o){
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
        public void insert(List<T02DatabaseConnectivityEntity> list){
            for(T02DatabaseConnectivityEntity o : list){
            insert(o);
        }
    }

    @Override
    public void update(T02DatabaseConnectivityEntity o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        updateById(o);
    }

    private QueryWrapper<T02DatabaseConnectivityEntity> getSelectQueryWrapper(T02DatabaseConnectivityEntity t02DatabaseConnectivityEntity){
        QueryWrapper<T02DatabaseConnectivityEntity> queryWrapper = new QueryWrapper<>();
        if(t02DatabaseConnectivityEntity == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        //数据库id database_id bigint(20) databaseId Long
        if(t02DatabaseConnectivityEntity.getDatabaseId() != null){
            queryWrapper.eq("database_id", t02DatabaseConnectivityEntity.getDatabaseId());
        }
        //可连接标志, 0:可连接, 1:不可连接 conn_flag tinyint(2) connFlag Integer
        if(t02DatabaseConnectivityEntity.getConnFlag() != null){
            queryWrapper.eq("conn_flag", t02DatabaseConnectivityEntity.getConnFlag());
        }
        //记录时间点 create_time char(19) createTime String
        if(StringUtils.isNotBlank(t02DatabaseConnectivityEntity.getCreateTime())){
            queryWrapper.eq("create_time", t02DatabaseConnectivityEntity.getCreateTime());
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
        T02DatabaseConnectivityEntity o = new T02DatabaseConnectivityEntity();


        //数据库id database_id bigint(20) databaseId Long
        o.setDatabaseId(222L + i);

        //可连接标志, 0:可连接, 1:不可连接 conn_flag tinyint(2) connFlag Integer
        o.setConnFlag(111 + i);

        //记录时间点 create_time char(19) createTime String

        insert(o);
    }


}
