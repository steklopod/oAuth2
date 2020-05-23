package online.colaba.oauth2

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class OAuth2Application

fun main(args: Array<String>) {
    runApplication<OAuth2Application>(*args)
}


@RestController("/")
class Controller {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun index(
//        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
//        @AuthenticationPrincipal OAuth2User oauth2User
    ): String {
        log.warn("ROOT ")
        return "MAIN (root) controller path '/': \uD83D\uDC4D \uD83D\uDC4D \uD83D\uDC4D OK"
    }


    @GetMapping("/auth")
    fun index2(
    ): String {
        log.warn("/auth: SECOND")
        return "2 controller path '/': \uD83D\uDC4D  OK"
    }


    @GetMapping("/success")
    fun index3(
    ): String {
        log.warn("/success: 3")
        return "3 controller path '/': \uD83D\uDC4D  OK"
    }


}


@EnableWebSecurity
class OAuth2LoginSecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http
            .oauth2Login()
            .defaultSuccessUrl("/success")
//            .redirectionEndpoint()
//            .baseUri("/auth")

    }
}
