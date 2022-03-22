package com.scaffolding.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author yt
 */
public class PgSqlGeneratorUtils {

    private final static String PGSQL_IP = "jdbc:postgresql://192.200.3.31:5432/wxscan_tst";
    private final static String USERNAME = "whh_dee";
    private final static String PASSWORD = "whh_dee201*";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(PGSQL_IP, USERNAME, PASSWORD)
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("Vm")
                            .fileOverride() // 覆盖已生成文件
                            .commentDate(com.whhim.hxh.util.DateUtils.DATE_TIME)
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.whhim.hxh")
                            .controller("")
                            .serviceImpl("")
                            .service("")
                            .entity("pojo.entity")
                            .mapper("mapper")
                            .xml("");
                })
                // 模板配置
                .templateConfig(template -> {
                    //template.entity("/src/main/com/scaffolding/pojo/entity/");
                })
                // 策略
                .strategyConfig(builder -> {
                    builder.addInclude("hxh_payment_bill");

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
