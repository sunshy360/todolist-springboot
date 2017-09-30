package todoitems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoitems.model.TodoItem;
import todoitems.service.TodoItemsService;
import todoitems.model.ResponseMessage;

import javax.validation.Valid;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/todoitems") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private TodoItemsService todoItemsService;

    @GetMapping() // Map ONLY GET Requests
    public @ResponseBody ResponseEntity getAllTodoItems() {
        // This returns a JSON or XML with the users
        return ResponseEntity.ok(todoItemsService.getAllTodoItems());
    }

    @PostMapping() // Map ONLY POST Requests
    public @ResponseBody ResponseEntity addNewTodoItem (@Valid @RequestBody TodoItem todoItem) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request/ @RequestBody means the whole part of json request

        ResponseMessage responseMessage = todoItemsService.createTodoItem(todoItem);
        return ResponseEntity.status(responseMessage.getHTTPCode()).body(responseMessage);
    }

    @PutMapping(path="/{id}") // Map ONLY PUT Requests
    public @ResponseBody ResponseEntity updateTodoItem (@PathVariable("id") Integer id, @Valid @RequestBody TodoItem todoItem) {

        todoItem.setId(id);
        ResponseMessage responseMessage = todoItemsService.updateTodoItem(todoItem);
        return ResponseEntity.status(responseMessage.getHTTPCode()).body(responseMessage);
    }

    @DeleteMapping(path="/{id}") // Map ONLY DELETE Requests
    public @ResponseBody ResponseEntity deleteTodoItem (@PathVariable("id") Integer id) {

        ResponseMessage responseMessage = todoItemsService.deleteTodoItem(id);
        return ResponseEntity.status(responseMessage.getHTTPCode()).body(responseMessage);
    }
}