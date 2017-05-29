package pl.cyganki.utils.swagger

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import springfox.documentation.annotations.ApiIgnore

@ApiIgnore
@Controller
@ConditionalOnProperty(value = "e-arbiter.swagger.enabled", matchIfMissing = true)
open class SwaggerController {

    @GetMapping(value = "\${e-arbiter.swagger.path:rest-api}")
    fun swaggerMapping():String {
        return SWAGGER_URL
    }

    companion object {
        val SWAGGER_URL = "redirect:/swagger-ui.html"
    }
}