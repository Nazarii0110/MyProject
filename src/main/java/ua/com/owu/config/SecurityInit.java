package ua.com.owu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by User on 20.06.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
}
