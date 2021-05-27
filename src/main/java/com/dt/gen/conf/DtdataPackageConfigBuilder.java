package com.dt.gen.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.extern.slf4j.Slf4j;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class DtdataPackageConfigBuilder implements PackageConfigBuilder {

    @Override
    public PackageConfig buildPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.dt");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setModuleName("dataquality");
//        pc.setModuleName("demo1");
        return pc;
    }

    @Override
    public DataSourceConfig buildDataSourceConfig() {
        //dm_process
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://rm-bp10e72u12e9443m6mo.mysql.rds.aliyuncs.com:3306/db_quality?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("mysqladmin");
        dsc.setPassword("DtDream@0209");
        return dsc;
    }
}
