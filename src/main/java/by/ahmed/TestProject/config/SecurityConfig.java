package by.ahmed.TestProject.config;

import by.ahmed.TestProject.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.Set;

import static by.ahmed.TestProject.entity.Role.ADMINISTRATOR;
import static by.ahmed.TestProject.entity.Role.VIEWER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final AccessDeniedHandler accessDeniedHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/login", "/registration").permitAll()
//                        .requestMatchers("/messages", "/messages/*", "/profile", "/profile/*", "/avatar")
//                        .hasAnyAuthority(VIEWER.getAuthority(), ADMINISTRATOR.getAuthority())
//                        .requestMatchers("/users", "/users/*").hasAnyAuthority(ADMINISTRATOR.getAuthority())
//                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .successHandler((request, response, authentication) -> {
//                            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//                            if (roles.contains(Role.ADMINISTRATOR.getAuthority())) {
//                                response.sendRedirect("/users");
//                            } else {
//                                response.sendRedirect("/profile");
//                            }
//                        })
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login")
//                        .deleteCookies("JSESSIONID"))
//                .exceptionHandling(config -> config.accessDeniedHandler(accessDeniedHandler));
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
}