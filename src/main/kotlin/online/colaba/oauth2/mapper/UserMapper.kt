package online.colaba.oauth2.mapper

import org.slf4j.LoggerFactory
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority


object PrincipalExtractor {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun userMapper(): GrantedAuthoritiesMapper = GrantedAuthoritiesMapper { authorities: Collection<GrantedAuthority> ->
        System.err.println("\n AUTHORITIES:")
        authorities.forEach { println(it) }

        val mappedAuthorities = emptySet<GrantedAuthority>()

        authorities.forEach { authority ->
            if (authority is OidcUserAuthority) {
                logger.warn("1) authority is OidcUserAuthority: \n $authority")

                val idToken = authority.idToken
                val userInfo = authority.userInfo
                // TODO: Map the claims found in idToken and/or userInfo (to one or more GrantedAuthority's and add it to mappedAuthorities)

            } else if (authority is OAuth2UserAuthority) {
                logger.error("2) authority is OAuth2UserAuthority: \n $authority")

                val userAttributes = authority.attributes
                // TODO: Map the attributes found in userAttributes
            }
        }
        mappedAuthorities
    }
}

