package pl.cyganki.utils.annotation

import org.springframework.context.annotation.Import
import pl.cyganki.utils.admin.AdminServiceDataController

/**
 * Annotation which enables endpoint with data for proper microservice.
 * If you want to disable it for specified profile,
 * set e-arbiter.admin.service-data.enabled property on false
 *
 * @see pl.cyganki.utils.admin
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
@Import(AdminServiceDataController::class)
annotation class EnableArbiterAdminServiceData