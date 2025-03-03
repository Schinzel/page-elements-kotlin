package io.schinzel.page_elements.component.template_engine

/**
 * Simple class to provide information about the template engine module.
 */
class TemplateEngineInfo {
    companion object {
        const val VERSION = "1.0.0"
        const val NAME = "Page Elements Template Engine"
        
        /**
         * @return Information about this module
         */
        fun getInfo(): String {
            return "$NAME v$VERSION"
        }
    }
}