package sonny.kotlinspringprac.web.req

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

data class UserRequest(
    @get:NotBlank(message = "아이디를 입력해주세요.")
    @get:Pattern(regexp = "^[a-zA-Z0-9]+\$", message = "아이디 형식을 입력해주세요")
    val id: String,

    @get:NotBlank(message = "이름을 입력해주세요.")
    val name: String,

    @get:Positive(message = "양수를 입력해주세요.")
    val age: Int,

    @get:NotBlank(message = "이메일을 입력해주세요.")
    @get:Pattern(regexp = "^[a-z0-9_+.-]+@([a-z0-9-]+\\.)+[a-z0-9]{2,4}\$", message = "이메일 형식을 입력해주세요")
    val email: String,
)