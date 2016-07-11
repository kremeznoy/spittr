package ua.krem.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Description:
 * <p/>
 * -----------------------------------------------------
 * Created by kremezniy on 7/6/2016.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin().and().httpBasic();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/spitter/me").hasRole("SPITTER")
                .antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
                .anyRequest().permitAll()
                .and()
                .requiresChannel().antMatchers("/spitter/form").requiresSecure();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("pwd").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
}
