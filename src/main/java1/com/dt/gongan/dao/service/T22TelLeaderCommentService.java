package com.dt.gongan.dao.service;

import com.dt.gongan.dao.entity.T22TelLeaderCommentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 电话申请的领导批示 服务类
 * </p>
 *
 * @author 铠甲勇士
 * @since 2021-07-02
 */
public interface T22TelLeaderCommentService extends IService<T22TelLeaderCommentEntity> {
    IPage<T22TelLeaderCommentEntity> selectPage(IPage<T22TelLeaderCommentEntity> page, T22TelLeaderCommentEntity t22TelLeaderCommentEntity);

    List<T22TelLeaderCommentEntity> selectList(T22TelLeaderCommentEntity t22TelLeaderCommentEntity);

    void insert(T22TelLeaderCommentEntity o);

    void insert(List<T22TelLeaderCommentEntity> list);

    void update(T22TelLeaderCommentEntity o);

    void addTestData();

}
