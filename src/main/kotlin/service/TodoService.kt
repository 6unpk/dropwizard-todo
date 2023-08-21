package service

import common.Pageable
import common.PageableResponse
import dto.Todo
import dto.TodoRequest
import dto.TodoResponse
import dto.TodoUpdateRequest
import jakarta.inject.Inject
import jakarta.inject.Singleton
import repository.TodoRepository
import java.util.*

@Singleton
class TodoService @Inject constructor(private val todoRepository: TodoRepository): TodoInterface {
    override fun createTodo(todoRequest: TodoRequest): TodoResponse {
        return todoRepository.createTodo(Todo(UUID.randomUUID(), todoRequest.title)).toResponse()
    }

    private fun Todo.toResponse(): TodoResponse = TodoResponse(id, title)

    override fun getTodoItem(id: UUID): TodoResponse {
        return todoRepository.getTodo(id).toResponse()
    }

    override fun listTodo(limit: Int, offset: Int): Pageable<TodoResponse> {
        val todos = todoRepository.listTodo(limit, offset)
        return PageableResponse<TodoResponse>(todos.limit, todos.offset, todos.result.map { it.toResponse() })
    }

    override fun updateTodo(todoRequest: TodoUpdateRequest): TodoResponse {
        return todoRepository.updateTodo(Todo(todoRequest.id, todoRequest.note)).toResponse()
    }

    override fun deleteTodo(id: UUID): TodoResponse {
        return todoRepository.deleteTodo(Todo(id, "")).toResponse()
    }
}