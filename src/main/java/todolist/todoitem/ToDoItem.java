package todolist.todoitem;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import todolist.common.BaseEntity;
import todolist.status.Status;

@Entity
@Table(name = "todo_item")
public class ToDoItem extends BaseEntity {

	
	
	@Column
	private String title;
	
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	
//	@ManyToOne(cascade = CascadeType.ALL)

	@ManyToOne
	@JoinColumn(name= "status_id")
	@JsonIgnoreProperties("posts")
	private Status status;
	
	@Column
	private Date due;



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public ToDoItem() {
		super();
	}
}
