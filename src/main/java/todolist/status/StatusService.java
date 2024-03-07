package todolist.status;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class StatusService {

	
	@Autowired
	private StatusRepository repo;
	
	@Autowired 
	private ModelMapper mapper;
	

	public Status create(CreateStatusDTO data) {
		Status newStatus = mapper.map(data, Status.class);
		return this.repo.save(newStatus);


	}


	public List<Status> findAll() {
		return this.repo.findAll();
	}


	public Optional<Status> findById(Long statusId) {
		return this.repo.findById(statusId);
	}
	
}
