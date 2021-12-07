package sonny.kotlinspringprac.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import sonny.kotlinspringprac.domain.Post
import sonny.kotlinspringprac.domain.User
import sonny.kotlinspringprac.repository.PostRepository
import sonny.kotlinspringprac.repository.UserRepository
import sonny.kotlinspringprac.web.req.UserRequest
import sonny.kotlinspringprac.web.res.UserResponse
import javax.transaction.Transactional
import javax.validation.Valid

@Service
class UserService(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
) {
    @Transactional
    fun createUser(
        userRequest: UserRequest
    ) {
        userRepository.save(
            User(
                id = userRequest.id,
                name = userRequest.name,
                age = userRequest.age,
                email = userRequest.email,
            )
        )
    }

    fun findUser(
        userId: String
    ): UserResponse {
        val user: User =
            userRepository.findUserById(userId) ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "${userId}를 찾을 수 없습니다.",
            )
        val postList: List<Post>? = postRepository.findByAuthor(user.id)

        return UserResponse(
            id = user.id,
            name = user.name,
            age = user.age,
            email = user.email,
            posts = postList,
        )
    }
}