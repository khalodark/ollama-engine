package com.khalodark.ollama.service

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import org.springframework.stereotype.Service

@Service
class MarkdownService {

    private val parser = Parser.builder().build()

    private val renderer = HtmlRenderer.builder().build()

    fun convert(markdown:String):String {

        val document = parser.parse(markdown)

        return renderer.render(document)

    }

}