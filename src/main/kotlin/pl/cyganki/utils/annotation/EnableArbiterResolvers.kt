package pl.cyganki.utils.annotation

import org.springframework.context.annotation.Import
import pl.cyganki.utils.resolver.ResolverConfig
import pl.cyganki.utils.resolver.UserResolver

/**
 * Annotation which allows to use resolvers in application for methods.
 * This annotation should be add to root class of application
 *
 * @see pl.cyganki.utils.resolver
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(ResolverConfig::class, UserResolver::class)
annotation class EnableArbiterResolvers