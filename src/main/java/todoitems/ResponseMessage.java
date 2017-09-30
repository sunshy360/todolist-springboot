package todoitems;

public class ResponseMessage {
    private int HTTPCode;
    private String message;
    private TodoItem todoItem;

    public ResponseMessage(int i, String s, TodoItem todoItem) {
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
