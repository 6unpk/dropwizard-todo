package resource

import dto.TodoRequest
import dto.TodoResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import service.TodoService
import java.util.*

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
class TodoResource @Inject constructor(private val todoService: TodoService) {

    @POST
    fun addTodoItem(item: TodoRequest): TodoResponse {
        return todoService.createTodo(item)
    }

    @GET
    @Path("/{id}")
    fun getTodo(@PathParam("id") todoId: String): TodoResponse {
        return todoService.getTodoItem(UUID.fromString(todoId))
    }

    @GET
    fun getTodoList(): TodoResponse {
        return TodoResponse(UUID.randomUUID(), "Learn Spring")
    }
}