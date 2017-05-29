package pl.cyganki.utils.security

import java.io.Serializable

// Dummy constructor for serialization problems
data class Role(var id: Long = 0, var name: String = ""): Serializable {

    companion object {
        private const val serialVersionUID = -2218766928232301109L
    }
}