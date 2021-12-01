package sonny.kotlinspringprac.web.req

import javax.validation.constraints.NotNull

data class PostRequest(
    @get:NotNull(message = "id를 입력하시오.")
    val userId: String,

    val title: String,

    val content: String,
)