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

    private String templatePath;

    public CodeGenService(String templatePath){
        this.templatePath = templatePath;
    }

    private String projectPath = System.getProperty("user.dir").replace("\\", "/");

    public void execute(PackageConfig packageConfig, DataSourceConfig dataSourceConfig, String includeTableNames) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setSwagger2(true);

        String outputBaseDir = projectPath + "/src/main/java1/";
        globalConfig.setOutputDir(outputBaseDir);
        globalConfig.setAuthor("铠甲");
        globalConfig.setOpen(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setEntityName("%sEntity");
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true);
        // XML 二级缓存
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
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
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        // 自定义配置会被优先输出
        fileOutConfigList.add(new FileOutConfig(templatePath) {
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
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setService(null);
        templateConfig.setController( getTemplateBasepath() +"controller.java");
        templateConfig.setEntity(getTemplateBasepath() + "entity.java");
        templateConfig.setService(getTemplateBasepath() + "service.java");
        templateConfig.setServiceImpl(getTemplateBasepath() + "serviceImpl.java");
        templateConfig.setXml(null);

        autoGenerator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        if (includeTableNames != null) {
            strategyConfig.setInclude(includeTableNames.split(","));
        }
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");

        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

    private String getTemplateBasepath(){
//        return "/template/";
        return templatePath;
    }

}
