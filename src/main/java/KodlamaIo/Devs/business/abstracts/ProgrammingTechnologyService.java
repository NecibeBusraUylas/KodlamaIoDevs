package KodlamaIo.Devs.business.abstracts;

import java.util.List;

import KodlamaIo.Devs.business.requests.CreateProgrammingTechnologyRequest;
import KodlamaIo.Devs.business.responses.ProgrammingTechnologyResponse;

public interface ProgrammingTechnologyService {
	void add(CreateProgrammingTechnologyRequest technologyRequest) throws Exception;
	void delete(int id);
	void update(int id, CreateProgrammingTechnologyRequest technologyRequest) throws Exception;
	
	List<ProgrammingTechnologyResponse> getAll();
	ProgrammingTechnologyResponse getById(int id);
}