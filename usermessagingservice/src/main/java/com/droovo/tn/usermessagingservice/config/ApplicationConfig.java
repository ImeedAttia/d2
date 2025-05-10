package com.droovo.tn.usermessagingservice.config;

<<<<<<< HEAD
=======
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
>>>>>>> rebuild
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< HEAD
import com.droovo.tn.usermessagingservice.Repositories.UtilisateurRepository;
=======
>>>>>>> rebuild

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
<<<<<<< HEAD
    private final UtilisateurRepository utilisateurRepository;
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> utilisateurRepository.findByEmail(username)
=======
    private final UserDetailRepository userDetailRepository;
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDetailRepository.findByEmail(username)
>>>>>>> rebuild
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
