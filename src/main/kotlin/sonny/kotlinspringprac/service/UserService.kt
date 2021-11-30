package sonny.kotlinspringprac.service

import org.springframework.stereotype.Service
import sonny.kotlinspringprac.domain.User
import sonny.kotlinspringprac.repository.UserRepository
import sonny.kotlinspringprac.web.req.UserRequest
import sonny.kotlinspringprac.web.res.UserResponse

@Service
class UserService(
    private val userRepository: UserRepository,
) {
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
}