package KodlamaIo.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIo.Devs.business.concretes.ProgrammingLanguageManager;
import KodlamaIo.Devs.business.requests.CreateProgrammingLanguageRequest;
import KodlamaIo.Devs.business.responses.ProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private final ProgrammingLanguageManager languageManager;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageManager programmingLanguageManager) {
		this.languageManager = programmingLanguageManager;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest languageRequest) throws Exception {
		languageManager.add(languageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) throws Exception {
		languageManager.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody CreateProgrammingLanguageRequest languageRequest, @PathVariable int id) throws Exception {
		languageManager.update(id, languageRequest);
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguageResponse> getAll(){
		return languageManager.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguageResponse getById(@PathVariable int id) {
		return languageManager.getById(id);
	}
}