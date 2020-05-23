package online.colaba.oauth2.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController("/")
class RootController {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun index(): String {
        log.warn("'/': ROOT≈")
        return "MAIN (root) controller path '/': \uD83D\uDC4D \uD83D\uDC4D \uD83D\uDC4D OK"
    }

    @GetMapping("/auth")
    fun index2(
    ): String {
        log.warn("'/AUTH': 2")
        return "/AUTH: 2 controller path '/': \uD83D\uDC4D  OK"
    }

    @GetMapping("/success")
    fun index3(
    ): String {
        log.warn("'/SUCCESS': 3")
        return "/SUCCESS: 3 controller path '/': \uD83D\uDC4D  OK"
    }
}
