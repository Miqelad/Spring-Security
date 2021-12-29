package com.paatamikeladze.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

//Помечаем класс ответственный за конфигруацию security
//в котором пропишем данные
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Дефолтное шифрование паролей
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        /*Метод говорит, что при проверке данных, необходимо сравнивать с данными
        * которые мы сейчас пропишем, они будут храниться в памяти, данный метод устаревший
        * удобнее хранить данные в БД, но сейчас мы делаем, для рассмотрения возможностей*/
        auth.inMemoryAuthentication()
                .withUser("paata").password("{noop}paata").roles("IT");
        auth.inMemoryAuthentication()
                .withUser("vera").password("{noop}vera").roles("Methodist");
        auth.inMemoryAuthentication()
                .withUser("alisa").password("{noop}alisa").roles("princess");


    }
}
