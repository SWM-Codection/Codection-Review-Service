package swm.virtuoso.reviewservice.common.annotation

import kotlin.reflect.KClass

@Repeatable
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class SwaggerResponse(
    val responseStatus: String,
    val description: String,
    val responseType: KClass<*> = Void::class
)