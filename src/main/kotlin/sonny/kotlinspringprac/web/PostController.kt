package sonny.kotlinspringprac.web

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sonny.kotlinspringprac.service.PostService
import sonny.kotlinspringprac.service.UserService
import sonny.kotlinspringprac.web.req.PostRequest

@RestController
@RequestMapping("/post")
class PostController(
    private val userService: UserService,
    private val postService: PostService,
) {
    @PostMapping("/write")
    fun post(
        @RequestBody request: PostRequest,
    ): ResponseEntity<Any> {
        postService.createPost(request)
        return ResponseEntity(HttpStatus.CREATED)
    }
}