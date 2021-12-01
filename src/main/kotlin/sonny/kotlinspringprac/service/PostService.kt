package sonny.kotlinspringprac.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import sonny.kotlinspringprac.domain.Post
import sonny.kotlinspringprac.domain.User
import sonny.kotlinspringprac.repository.PostRepository
import sonny.kotlinspringprac.repository.UserRepository
import sonny.kotlinspringprac.web.req.PostRequest
import javax.transaction.Transactional

@Service
class PostService(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
) {
    @Transactional
    fun createPost(
        postRequest: PostRequest,
    ) {
        val user: User = userRepository.findUserById(postRequest.userId) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "${postRequest.userId}를 찾을 수 없습니다.",
        )
        val post: Post = postRepository.save(
            Post(
                title = postRequest.title,
                content = postRequest.content,
                author = postRequest.userId,
                user = user
            )
        )
        user.addPost(post)
    }
}