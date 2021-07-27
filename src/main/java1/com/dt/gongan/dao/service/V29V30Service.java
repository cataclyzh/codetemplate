package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.V29V30Entity;
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
public interface V29V30Service extends IService<V29V30Entity> {
    IPage<V29V30Entity> selectPage(IPage<V29V30Entity> page, V29V30Entity v29V30Entity);

    List<V29V30Entity> selectList(V29V30Entity v29V30Entity);

}
