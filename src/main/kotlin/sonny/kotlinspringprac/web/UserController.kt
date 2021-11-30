package sonny.kotlinspringprac.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sonny.kotlinspringprac.service.UserService
import sonny.kotlinspringprac.web.req.UserRequest

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/join")
    fun join(
        @RequestBody reqeust: UserRequest
    ) {
        userService.createUser(reqeust)
    }
}