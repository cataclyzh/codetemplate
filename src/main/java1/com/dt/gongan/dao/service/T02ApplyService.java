package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T02ApplyEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 申请记录 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-06-10
 */
public interface T02ApplyService extends IService<T02ApplyEntity> {
    IPage<T02ApplyEntity> selectPage(IPage<T02ApplyEntity> page, T02ApplyEntity t02ApplyEntity);

    List<T02ApplyEntity> selectList(T02ApplyEntity t02ApplyEntity);

    void insert(T02ApplyEntity o);

    void insert(List<T02ApplyEntity> list);

    void update(T02ApplyEntity o);

    void addTestData();
}
