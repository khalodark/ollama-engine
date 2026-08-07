package com.khalodark.ollama.service

import com.khalodark.ollama.model.OllamaRequest
import com.khalodark.ollama.model.OllamaResponse
import org.springframework.web.client.RestClient

class OllamaService {

    private val restClient = RestClient.builder()
        .baseUrl("http://localhost:11434")
        .build()

    fun ask(question: String): String {

        val request = OllamaRequest(

            model = "qwen3:8b",

            prompt = question

        )

        val response = restClient.post()

            .uri("/api/generate")

            .body(request)

            .retrieve()

            .body(OllamaResponse::class.java)

        return response?.response ?: "No response"

    }
}