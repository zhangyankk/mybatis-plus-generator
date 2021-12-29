import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FastAutoGeneratorTest {


    @Test
    public void fastAutoGeneratorTest2(){

        String url="jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai";
        String username="root";
        String password="xiaobai";


        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取系统当前路径
        //多模块当前模块路径
       /* String moduleProject = "fengtai-system";
        gc.setOutputDir(projectPath +"/"+moduleProject+ "/src/main/java");*/
        gc.setOutputDir(projectPath+"/src/main/java");
        //开启swagger2的@ApiModelProperty
        //gc.setSwagger2(true);
        gc.setAuthor("yan.zhang");
        //是否打开输出目录
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        /* dsc.setSchemaName("zbdb_fengtai");*/
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("core");
        pc.setParent("com.yanzhang");
        mpg.setPackageInfo(pc);

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
                /*return projectPath +"/"+moduleProject + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;*/
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        templatePath = "/templates/page.html.ftl";
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                /*return projectPath +"/"+moduleProject + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;*/
                return projectPath + "/src/main/resources/html/"
                        + "/" + tableInfo.getEntityName() + "Page.html";
            }
        });


        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        /*templateConfig.setEntity("templates/code/entity.java");
        templateConfig.setMapper("/templates/code/mapper.java");
        templateConfig.setService("/templates/code/service.java");
        templateConfig.setServiceImpl("/templates/code/serviceImpl.java");
        templateConfig.setController("/templates/code/controller.java");*/
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.no_change);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setSkipView(true);//跳过视图
        // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);//不启用 lombok
        strategy.setRestControllerStyle(true);
        // strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");


        //*********************************************************************************************
        //这边是输入表名,
        //strategy.setInclude("sys_user","sys_role");
        strategy.setInclude("user");
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();


        // 代码自动生成
        // https://blog.csdn.net/weixin_47827594/article/details/120648589

        // mybatis-plus3.3.1代码生成器自定义配置的使用方法
        // mapper模板中可以使用的属性可以参考源码中com.baomidou.mybatisplus.generator.config.po.TableInfo中的属性


    }



    @Test
    public void fastAutoGeneratorTest(){
        //mybatis-plus-generator 3.5.1 版本
//
//        String url="jdbc:mysql://127.0.0.1:3306/mydatabase?characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai";
//        String username="root";
//        String password="xiaobai";
//        FastAutoGenerator.create(url, username, password)
//                .globalConfig(builder -> {
//                    builder.author("baomidou") // 设置作者
//                            //.enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D://"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("user") // 设置需要生成的表名
//                    //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
//                    ;
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
    }




}
