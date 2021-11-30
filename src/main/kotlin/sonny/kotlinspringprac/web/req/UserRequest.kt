package sonny.kotlinspringprac.web.req

data class UserRequest(
    val id: String,
    val name: String,
    val age: Long,
    val email: String,
)
