package com.dtdream.ecd.codeGen.config;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dtdream.ecd.codeGen.utils.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class DataSourceConfigBuilder implements PackageConfigBuilder {
    PropertiesLoader propertiesLoader=new PropertiesLoader("application.properties");
    String dbName="gongan01";
    public DataSourceConfigBuilder(String dbName){
        this.dbName=dbName;
    }

    @Override
    public PackageConfig buildPackageConfig() {
        return getPackageConfig("dtdata", "dt");
    }

    @Override
    public DataSourceConfig buildDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(propertiesLoader.getProperty("database.driverClassName"));
        String url=propertiesLoader.getProperty("database.url");
        dsc.setUrl(String.format(url, dbName));
        dsc.setUsername(propertiesLoader.getProperty("database.username"));
        dsc.setPassword(propertiesLoader.getProperty("database.password"));
        return dsc;
    }
}
