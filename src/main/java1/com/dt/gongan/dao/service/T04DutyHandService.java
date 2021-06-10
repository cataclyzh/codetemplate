package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T04DutyHandEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 交班记录 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
public interface T04DutyHandService extends IService<T04DutyHandEntity> {
    IPage<T04DutyHandEntity> selectPage(IPage<T04DutyHandEntity> page, T04DutyHandEntity t04DutyHandEntity);

    List<T04DutyHandEntity> selectList(T04DutyHandEntity t04DutyHandEntity);

    void insert(T04DutyHandEntity o);

    void insert(List<T04DutyHandEntity> list);

    void update(T04DutyHandEntity o);

    void addTestData();
}
