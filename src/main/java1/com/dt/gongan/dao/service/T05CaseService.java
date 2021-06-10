package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T05CaseEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 战果案例填报 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
public interface T05CaseService extends IService<T05CaseEntity> {
    IPage<T05CaseEntity> selectPage(IPage<T05CaseEntity> page, T05CaseEntity t05CaseEntity);

    List<T05CaseEntity> selectList(T05CaseEntity t05CaseEntity);

    void insert(T05CaseEntity o);

    void insert(List<T05CaseEntity> list);

    void update(T05CaseEntity o);

    void addTestData();
}
