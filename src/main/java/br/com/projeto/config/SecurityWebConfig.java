package br.com.projeto.config;

import br.com.projeto.security.ProjetoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ProjetoDetailsService projetoDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").hasRole("padrao")
            .antMatchers("/funcionario/list").hasRole("padrao")
            .and()

            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(projetoDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    // public static void main(String[]args){
    //     System.out.println(new BCryptPasswordEncoder().encode("123"));
    // }

}
