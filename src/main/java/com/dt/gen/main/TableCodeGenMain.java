package com.dt.gen.main;

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

//        PackageConfigBuilder builder = new NewDtdataPackageConfigBuilder();
        PackageConfigBuilder builder = new GongAn01PackageConfigBuilder();
//        PackageConfigBuilder builder = new GaSysPackageConfigBuilder();

        String tableNames = builder.getTableNameStrFromFile("d:/ff/table-names.txt");

//        tableNames = "sys_user,sys_user_role";
//        tableNames = "t21_leader_comment";
//        tableNames = "t25_sjhc_record_info";
//        tableNames = "t23_sjhc,t24_sjhc_record,t25_sjhc_record_info";
//        tableNames = "t26_sjdd,t27_sjdd_record,t28_sjdd_record_info";
        tableNames = "t29_sjhc,t30_sjhc_sub1,t31_sjhc_sub2";
        log.info("table names: {}", tableNames);
        new CodeGenService("/template/").execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                tableNames);
    }


}