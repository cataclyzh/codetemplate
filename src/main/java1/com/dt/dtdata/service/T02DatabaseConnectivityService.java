package com.dt.dtdata.service;

import com.dt.dtdata.dao.entity.T02DatabaseConnectivityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 铠甲
 * @since 2021-09-22
 */
public interface T02DatabaseConnectivityService extends IService<T02DatabaseConnectivityEntity> {
    IPage<T02DatabaseConnectivityEntity> selectPage(IPage<T02DatabaseConnectivityEntity> page, T02DatabaseConnectivityEntity t02DatabaseConnectivityEntity);

    List<T02DatabaseConnectivityEntity> selectList(T02DatabaseConnectivityEntity t02DatabaseConnectivityEntity);

    void insert(T02DatabaseConnectivityEntity o);

    void insert(List<T02DatabaseConnectivityEntity> list);

    void update(T02DatabaseConnectivityEntity o);

    void addTestData();

}
