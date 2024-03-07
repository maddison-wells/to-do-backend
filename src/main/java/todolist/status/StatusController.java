package todolist.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	
	@Autowired
	private StatusService statusService;
	
	@PostMapping
	public ResponseEntity<Status> create(@Valid @RequestBody CreateStatusDTO data){
		Status createdStatus = this.statusService.create(data);
		return new ResponseEntity<>(createdStatus, HttpStatus.CREATED);
	}
	
	
	//use this for status select?
	
	@GetMapping
	public ResponseEntity<List<Status>> findAll(){
		List<Status> allStatus = this.statusService.findAll();
		return new ResponseEntity<>(allStatus, HttpStatus.OK);
	}
	
}
;