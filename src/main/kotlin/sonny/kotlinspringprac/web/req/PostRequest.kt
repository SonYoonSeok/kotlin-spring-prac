package sonny.kotlinspringprac.web.req

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank

data class PostRequest(
    val userId: String,

    @get:NotBlank(message = "제목을 입력하세요.")
    @get:Length(min = 2, max = 30, message = "길이가 2에서 30 사이여야 합니다.")
    val title: String,

    @get:NotBlank(message = "내용을 입력하세요.")
    @get:Length(max = 500, message = "최대길이는 500입니다.")
    val content: String,
)