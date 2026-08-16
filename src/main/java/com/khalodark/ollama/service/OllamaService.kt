package com.khalodark.ollama.service

import com.khalodark.ollama.model.OllamaRequest
import com.khalodark.ollama.model.OllamaResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class OllamaService {

    private val restClient = RestClient.builder()
        .baseUrl("http://localhost:11434")
        .build()

    fun ask(question: String): String {

        val request = OllamaRequest(
            // another model to use for your programming :
            // qwen3.5-claude-4.6-opus
//            model = "deepseek-coder:6.7b",
            model = "sinhang/qwen3.5-claude-4.6-opus:27b-q4_K_M",
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