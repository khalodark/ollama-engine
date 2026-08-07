package com.khalodark.ollama.model

data class OllamaRequest(

    val model: String,

    val prompt: String,

    val stream: Boolean = false

)
