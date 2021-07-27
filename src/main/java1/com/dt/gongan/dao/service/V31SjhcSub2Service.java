package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.V31SjhcSub2Entity;
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
public interface V31SjhcSub2Service extends IService<V31SjhcSub2Entity> {
    IPage<V31SjhcSub2Entity> selectPage(IPage<V31SjhcSub2Entity> page, V31SjhcSub2Entity v31SjhcSub2Entity);

    List<V31SjhcSub2Entity> selectList(V31SjhcSub2Entity v31SjhcSub2Entity);

}
