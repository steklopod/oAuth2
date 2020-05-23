package online.colaba.oauth2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class OAuth2Application

fun main(args: Array<String>) {
    runApplication<OAuth2Application>(*args)
}


@RestController
class Controller {
    @GetMapping("/")
    fun helloWorld(): String {
        return "MAIN: you don't need to be logged in"
    }

    @GetMapping("/not-restricted")
    fun notRestricted(): String {
        return "not-restricted: you don't need to be logged in"
    }

    @GetMapping("/restricted")
    fun restricted(): String {
        return "if you see this you are logged in"
    }
}


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http
            .antMatcher("/**").authorizeRequests()
            .antMatchers(
                "/not-restricted"
            ).permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
    }
}
