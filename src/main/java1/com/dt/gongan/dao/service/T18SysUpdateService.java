package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T18SysUpdateEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 热线信息表 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-29
 */
public interface T18SysUpdateService extends IService<T18SysUpdateEntity> {
    IPage<T18SysUpdateEntity> selectPage(IPage<T18SysUpdateEntity> page, T18SysUpdateEntity t18SysUpdateEntity);

    List<T18SysUpdateEntity> selectList(T18SysUpdateEntity t18SysUpdateEntity);

    void insert(T18SysUpdateEntity o);

    void insert(List<T18SysUpdateEntity> list);

    void update(T18SysUpdateEntity o);

    void addTestData();
}
