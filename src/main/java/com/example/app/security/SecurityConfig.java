//package com.example.app.security;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
//import org.springframework.security.web.util.matcher.OrRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.POST;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    public static final String LOGIN = "/login";
//    public static final String USER = "/user";
//    public static final List<GrantedAuthority> DEFAULT_AUTHORITIES = List.of(new SimpleGrantedAuthority("USER"));
//
//    //Note: Сейчас разрешены:
//    // - GET('/api/users')
//    // - POST('/api/users')
//    // - POST('/api/login')
//    // - все запросы НЕ начинающиеся на '/api'
//
//    private final UserDetailsService userDetailsService;
//    private final JWTHelper jwtHelper;
//    private final String baseUrl;
//    private final RequestMatcher loginRequest;
//    private final RequestMatcher publicUrls;
//
//    public SecurityConfig(@Value("${base-url}") final String baseUrl,
//                          final UserDetailsService userDetailsService,
//                          final JWTHelper jwtHelper) {
//        this.baseUrl = baseUrl;
//        this.userDetailsService = userDetailsService;
//        this.jwtHelper = jwtHelper;
//        this.loginRequest = new AntPathRequestMatcher(baseUrl + LOGIN, POST.toString());
//        this.publicUrls = new OrRequestMatcher(
//                loginRequest,
//                new AntPathRequestMatcher(baseUrl + USER, POST.toString()),
//                new AntPathRequestMatcher(baseUrl + USER, GET.toString()),
//                new NegatedRequestMatcher(new AntPathRequestMatcher(baseUrl + "/**"))
//        );
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.
//                        requestMatchers(publicUrls).permitAll()
//                        .anyRequest().authenticated())
//                .addFilter(new JWTAuthenticationFilter(
//                        authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)),
//                        loginRequest,
//                        jwtHelper
//                ))
//                .addFilterBefore(
//                        new JWTAuthorizationFilter(publicUrls, jwtHelper),
//                        UsernamePasswordAuthenticationFilter.class
//                )
//                .formLogin(AbstractHttpConfigurer::disable)
//                .sessionManagement(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable)
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions.sameOrigin()))
//                .build();
//    }
//}
