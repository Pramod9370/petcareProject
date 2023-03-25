package com.harshad.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.harshad.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;

        @Autowired
        CustomUserDetailsService customUserDetailsService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .authorizeHttpRequests(authorize -> authorize
                                
                                                .antMatchers("/", "/shop/**","/contact", "/forgotpassword", "/register","/contact-show","shop/category/**",
                                                                 "/css/**","/admin/**","/disease/**","/productview/**",
                                                                "/assets/**", "/static/**", "/productImages/**","/register", "/register")
                                                .permitAll()
                                                .antMatchers("/admin/**").hasRole("ADMIN")
                                                .anyRequest().authenticated())
                                .formLogin(login -> login
                                                .loginPage("/login")
                                                .permitAll()
                                               .failureUrl("/login?error=true")
                                               .defaultSuccessUrl("/")
                                               .usernameParameter("email")
                                        .passwordParameter("password"))
                               .oauth2Login(oauth2 -> oauth2
                                  .loginPage("/login")
                                                .successHandler(googleOAuth2SuccessHandler))
                                .logout(logout -> logout
                                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                                .logoutSuccessUrl("/login")
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID"))
                                .exceptionHandling(exception -> exception
                                                .authenticationEntryPoint(
                                                                new LoginUrlAuthenticationEntryPoint("/login")))
                                .csrf(csrf -> csrf
                                                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                                .build();
        }

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

       //@Override
         protected void configure(AuthenticationManagerBuilder auth) throws Exception
         {
         auth.userDetailsService(customUserDetailsService);
         }

       // @Override
        public void configure(WebSecurity web) throws Exception {
                web.ignoring().antMatchers("/resource/**", "/static/**", "/images/**",
                                "/productImages/**", "/css/**","/assets/**",
                                "/js/**",
                                "/cart/**");
        }

        //
		
	//	 @Bean public ClientRegistrationRepository clientRegistrationRepository() {
	//	 ClientRegistration clientRegistration =
	//	 ClientRegistration.withRegistrationId("your-registration-id")
	//	 .clientId("your-client-id") .clientSecret("your-client-secret")
	//	 .redirectUri("your-redirect-uri")
	//	 .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) .build();
	//	 return new InMemoryClientRegistrationRepository(clientRegistration); }
		 
}
