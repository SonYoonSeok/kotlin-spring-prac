package sonny.kotlinspringprac.web.req

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class UserRequest(
    @get:NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]+\$", message = "정규표현식 = {^[a-zA-Z0-9]+\$}")
    val id: String,

    @get:NotNull
    val name: String,

    @get:NotNull
    val age: Long,

    @get:NotNull
    @Pattern(regexp = "^[a-z0-9_+.-]+@([a-z0-9-]+\\.)+[a-z0-9]{2,4}\$", message = "정규표현식 = {^[a-z0-9_+.-]+@([a-z0-9-]+\\.)+[a-z0-9]{2,4}\$}")
    val email: String,
)