package resource

import common.Pageable
import common.PageableResponse
import dto.TodoRequest
import dto.TodoResponse
import dto.TodoUpdateRequest
import jakarta.inject.Inject
import jakarta.inject.Named
import jakarta.inject.Singleton
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.PATCH
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import repository.MutableMapTodoRepository
import service.TodoInterface
import service.TodoService
import java.util.*

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
class TodoResource @Inject constructor(private val todoService: TodoInterface) {

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
    fun getTodoList(@QueryParam("limit") limit: Int?, @QueryParam("offset") offset: Int?): Pageable<TodoResponse> {
        return todoService.listTodo(limit ?: 10, offset ?: 0)
    }

    @PATCH
    @Path("/{id}")
    fun updateTodo(@PathParam("id") todoId: String, request: TodoUpdateRequest): TodoResponse {
        return todoService.updateTodo(TodoUpdateRequest(UUID.fromString(todoId), request.note))
    }

    @DELETE
    @Path("/{id}")
    fun deleteTodo(@PathParam("id") todoId: String): TodoResponse {
        return todoService.deleteTodo(UUID.fromString(todoId))
    }
}