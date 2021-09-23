package com.dt.gen.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/***
 * @author 古米
 * @since 20/11/24
 */
public interface PackageConfigBuilder {
    PackageConfig buildPackageConfig();

    DataSourceConfig buildDataSourceConfig();

    /**
     * 处理 table name 的获取
     *
     * @param filePath
     * @return
     */
    default String getTableNameStrFromFile(String filePath) {
        try {
            List<String> lineList = FileUtils.readLines(new File(filePath), "UTF-8");
            String s = StringUtils.join(lineList, ",");
            return s;
        } catch (IOException e) {
            throw new RuntimeException("读取文件出错", e);
        }
    }

    default PackageConfig getPackageConfig(String modelName, String companyName) {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com." + companyName);
        pc.setEntity("dao.entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        pc.setMapper("dao.mapper");
        pc.setModuleName(modelName);
        return pc;
    }
}
