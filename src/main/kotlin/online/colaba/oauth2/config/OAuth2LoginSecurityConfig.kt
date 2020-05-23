package online.colaba.oauth2.config

import online.colaba.oauth2.mapper.PrincipalExtractor.userMapper
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke


@EnableWebSecurity
class OAuth2LoginSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http {
            authorizeRequests {
                authorize(anyRequest, authenticated)
            }
            oauth2Login {

                userInfoEndpoint {
                    userAuthoritiesMapper = userMapper()
                }
                defaultSuccessUrl("/success", true)
            }
        }

//            .redirectionEndpoint()
//            .baseUri("/auth")

    }


}
