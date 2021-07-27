package com.dt.gen.main;

import com.dt.gen.conf.GongAn01PackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewCodeGenMain {

    public static void main(String[] args) {

        PackageConfigBuilder builder = new GongAn01PackageConfigBuilder();
        String tableNames = "v_user,v29_v30,v30_v31,v31_sjhc_sub2";
        log.info("table names: {}", tableNames);
        new CodeGenService("/template_v/").execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                tableNames);
    }


}