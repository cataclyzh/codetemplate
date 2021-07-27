package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.VUserEntity;
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
public interface VUserService extends IService<VUserEntity> {
    IPage<VUserEntity> selectPage(IPage<VUserEntity> page, VUserEntity vUserEntity);

    List<VUserEntity> selectList(VUserEntity vUserEntity);

}
