package io.schinzel.web_blocks.web.request_handler

import io.javalin.http.Context
import io.schinzel.web_blocks.web.request_handler.log.LogEntry
import io.schinzel.web_blocks.web.routes.IRoute
import io.schinzel.web_blocks.web.routes.ReturnTypeEnum
import org.jsoup.Jsoup

/**
 * The purpose of this class is to send a response to a client
 */
suspend fun sendResponse(
    ctx: Context,
    route: IRoute,
    logEntry: LogEntry,
    returnType: ReturnTypeEnum,
    prettyFormatHtml: Boolean
) {
    // Now awaits the suspend function
    val response: Any = route.getResponse()
    // Send response
    when (returnType) {
        ReturnTypeEnum.HTML -> {
            val formattedHtml = if (prettyFormatHtml) {
                prettyFormatHtml(response as String)
            } else {
                response as String
            }
            ctx.html(formattedHtml)
        }

        ReturnTypeEnum.JSON -> {
            val responseObject = ApiResponse.Success(message = response)
            ctx.json(responseObject)
            logEntry.responseLog.response = responseObject
        }
    }
}

private fun prettyFormatHtml(htmlString: String): String {
    val document = Jsoup.parse(htmlString)
    document.outputSettings()
        .prettyPrint(true)
        .indentAmount(2)
    return document.outerHtml()
}
