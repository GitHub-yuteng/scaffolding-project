package com.scaffolding.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author whh-yt
 */
public class MysqlGeneratorUtil {

    private final static String MYSQL_IP = "jdbc:mysql://101.33.241.122:3306/uc";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123456";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(MYSQL_IP, USERNAME, PASSWORD)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("Vm") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java/com/scaffolding/support"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.scaffolding")
                            .controller("")
                            .serviceImpl("")
                            .service("")
                            .mapper("")
                            .xml("");
                })
                // 模板配置
                .templateConfig(template ->{
                    //template.entity("/src/main/com/scaffolding/pojo/entity/");
                })
                // 策略
                .strategyConfig(builder -> {
                    builder.addInclude("uc_user");

                    builder.entityBuilder()
                            .enableLombok()
                            //.enableColumnConstant()// 字段常量
                            .enableRemoveIsPrefix()
                            .enableChainModel()
                            .disableSerialVersionUID()
                            //.enableTableFieldAnnotation()// @TableField("head_picture_link")
                            .naming(NamingStrategy.underline_to_camel)
                            .idType(IdType.AUTO)
                            .formatFileName("%sEntity");

                    // 取消生成 Controller 文件
                    builder.controllerBuilder().formatFileName("");
                    // 取消生成 Service ServiceImpl 文件
                    builder.serviceBuilder().formatServiceFileName("").formatServiceImplFileName("");
                    // 添加 mapper 注解
                    builder.mapperBuilder().enableMapperAnnotation().formatXmlFileName("");

                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
