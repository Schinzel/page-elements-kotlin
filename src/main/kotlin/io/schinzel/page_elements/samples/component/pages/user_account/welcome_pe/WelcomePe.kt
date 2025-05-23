package io.schinzel.page_elements.samples.component.pages.user_account.welcome_pe

import io.schinzel.page_elements.component.page.ObservablePageElement
import io.schinzel.page_elements.samples.component.pages.user_account.NameDao

class WelcomePe(val userId: Int) : ObservablePageElement() {

    private val firstName = NameDao(userId).getFirstName()
    override fun getResponse(): String {
        return "<h1>Welcome $firstName</h1>"
    }
}