package todolist.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import todolist.common.BaseEntity;
import todolist.todoitem.ToDoItem;



@Entity
@Table(name="status")
public class Status extends BaseEntity {

@Column(unique = true)	
private String name;

@OneToMany(mappedBy = "status")
@JsonIgnoreProperties("status")
private List<ToDoItem> items;


public List<ToDoItem> getItems() {
	return items;
}
public void setItems(List<ToDoItem> items) {
	this.items = items;
}

public String getName() {
	return name;
} 

public void setName(String name) {
	this.name = name;
}

public Status() {
	
}

	
	

}
