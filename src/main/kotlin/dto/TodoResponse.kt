package dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class TodoResponse(
    @get:JsonProperty
    val id: UUID,
    @get:JsonProperty
    val note: String,
)