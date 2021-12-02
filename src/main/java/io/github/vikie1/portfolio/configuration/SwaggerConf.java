package io.github.vikie1.portfolio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.vikie1.portfolio"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(metaData());
    }
    private ApiInfo metaData(){
        return new ApiInfoBuilder().title("Victor Mwangi Portfolio REST doc")
                .contact(new Contact("Victor Mwangi", "https://victormwangi.netlify.app/contacts", "mwangivictor52@gmail.com"))
                .version("3.0.3")
                .build();
    }
}
