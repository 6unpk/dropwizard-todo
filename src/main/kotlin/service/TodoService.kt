package service

import dto.TodoRequest
import dto.TodoResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
class TodoService @Inject constructor() {
    fun createTodo(todoRequest: TodoRequest): TodoResponse {

        return TodoResponse(UUID.randomUUID(), "todo")
    }

    fun getTodoItem(id: UUID): TodoResponse {
        return TodoResponse(id, "todo")
    }

    fun listTodo() {

    }
}