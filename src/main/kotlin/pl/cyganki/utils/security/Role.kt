package pl.cyganki.utils.security

import java.io.Serializable


class Role(var id: Long, var name: String): Serializable {

    companion object {
        private const val serialVersionUID = -2218766928232301109L
    }
}