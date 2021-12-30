package com.paatamikeladze.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

//Помечаем класс ответственный за конфигруацию security
//в котором пропишем данные
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //теперь спринг знает, что информацию нужно брать из бд
        auth.jdbcAuthentication().dataSource(dataSource);
    }
//Запрашивается авторизация для определенных юрл, к конкретным ролям
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("IT","Methodist","princess")
                .antMatchers("/hr_info").hasRole("princess")
                //две звездочки значит, на любой следующий адресс в этой ветке
                .antMatchers("/manger_info/**").hasRole("Methodist")
                //означает, что форма логина и пароля будет запрашиваться у всех
                .and().formLogin().permitAll();

    }
}
