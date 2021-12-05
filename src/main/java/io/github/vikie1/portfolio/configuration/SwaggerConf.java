package io.github.vikie1.portfolio.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(tags = {
        @Tag(name = "API Documentation", description = "This is the Swagger-generated API documentation")
})
public class SwaggerConf {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Victor Mwangi Portfolio REST API")
                        .description("Victor Mwangi Portfolio REST API")
                        .version("3.0.0"));
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
