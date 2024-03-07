package todolist.todoitem;

import jakarta.validation.constraints.Min;

//import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateToDoItemDTO {
	
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	
	@NotNull 
	@Min(1)
	private Long statusId;
	
	
//	@NotBlank
//	private Date due;
	
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getTitle() {
		return title;
	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	public String getDescription() {
		return description;
	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public Date getDue() {
//		return due;
//	}
//	public void setDue(Date due) {
//		this.due = due;
//	}
	@Override
	public String toString() {
		return "CreateToDoItemDTO [title=" + title + ", description=" + description + "]";
	}


}
