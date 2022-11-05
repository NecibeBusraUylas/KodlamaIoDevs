package KodlamaIo.Devs.business.abstracts;

import java.util.List;

import KodlamaIo.Devs.business.requests.CreateProgrammingLanguageRequest;
import KodlamaIo.Devs.business.responses.ProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	void add(CreateProgrammingLanguageRequest languageRequest) throws Exception;
	void delete(int id);
	void update(int id, CreateProgrammingLanguageRequest languageRequest) throws Exception;
	
	List<ProgrammingLanguageResponse> getAll();
	ProgrammingLanguageResponse getById(int id);
}