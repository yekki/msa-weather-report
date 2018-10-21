package me.yekki.weather.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"me.yekki.weather.controller"})
public class SwaggerConfiguration {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .pathMapping("/").select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("yekki", "gary.niu@gmail.com", "http://www.yekki.me");

        return new ApiInfoBuilder()
                .title("前台API接口")
                .description("前台API接口")
                .contact(contact)
                .version("0.0.1")
                .build();
    }
}
