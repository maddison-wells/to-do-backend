package todolist.todoitem;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import todolist.exceptions.ServiceValidationException;
import todolist.exceptions.ValidationErrors;
import jakarta.validation.Valid;
import todolist.status.Status;
import todolist.status.StatusService;

@Service
@Transactional

public class ToDoService {
	
	@Autowired
	private ToDoRepository repo;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private ModelMapper mapper;

	public ToDoItem createItem(CreateToDoItemDTO data) throws ServiceValidationException {
		
//		ToDoItem newItem = new ToDoItem();
//		newItem.setDescription(data.getDescription().trim());
//		newItem.setTitle(data.getTitle().trim());
////		newItem.setStatus(data.getStatus.trim().toLowerCase());
//		newItem.setCreatedAt(new Date());
		
		ValidationErrors errors = new ValidationErrors();
		ToDoItem newItem = mapper.map(data, ToDoItem.class);

		
		Long statusId= data.getStatusId();
		Optional<Status> maybeStatus = this.statusService.findById(statusId);
		
		if (maybeStatus.isEmpty()) {
			errors.addError("status", String.format("Status with id %s does not exist", statusId));
		} else {
			newItem.setStatus(maybeStatus.get());
		}

		if (errors.hasErrors()) {
			// throw an exception
			throw new ServiceValidationException(errors);
		}

		// this is now handled in base entity
//		newPost.setCreatedAt(new Date());
		return this.repo.save(newItem);

	}

	public List<ToDoItem> getAll() {
		return this.repo.findAll();
	}

	public Optional<ToDoItem> findById(Long id) {
		return this.repo.findById(id);		
	}

	public Optional<ToDoItem> updateById(@Valid UpdateToDoDTO data, Long id) {
Optional<ToDoItem> maybeItem = this.findById(id);
if(maybeItem.isEmpty()) {
	return maybeItem;
}
ToDoItem foundItem =maybeItem.get();
//if(data.getTitle() != null) {
//	foundItem.setTitle(data.getTitle().trim());
//}
//if(data.getDescription() != null) {
//	foundItem.setDescription(data.getDescription().trim());
//}

System.out.println(foundItem.getStatus());

mapper.map(data, foundItem);
ToDoItem updated = this.repo.save(foundItem);

return Optional.of(updated);
	}

	public boolean deletePostById(Long id) {
		Optional<ToDoItem> maybeItem = this.repo.findById(id);	
		if(maybeItem.isEmpty()) {
			return false;
			
		}
		this.repo.delete(maybeItem.get());
		return true;
}
	

}



















