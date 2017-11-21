package pl.cyganki.utils.security.dto

import java.io.Serializable

/**
 *  Class responsible for storing current logged in user in session
 *  This is not DB ENTITY! It's based on db but it isn't persistent.
 *  We use it to send user in this form between microservices
 */
data class User(
        var id: Long = 0,
        var name: String = "",
        var roles: List<Role> = emptyList(),
        var enabled: Boolean = true
) : Serializable {

    companion object {
        private const val serialVersionUID = -3858804629202513129L
    }

    override fun toString() = "{\"id\": $id, \"name\": \"$name\", \"roles\": [${roles.joinToString(separator = ",")}], \"enabled\": $enabled}"
}