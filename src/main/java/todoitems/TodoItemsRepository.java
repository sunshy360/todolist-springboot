package todoitems;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TodoItemsRepository extends CrudRepository<TodoItem, Integer> {
//    @Query("select u from #{#entityName} u where u.lastname = ?1")
    TodoItem findByItemName(String itemname);
}