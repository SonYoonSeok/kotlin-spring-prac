package sonny.kotlinspringprac.web.res

data class UserResponse(
    val id: String,
    val name: String,
    val age: Long,
    val email: String,
)