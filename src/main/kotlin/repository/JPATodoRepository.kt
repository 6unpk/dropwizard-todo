package repository

import common.Pageable
import common.PageableResponse
import dto.Todo
import io.dropwizard.hibernate.AbstractDAO
import jakarta.inject.Singleton
import org.hibernate.SessionFactory
import java.util.*

@Singleton
class JPATodoRepository(sessionFactory: SessionFactory): AbstractDAO<Todo>(sessionFactory), TodoRepository {
    override fun getTodo(id: UUID): Todo {
        return get(id)
    }

    override fun listTodo(limit: Int, offset: Int): Pageable<Todo> {
        val result = list(namedTypedQuery("com.example.helloworld.core.Person.findAll"))
        return PageableResponse<Todo>(limit, offset, result)
    }

    override fun createTodo(todo: Todo): Todo {
        return Todo(UUID.randomUUID(), "")
    }

    override fun updateTodo(todo: Todo): Todo {
        return Todo(UUID.randomUUID(), "")
    }

    override fun deleteTodo(todo: Todo): Todo {
        return Todo(UUID.randomUUID(), "")
    }

}