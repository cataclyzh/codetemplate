package com.dt.gen.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.extern.slf4j.Slf4j;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class GongAn01PackageConfigBuilder implements PackageConfigBuilder{

    @Override
    public PackageConfig buildPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.dt");
        pc.setEntity("dao.entity");
        pc.setService("dao.service");
        pc.setServiceImpl("dao.service.impl");
        pc.setController("dao.controller");
        pc.setMapper("dao.mapper");
        pc.setModuleName("gongan");
        return pc;
    }

    @Override
    public DataSourceConfig buildDataSourceConfig() {
        //dm_process
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://36.137.53.40:3306/gongan01?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("DtDream0209");
        return dsc;
    }
}
