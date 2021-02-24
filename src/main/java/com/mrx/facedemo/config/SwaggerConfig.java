package com.mrx.facedemo.config;

import com.alibaba.druid.sql.visitor.functions.Concat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2  //开启swagger
public class SwaggerConfig {
    //配置swagger Docket 的bean实例
    //配置swagger Docket 对象属性，使其扫描指定包
    @Bean
    public Docket docket(Environment environment){
        //环境检测, Profiles profiles=Profiles.of("dev");  给定当前环境为dev
        Profiles profiles=Profiles.of("dev");
        //检测当前环境是否是给定环境
        boolean b =environment.acceptsProfiles(profiles);
        /*
        * 建造者模式
        * apis(RequestHandlerSelectors.basePackage(path)  扫描指定包路径)
        * PathSelectors.ant(path) 扫描指定路径*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //当为给定环境时swagger不使用
                .enable(b)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mrx.facedemo.controller"))
//                //.paths(PathSelectors.ant("/"))
                .build();
    }
    //更改api文档作者信息
    public ApiInfo apiInfo(){
        //初始化作者信息
        Contact contact = new Contact("张跃骞", "www.baidu.com", "123@qq.com");
        return new ApiInfo("张跃骞的Api", "人脸识别接口", "1.0", "urn:tos",contact , "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
