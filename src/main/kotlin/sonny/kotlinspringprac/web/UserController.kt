package sonny.kotlinspringprac.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sonny.kotlinspringprac.service.UserService
import sonny.kotlinspringprac.web.req.UserRequest
import sonny.kotlinspringprac.web.res.UserResponse
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/join")
    fun join(
        @Valid @RequestBody reqeust: UserRequest,
    ): ResponseEntity<Any> {
        userService.createUser(reqeust)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/find")
    fun searchUser(
        @RequestParam("userId") id: String,
    ): UserResponse {
        return userService.findUser(id)
    }
}