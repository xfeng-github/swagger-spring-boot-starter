package org.xfeng.spring.boot.starter.swagger.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xfeng.spring.boot.starter.swagger.autoconfigure.properties.SwaggerProperties;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * SwaggerAutoConfigure
 *
 * @author xfeng
 * @version 1.0
 * @date 2021/5/31
 */
@Slf4j
@EnableSwagger2
@Configuration
@ConditionalOnClass({Swagger2Controller.class})
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerAutoConfigure {

    @Autowired
    private SwaggerProperties SwaggerProperties;

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        if(log.isInfoEnabled()){
            log.info("SwaggerProperties配置属性信息 : {}", SwaggerProperties);
        }

        String projectName = SwaggerProperties.getName() + "/" + SwaggerProperties.getModule();
        Contact contact = new Contact(projectName, SwaggerProperties.getUrl(), SwaggerProperties.getEmail());
        return new ApiInfoBuilder()
                .title(SwaggerProperties.getTitle())
                .description(SwaggerProperties.getDescription())
                .contact(contact)
                .version(SwaggerProperties.getVersion())
                .build();
    }


}

