package dto

import java.util.UUID

data class TodoUpdateRequest(
    val id: UUID,
    val note: String
)
