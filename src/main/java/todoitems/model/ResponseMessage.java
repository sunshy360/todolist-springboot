package todoitems.model;

public class ResponseMessage {
    private int HTTPCode;
    private String message;
    private TodoItem todoItem;

    public ResponseMessage(int code, String message) {
        this.HTTPCode = code;
        this.message = message;
    }

    public ResponseMessage(int code, String message, TodoItem todoItem) {
        this.HTTPCode = code;
        this.message = message;
        this.todoItem = todoItem;
    }

    public int getHTTPCode() {
        return HTTPCode;
    }

    public void setHTTPCode(int HTTPCode) {
        this.HTTPCode = HTTPCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }
}
