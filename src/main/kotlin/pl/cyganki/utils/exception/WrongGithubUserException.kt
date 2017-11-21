package pl.cyganki.utils.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class WrongGithubUserException: RuntimeException("User doesn't exist in GitHub or didn't log in properly!")