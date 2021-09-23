package com.dt.gen.main;

import com.dt.gen.conf.DtdataPackageConfigBuilder;
import com.dt.gen.conf.GaSysPackageConfigBuilder;
import com.dt.gen.conf.GongAn01PackageConfigBuilder;
import com.dt.gen.conf.NewDtdataPackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.conf.ZjscreemPackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableCodeGenMain {

    public static void main(String[] args) {

        PackageConfigBuilder builder = new DtdataPackageConfigBuilder();
        String tableNames = "t02_database_connectivity";

        log.info("table names: {}", tableNames);
        new CodeGenService("/template/").execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                tableNames);
    }


}