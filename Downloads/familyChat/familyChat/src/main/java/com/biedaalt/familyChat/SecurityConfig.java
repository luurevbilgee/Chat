//package com.biedaalt.familyChat;
//
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////	
////	@Bean
////	public static PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
////	
//
//    
//   
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Your security configuration here
//    	http
//    	.csrf()
//    	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//    	.and()
//        .authorizeRequests()
//            .antMatchers("/", "/home", "/register","/register/save","/register.css"
//            		,"/home.css","/about"
//            		,"/image/**","view","edit","/delete/{id}","/edit/{id}","/edit/update","/profile/{id}"
//            		,"/about.css","chathome","/chat","/send/message","/chat.css","/processUserForm")
//            .permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/")
//            .permitAll();
//    	
//    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////        .inMemoryAuthentication()
////        .withUser("user")
////        .password("{noo}password");
////    }
//
////    @Bean
////    public UserDetailsService inMemoryUserDetailsManager() {
////        UserDetails user = User.builder()
////            .username("user")
////            .password(passwordEncoder().encode("password"))
////            .roles("USER")
////            .build();
////
////        return new InMemoryUserDetailsManager(user);
////    }
//}
//
