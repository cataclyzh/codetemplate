package com.dt.gen.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.extern.slf4j.Slf4j;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class NewDtdataPackageConfigBuilder implements PackageConfigBuilder{

    @Override
    public PackageConfig buildPackageConfig() {
        return getPackageConfig("dtdata", "dt");
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
