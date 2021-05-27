package com.dt.gen.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class ZjscreemPackageConfigBuilder implements PackageConfigBuilder{

    @Override
    public PackageConfig buildPackageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zj");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setModuleName("screem");
//        pc.setModuleName("demo1");
        return pc;
    }

    @Override
    public DataSourceConfig buildDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://rm-bp10e72u12e9443m6mo.mysql.rds.aliyuncs.com:3306/zj_screem?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("mysqladmin");
        dsc.setPassword("DtDream@0209");
        return dsc;
    }
}
