package io.github.vikie1.portfolio.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConf {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Victor Mwangi Portfolio REST API")
                        .description("Victor Mwangi Portfolio REST API")
                        .version("3.1.0"));
    }

    @Bean
    GroupedOpenApi personGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/admin/**")
                .build();
    }

    @Bean
    GroupedOpenApi userGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Api Access")
                .pathsToMatch("/api/**")
                .build();
    }
}
