package pl.cyganki.utils.security.dto

import java.io.Serializable

/**
 *  Class responsible for containing roles
 *  This is not DB ENTITY! It's based on db but it isn't persistent.
 *  We use it to send roles in user in this form between microservices
 */
data class Role(var id: Long = 0, var name: String = ""): Serializable {

    companion object {
        private const val serialVersionUID = -2218766928232301109L
    }

    override fun toString() = "{\"id\": $id, \"name\": \"$name\"}"
}