package todoitems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todoitems.model.TodoItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface TodoItemsRepository extends CrudRepository<TodoItem, Integer> {
//    @Query("select u from #{#entityName} u where u.lastname = ?1")
    TodoItem findByItemName(String itemname);
}