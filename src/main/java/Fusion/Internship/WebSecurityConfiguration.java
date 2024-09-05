package Fusion.Internship;

import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.configurers.oauth2.client.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/Home.jsp", "/incorrectLogin.jsp", "/Welcome.jsp", "/resources/**", "/login",
                        "/GoogleLogin", "/static/**")
                .permitAll()
                .antMatchers("/AllUserPage").authenticated()
                .anyRequest().authenticated()
                .and()
                .oauth2Login().defaultSuccessUrl("/GoogleLogin", true)
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

}
