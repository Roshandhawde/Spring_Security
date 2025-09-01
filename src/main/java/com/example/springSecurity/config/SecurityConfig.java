package com.example.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(cust-> cust.disable());
//        httpSecurity.authorizeHttpRequests(req->req.anyRequest().authenticated());
// //httpSecurity.formLogin(Customizer.withDefaults());
// httpSecurity.httpBasic(Customizer.withDefaults());
// httpSecurity.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
// imperative Way
//        Customizer<CsrfConfigurer<HttpSecurity>> customizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };

       return httpSecurity.csrf(cust -> cust.disable())
                .authorizeHttpRequests(req ->
                        req.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
//
//

//        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("roshan").password("qwerty").roles("USER").build();
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("Rakesh").password("qwerty").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


}
