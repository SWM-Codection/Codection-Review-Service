package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ReviewController {

    @GetMapping("/health-check")
    @ResponseStatus(HttpStatus.OK)
    fun status(request: HttpServletRequest): String {
        return "It's working in User Service on Port ${request.serverPort}"
    }
}
