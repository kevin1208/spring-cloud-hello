package com.kevin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Kevin on 2018/1/5.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.basePackage}")
    private String basePackage = "com.kevin.web";

    @Value("${swagger.title}")
    private String title = "请配置swagger.title";
    @Value("${swagger.description}")
    private String description = "请配置swagger.description";
    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl = "请配置swagger.termsOfServiceUrl";
    @Value("${swagger.contact.name}")
    private String contactName = "请配置swagger.contact.name";
    @Value("${swagger.contact.url}")
    private String contactUrl = "请配置swagger.contact.url";
    @Value("${swagger.contact.email}")
    private String contactEmail = "请配置swagger.contact.email";
    @Value("${swagger.version}")
    private String version = "1.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version("1.0")
                .build();
    }

}
