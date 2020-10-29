package com.course.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .build()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/authenticate-user")
                , regex("/sayone/service/courses.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Course Detail API")
                .description("SAyOne AssignMent 2")
                .termsOfServiceUrl("Coolminds@coolmindsinc.com")
                .contact("Coolminds@coolmindsinc.com").license("Collminds License")
                .licenseUrl("Coolminds@coolmindsinc.com").version("1.0").build();
    }

}