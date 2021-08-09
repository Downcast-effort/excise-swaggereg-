package com.dandelion.swaggereg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhanghab
 * @date 2021/8/9
 * @description:
 **/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {


    /**
     * 一般情况下测试环境不需要swagger
     * @return
     */
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处于自己设定的环境中
        boolean f = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(f)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dandelion.swaggereg.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("接口列表 v1.1.0")
                .description("接口测试")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .version("1.1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
