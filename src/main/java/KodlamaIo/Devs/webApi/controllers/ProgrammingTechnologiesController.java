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

import KodlamaIo.Devs.business.concretes.ProgrammingTechnologyManager;
import KodlamaIo.Devs.business.requests.CreateProgrammingTechnologyRequest;
import KodlamaIo.Devs.business.responses.ProgrammingTechnologyResponse;

@RestController
@RequestMapping("/api/programminglanguages/programmingtechnologoies")
public class ProgrammingTechnologiesController {
	private final ProgrammingTechnologyManager technologyManager;

	@Autowired
	public ProgrammingTechnologiesController(ProgrammingTechnologyManager programmingTechnologyManager) {
		this.technologyManager = programmingTechnologyManager;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingTechnologyRequest technologyRequest) throws Exception {
		technologyManager.add(technologyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) throws Exception {
		technologyManager.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody CreateProgrammingTechnologyRequest technologyRequest, @PathVariable int id) throws Exception {
		technologyManager.update(id, technologyRequest);
	}
	
	@GetMapping("/getall")
	public List<ProgrammingTechnologyResponse> getAll(){
		return technologyManager.getAll();
	}
	
	@GetMapping("/getbyid")
	public ProgrammingTechnologyResponse getById(@PathVariable int id) {
		return technologyManager.getById(id);
	}
}