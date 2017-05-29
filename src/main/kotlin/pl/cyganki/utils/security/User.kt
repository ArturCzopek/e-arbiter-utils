package pl.cyganki.utils.security

import java.io.Serializable

// Dummy constructor for serialization problems
data class User(var id: Long = 0, var name: String = "", var role: Role = Role(0, "")) : Serializable {

    companion object {
        private const val serialVersionUID = -3858804629202513129L
    }
}