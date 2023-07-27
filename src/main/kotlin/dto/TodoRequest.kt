package dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoRequest(
    @get:JsonProperty
    val title: String
)