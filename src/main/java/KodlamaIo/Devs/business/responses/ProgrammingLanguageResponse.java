package KodlamaIo.Devs.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageResponse {
	private int id;
	private String name;
	 private List<String> programmingTechnologyNames;
}