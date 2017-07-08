package pl.cyganki.utils.annotation

import org.springframework.context.annotation.Import
import pl.cyganki.utils.h2.H2ConsoleMvcConfig

/**
 * Annotation which enables H2 Console in Spring MVC.
 * It will work only if H2 is enabled in Spring by property:
 * spring.h2.console.enabled: true.
 *
 * @see pl.cyganki.utils.h2
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(H2ConsoleMvcConfig::class)
annotation class EnableH2Console