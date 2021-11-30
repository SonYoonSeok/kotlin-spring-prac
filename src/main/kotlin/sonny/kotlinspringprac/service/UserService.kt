package sonny.kotlinspringprac.service

import org.springframework.stereotype.Service
import sonny.kotlinspringprac.domain.User
import sonny.kotlinspringprac.repository.UserRepository
import sonny.kotlinspringprac.web.req.UserRequest
import sonny.kotlinspringprac.web.res.UserResponse
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
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
        val user: User = userRepository.findUserById(userId)
        return UserResponse(
            id = user.id,
            name = user.name,
            age = user.age,
            email = user.email,
        )
    }
}