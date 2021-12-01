package sonny.kotlinspringprac.repository

import org.springframework.data.repository.CrudRepository
import sonny.kotlinspringprac.domain.Post

interface PostRepository : CrudRepository<Post, Long> {
    fun findByAuthor(authorName: String): MutableList<Post>?
}