package repository

import common.Pageable
import common.PageableResponse
import dto.Todo
import jakarta.inject.Singleton
import java.util.*

@Singleton
class MutableMapTodoRepository: TodoRepository {
    private val todoMap = mutableMapOf<UUID, Todo>()

    override fun getTodo(id: UUID): Todo {
        return todoMap[id] ?: throw Exception("No Such Todo")
    }

    override fun listTodo(limit: Int, offset: Int): Pageable<Todo> {
        return PageableResponse<Todo>(
            limit,
            offset,
            todoMap.values.drop(offset).take(limit).toList()
        )
    }

    override fun createTodo(todo: Todo): Todo {
        todoMap[todo.id] = todo
        return todo
    }

    override fun updateTodo(todo: Todo): Todo {
        todoMap[todo.id] = todo
        return todo
    }

    override fun deleteTodo(todo: Todo): Todo {
        todoMap.remove(todo.id)
        return todo
    }
}