package com.dt.gen.main;

import com.dt.gen.conf.NewDtdataPackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.conf.ZjscreemPackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeGenMain {

    public static void main(String[] args) {

        PackageConfigBuilder builder = new NewDtdataPackageConfigBuilder();
//        PackageConfigBuilder builder = new ZjscreemPackageConfigBuilder();

        String tableNames = builder.getTableNameStrFromFile("d:/ff/table-names.txt");

//        tableNames = "view04_database_evaluation_connectivity_exception";
        log.info("table names: {}", tableNames);
        new CodeGenService().execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                tableNames);
    }


}