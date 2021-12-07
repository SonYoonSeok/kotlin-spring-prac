package sonny.kotlinspringprac.domain

import lombok.AccessLevel
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class User(
    @Id
    val id: String,

    val name: String,

    val age: Int,

    val email: String,

    @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL))
    val posts: MutableList<Post>? = null,
)