package io.github.vikie1.portfolio.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@CrossOrigin(origins = "https://victormwangi.netlify.app")
public class SecurityProtocals extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        //http.csrf().disable();
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/projects").hasRole("ROOT")
            .antMatchers(HttpMethod.DELETE, "/api/projects").hasRole("ROOT")
            .antMatchers(HttpMethod.DELETE, "/api/projects/**").hasRole("ROOT")
            .antMatchers(HttpMethod.POST, "/api/blog").hasRole("ROOT")
            .antMatchers(HttpMethod.DELETE, "/api/blog/**").hasRole("ROOT")
            .antMatchers(HttpMethod.DELETE, "/api/contact").hasRole("ROOT")
            .antMatchers(HttpMethod.POST, "/api/project/todolist").hasAnyRole("ADMIN","ROOT")
            .antMatchers(HttpMethod.DELETE, "/api/project/todolist/{id}").hasAnyRole("ADMIN","ROOT")
            .antMatchers(HttpMethod.GET, "/api/project/todolist").hasAnyRole("USER","ADMIN","ROOT")
            .antMatchers("/","/hi").permitAll()
            .antMatchers("/api/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return new SCryptPasswordEncoder(); }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
