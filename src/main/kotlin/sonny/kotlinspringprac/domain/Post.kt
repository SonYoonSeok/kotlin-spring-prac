package sonny.kotlinspringprac.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
    val author: String,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
) {
}