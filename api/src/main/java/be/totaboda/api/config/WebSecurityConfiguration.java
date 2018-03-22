//package totaboda.config;

//import javax.inject.Named;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http //.headers().frameOptions().disable().and()
//                .authorizeRequests()
//                .antMatchers("/","/books/*","/login","/books","*").permitAll();
//                //.antMatchers("/users/members").hasAnyRole("ADMIN");
//    }
//
//    @Inject
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Admin").password("admin123").roles("ADMIN");
//    }
//    @Named
//    @Override
//    public UserDetailsService userDetailsService(){
//            Role role=Enum.valueOf(Role.class,"ROLE_ADMIN");
//            UserDetails user=
//            User.withUsername("ADMIN")
//            .password("password")
//            .roles("ADMIN")
//            .build();
//
//            return new InMemoryUserDetailsManager(Collections.singleton(user));
//     }
//}
