package todolist.status;

import jakarta.validation.constraints.NotBlank;

public class CreateStatusDTO {
	
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
