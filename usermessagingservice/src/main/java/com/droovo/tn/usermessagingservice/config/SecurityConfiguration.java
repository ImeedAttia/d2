package com.droovo.tn.usermessagingservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {
            "/v1/auth/**",
            "/**"
    };

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
//                                .requestMatchers(PUT, "/Reclamation/**").hasAnyAuthority(TypeUser.RH.name(), TypeUser.EMPLOYE.name())
                                .requestMatchers(DELETE, "/Utilisateur/**").hasAnyAuthority(TypeUser.ADMIN.name())
                                .requestMatchers(PUT, "/Utilisateur/**").hasAnyAuthority(TypeUser.ADMIN.name())
                                .requestMatchers(PUT, "/FeedBack/**").hasAnyAuthority(TypeUser.ADMIN.name(),TypeUser.DRIVER.name())
                                .requestMatchers(DELETE, "/FeedBack/**").hasAnyAuthority(TypeUser.ADMIN.name())
                                .requestMatchers(DELETE, "/car/**").hasAnyAuthority(TypeUser.ADMIN.name())

                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}