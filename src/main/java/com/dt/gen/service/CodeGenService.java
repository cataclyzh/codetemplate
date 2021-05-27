package com.dt.gen.service;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 * @author 古米
 * @since 20/11/24
 */
@Slf4j
public class CodeGenService {

    private String projectPath = System.getProperty("user.dir").replace("\\", "/");

    public void execute(PackageConfig packageConfig, DataSourceConfig dataSourceConfig, String includeTableNames) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setSwagger2(true);

        String outputBaseDir = projectPath + "/src/main/java1/";
        gc.setOutputDir(outputBaseDir);
        gc.setAuthor("铠甲勇士");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setEntityName("%sEntity");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dataSourceConfig);
        mpg.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                String moduleName = packageConfig.getModuleName();
                String outputFileStr = outputBaseDir
                        + packageConfig.getParent().replace(".","/")
                        + "/dao/sqlmapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                log.info("outputFileStr: " + outputFileStr);
                return outputFileStr;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setService(null);
        templateConfig.setController( getTemplateBasepath() +"controller.java");
        templateConfig.setEntity(getTemplateBasepath() + "entity.java");
        templateConfig.setService(getTemplateBasepath() + "service.java");
        templateConfig.setServiceImpl(getTemplateBasepath() + "serviceImpl.java");
        templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        if (includeTableNames != null) {
            strategy.setInclude(includeTableNames.split(","));
        }
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private String getTemplateBasepath(){
//        return projectPath + "/src/main/java/template/";
        return "/template/";
    }

}
