package com.example.Security2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/testcode/**").hasAuthority("qa")
                .antMatchers("/developcode/**").hasAuthority("dev")
                .antMatchers("/accessserver/**").hasAnyAuthority("qa", "dev")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }
    @Bean
    PasswordEncoder getPE()
    {
        return new BCryptPasswordEncoder();
    }
    // 2 Apples 1 apple is stale and 1 is fresh
    // 1 whole Apple and 1 apple juice

    //1 rp, 1ep
    // 2 rp
    // 2 ep


    /*
        UserDetailsService: Service used to get the user's information
        UserDetails:
        UsernamePasswordAuthenticationFilter
        In memory authentication --> userpasswordauthenticationfilter
            getting the user details from some class which is getting the info from memory
        userDetailsServiceAuthentication --> userpasswordauthenticationfilter
            getting the user details from our custom class which is getting from external data source

        org.springframework.security.core.userdetails.User
     */

    //dev --> deploying monitoring, maintenance
    //QA --> monitoring, load_testing, performance_testing

    /*role based access --> your ant matchers can have multiple roles for a set of APIs
                            and your user in DB will have multiple roles in the authority's column

    action based access --> your ant matchers will have only 1 action for a set of APIs and your user in
                        DB will have multiple actions in the authority's column
      */
}
