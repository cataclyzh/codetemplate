package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.V30V31Entity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-26
 */
public interface V30V31Service extends IService<V30V31Entity> {
    IPage<V30V31Entity> selectPage(IPage<V30V31Entity> page, V30V31Entity v30V31Entity);

    List<V30V31Entity> selectList(V30V31Entity v30V31Entity);

}
