package com.proyectoEnigma;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/index").setViewName("index");
        registro.addViewController("/login").setViewName("/login");
        registro.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    //Este metodo la prox semana se borra...
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();

        UserDetails vendedor = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .build();

        UserDetails usuario = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(usuario, vendedor, admin);
    }

    @Bean
    public SecurityFilterChain
            securityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/",
                        "/index",
                        "/js/**",
                        "/webjars/**",
                        "/css/**",
                        "/carrito/**")
                .permitAll()
                .requestMatchers("/accesorios/listado",
                        "/servicios/listado",
                        "/carrito/listado",
                        "/servicios/inventarioServicios",
                        "/accesorios/inventarioAccesorios",
                        "/sucursales/listado",
                        "/conozcanos/listado"
                        
                )
                .hasRole("VENDEDOR")
                .requestMatchers("/accesorios/listado",
                        "/servicios/listado",
                        "/servicios/nuevo",
                        "/servicios/modificar/**",
                        "/servicios/eliminar/**",
                        "/servicios/guardar",
                        "/accesorios/nuevo",
                        "/servicios/inventarioServicios",
                        "/accesorios/inventarioAccesorios",
                        "/accesorios/modificar/**",
                        "/accesorios/eliminar/**",
                        "/accesorios/guardar",
                        "/pruebas/**")
                .hasRole("ADMIN")
        )
                .formLogin((form)
                        -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/", true))
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
