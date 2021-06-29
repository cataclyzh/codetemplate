package com.dt.gen.main;

import com.dt.gen.conf.GaSysPackageConfigBuilder;
import com.dt.gen.conf.GongAn01PackageConfigBuilder;
import com.dt.gen.conf.NewDtdataPackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.conf.ZjscreemPackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeGenMain {

    public static void main(String[] args) {

//        PackageConfigBuilder builder = new NewDtdataPackageConfigBuilder();
        PackageConfigBuilder builder = new GongAn01PackageConfigBuilder();
//        PackageConfigBuilder builder = new GaSysPackageConfigBuilder();

        String tableNames = builder.getTableNameStrFromFile("d:/ff/table-names.txt");

//        tableNames = "sys_user,sys_user_role";
        tableNames = "t18_sys_update";
//        tableNames = "t02_apply";
        log.info("table names: {}", tableNames);
        new CodeGenService().execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                tableNames);
    }


}