package todoitems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import todoitems.model.TodoItem;
import todoitems.repository.TodoItemsRepository;
import todoitems.model.ResponseMessage;
import todoitems.util.ReplyMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TodoItemsService {

    @Autowired // This means to get the bean called todoItemsRepository
    private TodoItemsRepository todoItemsRepository;
    // Which is auto-generated by Spring, we will use it to handle the data

    private String currentDate;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Iterable<TodoItem> getAllTodoItems() {
        return todoItemsRepository.findAll();
    }

    public ResponseMessage createTodoItem(TodoItem todoItem) {

        if (todoItem.getItemName().length()>140)
            return new ResponseMessage(HttpStatus.BAD_REQUEST.value(),ReplyMessage.BadRequest);
        todoItem.setDone(false);
        currentDate = formatter.format(new Date());
        todoItem.setTimestamp(currentDate);

        todoItemsRepository.save(todoItem);
        return new ResponseMessage(HttpStatus.OK.value(),ReplyMessage.Created, todoItem);
    }

    public ResponseMessage updateTodoItem(TodoItem todoItem) {
        if (!todoItemsRepository.exists(todoItem.getId()))
            return new ResponseMessage(HttpStatus.NOT_FOUND.value(), ReplyMessage.NotFound);
        if (todoItem.getItemName().length()>140 || !(todoItem.getDone() instanceof Boolean))
            return new ResponseMessage(HttpStatus.BAD_REQUEST.value(),ReplyMessage.BadRequest);
        todoItem.setId(todoItem.getId());
        currentDate = formatter.format(new Date());
        todoItem.setTimestamp(currentDate);
        todoItemsRepository.save(todoItem);

        return new ResponseMessage(HttpStatus.OK.value(),ReplyMessage.Updated, todoItem);
    }

    public ResponseMessage deleteTodoItem(Integer id) {
        TodoItem todoItem = todoItemsRepository.findOne(id);
        todoItemsRepository.delete(id);

        return new ResponseMessage(HttpStatus.OK.value(),ReplyMessage.Deleted, todoItem);
    }
}