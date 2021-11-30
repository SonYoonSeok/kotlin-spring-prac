package sonny.kotlinspringprac.domain

import lombok.AccessLevel
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
data class User(
    @Id
    val id: String,
    val name: String,
    val age: Long,
    val email: String
)
