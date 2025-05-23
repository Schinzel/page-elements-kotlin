package io.schinzel.page_elements.samples.component.pages.landing

import io.schinzel.basic_utils_kotlin.println
import io.schinzel.page_elements.component.page.Page
import io.schinzel.page_elements.samples.component.pages.landing.greeting_pe.GreetingPe
import io.schinzel.page_elements.web.response_handlers.IPageResponseHandler

@Suppress("unused")
class LandingWebPage(userId: String = "") : IPageResponseHandler {
    init {
        "LandingPage created with userId: $userId".println()
    }

    override fun getResponse(): String {
        return Page()
            .setTitle("Welcome")
            .addRow()
            .addColumn(12)
            .addPageElement(GreetingPe())
            .getHtml()
    }
}
