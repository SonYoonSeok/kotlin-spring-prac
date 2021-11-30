package sonny.kotlinspringprac.repository

import org.springframework.data.repository.CrudRepository
import sonny.kotlinspringprac.domain.User

interface UserRepository : CrudRepository<User, Long> {
    fun findUserById(id: String): User?
}