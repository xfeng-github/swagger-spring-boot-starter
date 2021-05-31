package org.xfeng.spring.boot.starter.swagger.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SwaggerProperties 接口文档属性映射类
 *
 * @author xfeng
 * @version 1.0
 * @date 2021/5/31
 */
@Data
@ConfigurationProperties(prefix = "spring.swagger2")
public class SwaggerProperties {
    private String name;
    private String module;
    private String version;
    private String title;
    private String description;
    private String url;
    private String email;
    // 默认配置
    {
        this.name = "swagger-spring-boot-starter";
        this.module = "all";
        this.version = "0.0.1-SNAPSHOT";
        this.title = "由于你还没有配置swagger属性, 则使用本项目默认配置(配置只需在yaml文件(or properties文件)覆盖原有属性即可)";
        this.description = "由于你还没有配置swagger属性, 则使用本项目默认配置(配置只需在yaml文件(or properties文件)覆盖原有属性即可)";
        this.url = "#";
        this.email = "#";
    }

}

