package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T03DutyEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 值班记录 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
public interface T03DutyService extends IService<T03DutyEntity> {
    IPage<T03DutyEntity> selectPage(IPage<T03DutyEntity> page, T03DutyEntity t03DutyEntity);

    List<T03DutyEntity> selectList(T03DutyEntity t03DutyEntity);

    void insert(T03DutyEntity o);

    void insert(List<T03DutyEntity> list);

    void update(T03DutyEntity o);

    void addTestData();
}
