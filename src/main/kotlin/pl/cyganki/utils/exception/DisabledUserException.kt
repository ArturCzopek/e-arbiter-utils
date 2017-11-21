package pl.cyganki.utils.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.LOCKED)
class DisabledUserException(userName: String): RuntimeException("$userName")