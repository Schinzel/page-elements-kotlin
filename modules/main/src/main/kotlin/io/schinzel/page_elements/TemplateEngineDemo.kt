package io.schinzel.page_elements

import io.schinzel.page_elements.component.template_engine.TemplateEngineInfo

/**
 * Demo class showing usage of the template-engine module.
 */
class TemplateEngineDemo {
    companion object {
        fun printInfo() {
            println("===== Template Engine Information =====")
            println(TemplateEngineInfo.getInfo())
            println("======================================")
        }
    }
}