package io.schinzel.web_blocks.web.test_routes.pages.landing

import io.schinzel.web_blocks.web.routes.IPageRoute

@Suppress("unused")
class LandingPage : IPageRoute {
    override suspend fun getResponse(): String {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
               <meta charset="UTF-8">
               <title>Hello</title>
            </head>
            <body>
               <h1>Hello landing page!</h1>
            </body>
            </html>
        """.trimIndent()
    }
}