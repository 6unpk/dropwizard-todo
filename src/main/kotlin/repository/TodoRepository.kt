package repository

import common.Pageable
import dto.Todo
import java.util.UUID

interface TodoRepository {
    fun getTodo(id: UUID): Todo
    fun listTodo(limit: Int, offset: Int): Pageable<Todo>
    fun createTodo(todo: Todo): Todo
    fun updateTodo(todo: Todo): Todo
    fun deleteTodo(todo: Todo): Todo
}