package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.V01Test1Entity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-19
 */
public interface V01Test1Service extends IService<V01Test1Entity> {
    IPage<V01Test1Entity> selectPage(IPage<V01Test1Entity> page, V01Test1Entity v01Test1Entity);

    List<V01Test1Entity> selectList(V01Test1Entity v01Test1Entity);

    void insert(V01Test1Entity o);

    void insert(List<V01Test1Entity> list);

    void update(V01Test1Entity o);

    void addTestData();

}
