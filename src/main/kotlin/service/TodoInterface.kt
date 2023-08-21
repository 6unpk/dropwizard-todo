package service

import common.Pageable
import dto.TodoRequest
import dto.TodoResponse
import dto.TodoUpdateRequest
import java.util.*

interface TodoInterface {
    fun createTodo(todoRequest: TodoRequest): TodoResponse
    fun getTodoItem(id: UUID): TodoResponse
    fun listTodo(limit: Int, offset: Int): Pageable<TodoResponse>
    fun updateTodo(todoRequest: TodoUpdateRequest): TodoResponse
    fun deleteTodo(id: UUID): TodoResponse
}