package com.scrcu.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author: fengliang
 * @description: TODO
 * @date: 2023/10/12 14:27
 * @version: 1.0
 */
//@Configuration
//启用Swagger2配置
//@EnableSwagger2
public class SwaggerConfig {
    //配置Swagger2相关的bean
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //com包下所有的API都交给Swagger2管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any()).build();
    }
    //此处主要是API文档页面显示信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("AliyunECSAPI")
                .description("Project-ONE")
                .version("1.0")
                .build();
    }
}
