package com.khalodark.ollama.controller

import com.khalodark.ollama.service.MarkdownService
import com.khalodark.ollama.service.OllamaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ChatController(
    private val ollamaService: OllamaService,
    private val markdownService: MarkdownService
) {

    @GetMapping("/")
    fun home(): String {

        return "index"

    }

    @PostMapping("/ask")
    fun ask(
        @RequestParam question: String,
        model: Model
    ): String {
        val markdownAnswer =
            ollamaService.ask(question)


        val htmlAnswer =
            markdownService.convert(markdownAnswer)


        model.addAttribute(
            "question",
            question
        )


        model.addAttribute(
            "answer",
            htmlAnswer
        )


        return "index"
    }

}