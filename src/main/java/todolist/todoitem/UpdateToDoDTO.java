package todolist.todoitem;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
public class UpdateToDoDTO {
	

	
		
		@Pattern(regexp = "^(?=\\S).*$", message = "Title Cannot Be Empty")
		private String title;
		
		

		@Pattern(regexp = "^(?=\\S).*$", message = "Description Cannot Be Empty")
		private String description;
		
		@Min(1)
		private Long statusId;
		
		
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
		
		
		public Long getStatusId() {
			return statusId;
		}
		
		public void setStatusId(Long statusId) {
			this.statusId = statusId;
		}


	
	
}
