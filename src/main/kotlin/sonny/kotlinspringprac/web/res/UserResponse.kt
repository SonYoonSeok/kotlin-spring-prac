package sonny.kotlinspringprac.web.res

import sonny.kotlinspringprac.domain.Post

data class UserResponse(
    val id: String,
    val name: String,
    val age: Long,
    val email: String,
    val posts: List<Post>? = null,
)