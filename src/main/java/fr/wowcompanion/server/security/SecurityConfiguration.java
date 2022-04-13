package fr.wowcompanion.server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**-
 * Class configuration used to configure spring security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected static final String[] PUBLIC_ENDPOINTS = new String[] {
        "/", "index.html", "/favicon.ico", "/*manifest.json", "workbox-*/*.js", "/*.js",
        "/*.png", "/static/**", "/*.svg", "/*.jpg"
    };

    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http
            .cors()
            .and().csrf().disable()
            .antMatcher("/**").authorizeRequests()
            .antMatchers(PUBLIC_ENDPOINTS).permitAll()
            .anyRequest().authenticated()
            .and().oauth2Login()
            .and().logout().logoutSuccessUrl("/");
    }
}