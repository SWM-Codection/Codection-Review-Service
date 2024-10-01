package swm.virtuoso.reviewservice.common.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.SpecVersion
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.responses.ApiResponse
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springdoc.core.utils.SpringDocAnnotationsUtils.extractSchema
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import swm.virtuoso.reviewservice.common.annotation.SwaggerResponse

@Configuration
class SwaggerResponseConfig {
    @Bean
    fun customGlobalHeaderOpenApiCustomizer(requestMappings: RequestMappingHandlerMapping) = OpenApiCustomizer { openApi ->
        requestMappings.handlerMethods
            .filter { (_,handlerMethod) -> handlerMethod.method.getAnnotationsByType(SwaggerResponse::class.java).isNotEmpty() }
            .forEach { (mappingInfo, handlerMethod) ->
                // Because I'm lazy person, this implementation only handles first mapping
                val pattern = mappingInfo.pathPatternsCondition?.patterns?.first()?.patternString
                val method = mappingInfo.methodsCondition.methods.first().asHttpMethod()
                val path = openApi.paths.filter { it.key == pattern }.values.first()
                val operation = when (method) {
                    HttpMethod.HEAD -> path.head
                    HttpMethod.GET -> path.get
                    HttpMethod.POST -> path.post
                    HttpMethod.PUT -> path.put
                    HttpMethod.PATCH -> path.patch
                    HttpMethod.DELETE -> path.delete
                    HttpMethod.OPTIONS -> path.options
                    HttpMethod.TRACE -> path.trace
                    else -> null
                }
                operation?.let {
                    val swaggerResponses = handlerMethod.method.getAnnotationsByType(SwaggerResponse::class.java)
                    swaggerResponses.forEach {
                        operation.responses
                            .addApiResponse(it.responseStatus, ApiResponse().apply {
                                val schema = extractSchema(Components(), it.responseType.java, null, arrayOf(), SpecVersion.V30)
                                description = it.description
                                content = Content().addMediaType("*/*", MediaType().schema(schema))
                            })
                    }
                }
            }
    }
}