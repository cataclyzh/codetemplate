package com.dt.gen.main;

import com.dt.gen.conf.DtdataPackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewCodeGenMain {

    public static void main(String[] args) {

        PackageConfigBuilder builder = new DtdataPackageConfigBuilder();
        String viewNames = "v_user,v_org";

        log.info("view names: {}", viewNames);
        new CodeGenService("/template_v/").execute(
                builder.buildPackageConfig(),
                builder.buildDataSourceConfig(),
                viewNames);
    }


}