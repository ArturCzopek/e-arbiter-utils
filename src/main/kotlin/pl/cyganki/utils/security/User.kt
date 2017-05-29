package pl.cyganki.utils.security

import java.io.Serializable


class User(var id: Long, var name: String, var role: Role) : Serializable {

    companion object {
        private const val serialVersionUID = -3858804629202513129L
    }
}