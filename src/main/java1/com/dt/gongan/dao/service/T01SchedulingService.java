package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T01SchedulingEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 排班信息 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
public interface T01SchedulingService extends IService<T01SchedulingEntity> {
    IPage<T01SchedulingEntity> selectPage(IPage<T01SchedulingEntity> page, T01SchedulingEntity t01SchedulingEntity);

    List<T01SchedulingEntity> selectList(T01SchedulingEntity t01SchedulingEntity);

    void insert(T01SchedulingEntity o);

    void insert(List<T01SchedulingEntity> list);

    void update(T01SchedulingEntity o);

    void addTestData();
}
