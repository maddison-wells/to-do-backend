package todolist.todoitem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.exceptions.ServiceValidationException;
import jakarta.validation.Valid;
import todolist.exceptions.NotFoundException;

@RestController
@RequestMapping("/todoitem")


public class ToDoControlller {

@Autowired
private ToDoService toDoService;

	@PostMapping
	public ResponseEntity<ToDoItem> createItem(@Valid @RequestBody CreateToDoItemDTO data) throws ServiceValidationException {
		ToDoItem createdItem = this.toDoService.createItem(data);
		return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
	}

	
	
	@GetMapping
	public ResponseEntity<List<ToDoItem>> getallItems(){
		List<ToDoItem> allItems = this.toDoService.getAll();
		return new ResponseEntity<>(allItems, HttpStatus.OK)
		;
		
	}
	
	//entityType?
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDoItem> getItemById(@PathVariable Long id) throws NotFoundException{
		Optional<ToDoItem> maybeItem = this.toDoService.findById(id);
		ToDoItem foundItem = maybeItem.orElseThrow(() -> new NotFoundException(ToDoItem.class, id));
		return new ResponseEntity<>(foundItem, HttpStatus.OK);
		
}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<ToDoItem> updateItemById(@Valid @RequestBody UpdateToDoDTO data, @PathVariable Long id) throws NotFoundException{
		Optional<ToDoItem> maybeUpdatedItem = this.toDoService.updateById(data, id);
		ToDoItem updatedItem = maybeUpdatedItem.orElseThrow(() -> new NotFoundException(ToDoItem.class, id));
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
		
	}
	

	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<ToDoItem> deletePostById(@PathVariable Long id) throws NotFoundException{
	 boolean deleted = this.toDoService.deletePostById(id);
	 if(!deleted) {
		 throw new NotFoundException(ToDoItem.class, id);
	}
	 return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
}
