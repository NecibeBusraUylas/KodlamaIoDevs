package KodlamaIo.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import KodlamaIo.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import KodlamaIo.Devs.entities.concretes.ProgrammingLanguage;
import KodlamaIo.Devs.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.Devs.business.requests.CreateProgrammingLanguageRequest;
import KodlamaIo.Devs.business.responses.ProgrammingLanguageResponse;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private final ProgrammingLanguageRepository languageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.languageRepository = programmingLanguageRepository;
    }
	    
	@Override
	public void add(CreateProgrammingLanguageRequest languageRequest) throws Exception {
		if (isNameExist(languageRequest)) {
            throw new Exception("Entered programming language name is exist! name: " + languageRequest.getName());
        } else {
            ProgrammingLanguage language = new ProgrammingLanguage();
            language.setName(languageRequest.getName());
            languageRepository.save(language);
        }
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
	}

	@Override
	public void update(int id, CreateProgrammingLanguageRequest languageRequest) throws Exception {
		ProgrammingLanguage language = languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programming language couldn't find by id: " + id));
        if (isNameExist(languageRequest)) {
        	throw new Exception("Entered programming language name is exist! name: " + languageRequest.getName());
        }
        language.setName(languageRequest.getName());
        languageRepository.save(language);
	}

	@Override
	public List<ProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = languageRepository.findAll();
		List<ProgrammingLanguageResponse> languageResponse = programmingLanguages
				.stream()
                .map((programmingLanguage) -> new ProgrammingLanguageResponse(programmingLanguage.getId(),
                		programmingLanguage.getName(),
                		programmingLanguage.getProgrammingTechnologies()
                                .stream()
                                .map(tech -> tech.getName())
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
		return languageResponse;
	}

	@Override
	public ProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage language = languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programming language couldn't find by id: " + id));
		ProgrammingLanguageResponse languageResponse = new ProgrammingLanguageResponse();
		languageResponse.setId(language.getId());
		languageResponse.setName(language.getName());
		languageResponse.setProgrammingTechnologyNames(language.getProgrammingTechnologies()
				.stream()
				.map(tech -> tech.getName())
				.collect(Collectors.toList()));
		return languageResponse;
	}
	
	private boolean isNameExist(CreateProgrammingLanguageRequest languageRequest) {
        List<ProgrammingLanguage> programmingLanguages = languageRepository.findAll();
        boolean isNameExist = programmingLanguages.stream().anyMatch(x -> x.getName().equals(languageRequest.getName()));
        return isNameExist;
    }
}