package hello;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hello.TodoItem;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TodoItemsRepository extends CrudRepository<TodoItem, Integer> {
//    @Query("select u from #{#entityName} u where u.lastname = ?1")
    TodoItem findByItemName(String itemname);
}