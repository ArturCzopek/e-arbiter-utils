package pl.cyganki.utils.resolver

import com.fasterxml.jackson.databind.ObjectMapper
import mu.KLogging
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebArgumentResolver
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import pl.cyganki.utils.GlobalValues
import pl.cyganki.utils.exception.DisabledUserException
import pl.cyganki.utils.security.dto.User

/**
 * Class responsible for injecting user to method based on request
 * At this level, user can be fetched from request header, where user is passed as a JSON.
 * There, user is parsed and can be injected to the controller's method.
 *
 * To be able to use it, you need to add a proper annotation.
 *
 * @see pl.cyganki.utils.annotation.EnableArbiterResolvers
 *
 */
@Component
class UserResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter?) = parameter?.parameterType == User::class.java

    override fun resolveArgument(parameter: MethodParameter?, mavContainer: ModelAndViewContainer?,
                                 webRequest: NativeWebRequest?, binderFactory: WebDataBinderFactory?) =
            if (this.supportsParameter(parameter)) {
                with(ObjectMapper().readValue(webRequest?.getHeader(GlobalValues.USER_ATTR_KEY), User::class.java)) {
                    if (this.enabled) this else throw DisabledUserException(this.name)
                }
            } else {
                WebArgumentResolver.UNRESOLVED
            }

    companion object : KLogging()
}