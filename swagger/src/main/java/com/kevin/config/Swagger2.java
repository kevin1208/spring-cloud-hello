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

    @Value("${swagger.basePackage:com.kevin.web}")
    private String basePackage;

    @Value("${swagger.title:请配置swagger.title}")
    private String title;
    @Value("${swagger.description:请配置swagger.description}")
    private String description;
    @Value("${swagger.termsOfServiceUrl:请配置swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    @Value("${swagger.contact.name:请配置swagger.contact.name}")
    private String contactName;
    @Value("${swagger.contact.url:请配置swagger.contact.url}")
    private String contactUrl;
    @Value("${swagger.contact.email:请配置swagger.contact.email}")
    private String contactEmail;
    @Value("${swagger.version:1.0}")
    private String version;

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
                .version(version)
                .build();
    }
    @Bean
    public Docket createRestApiDemo() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("swagger demo")
                .apiInfo(apiInfoDemo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kevin.demo.swagger.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfoDemo() {
        return new ApiInfoBuilder()
                .title("Swagger API 示例")
                .description("该组API的描述")
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version(version)
                .build();
    }

}
