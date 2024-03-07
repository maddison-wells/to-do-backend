package todolist.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import todolist.status.CreateStatusDTO;
import todolist.status.Status;


//import todolist.status.CreateStatusDTO;
//import todolist.todoitem.ToDoItem;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());	
		mapper.getConfiguration().setSkipNullEnabled(true);
		// update when status added potentially, and update date
//		mapper.typeMap(CreateToDoItemDTO.class, ToDoItem.class).addMappings(m -> m.using(new LowerCaseConverter()).map(CreateToDoItemDTO::getStatus, ToDoItem::setStatus));
//		mapper.typeMap(UpdateToDoItemDTO.class, ToDoItem.class).addMappings(m -> m.using(new LowerCaseConverter()).map(UpdateToDoItemDTO::getStatus, ToDoItem::setStatus));

		
		mapper.typeMap(CreateStatusDTO.class, Status.class).addMappings(
				m -> m.using(new LowerCaseConverter()).map(CreateStatusDTO::getName, Status::setName));

		return mapper;
		
	}

	private class StringTrimConverter implements Converter<String, String>{
		
		@Override
		public String convert(MappingContext<String, String> context) {
if(context.getSource() == null) {
	return null;
}
return context.getSource().trim();
		}
	}
	
	
	private class LowerCaseConverter implements Converter<String, String> {
		
	
		@Override
		public String convert(MappingContext<String, String> context) {
			if(context.getSource() == null) {
				return null;
			}
		
		return context.getSource().toLowerCase();
		}
	}
	
	}
	
	

