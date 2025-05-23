package io.schinzel.page_elements.web.response_handler_mapping

import io.schinzel.page_elements.web.response_handlers.ResponseHandlerDescriptorRegistry
import io.schinzel.page_elements.web.response_handlers.IResponseHandler
import io.schinzel.page_elements.web.response_handlers.ReturnTypeEnum
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor

/**
 * The purpose of this class to provide a mapping between
 * a response handler class and its path
 */
class ResponseHandlerMapping(
    val responseHandlerClass: KClass<out IResponseHandler>,
) {
    val parameters: List<Parameter> = getConstructorParameters(responseHandlerClass)
    val path: String

    // WebPage, API and so on
    val type: String
    val returnType: ReturnTypeEnum

    init {
        val responseHandlerDescriptor = ResponseHandlerDescriptorRegistry
            .getResponseHandlerDescriptor(responseHandlerClass)
        path = responseHandlerDescriptor.getRoutePath(responseHandlerClass)
        type = responseHandlerDescriptor.getTypeName()
        returnType = responseHandlerDescriptor.getReturnType()
    }

    fun getPrimaryConstructor(): KFunction<IResponseHandler> {
        return responseHandlerClass.primaryConstructor
            ?: throw IllegalStateException("No primary constructor found for ${responseHandlerClass.simpleName}")
    }

    override fun toString(): String {
        return "RouteMapping(type='$type', path='$path', parameters=$parameters)"
    }
}
