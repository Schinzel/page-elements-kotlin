package io.schinzel.page_elements.web.response_handler_mapping

import dev.turingcomplete.textcaseconverter.StandardTextCases
import io.schinzel.page_elements.web.response_handlers.IResponseHandler
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun getConstructorParameters(clazz: KClass<out IResponseHandler>): List<Parameter> {
    // Get constructor parameters using Kotlin reflection
    val constructorParams = clazz.primaryConstructor?.parameters
    return (constructorParams
        ?.map { param ->
            // Convert parameter name to kebab case
            val parameterNameInKebabCase = StandardTextCases.SOFT_CAMEL_CASE
                .convertTo(StandardTextCases.KEBAB_CASE, param.name)
            Parameter(
                name = parameterNameInKebabCase,
                type = param.type
            )
        }
        ?: emptyList())
}