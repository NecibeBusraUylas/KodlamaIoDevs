package KodlamaIo.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import KodlamaIo.Devs.business.abstracts.ProgrammingTechnologyService;
import KodlamaIo.Devs.business.requests.CreateProgrammingTechnologyRequest;
import KodlamaIo.Devs.business.responses.ProgrammingTechnologyResponse;
import KodlamaIo.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import KodlamaIo.Devs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import KodlamaIo.Devs.entities.concretes.ProgrammingLanguage;
import KodlamaIo.Devs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService{
	private final ProgrammingLanguageRepository languageRepository;
	private final ProgrammingTechnologyRepository technologyRepository;
	
	public ProgrammingTechnologyManager(ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingTechnologyRepository programmingTechnologyRepository) {
		this.languageRepository = programmingLanguageRepository;
		this.technologyRepository = programmingTechnologyRepository;
    }

	@Override
	public void add(CreateProgrammingTechnologyRequest technologyRequest) throws Exception {
		ProgrammingLanguage language = languageRepository.findById(technologyRequest.getProgrammingLanguageId())
                .orElseThrow(() -> new RuntimeException("Programming langugage couldn't find by id: " + technologyRequest.getProgrammingLanguageId()));
        if (isNameExist(technologyRequest)) {
            throw new Exception("Entered programming technolgy name is exist!!! :" + technologyRequest.getName());
        } else {
            ProgrammingTechnology technology = new ProgrammingTechnology();
            technology.setName(technologyRequest.getName());
            technology.setProgrammingLanguage(language);

            technologyRepository.save(technology);
        }
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);
	}

	@Override
	public void update(int id, CreateProgrammingTechnologyRequest technologyRequest) throws Exception {
		 ProgrammingTechnology technology = technologyRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Programming technology couldn't find by id: " + id));
	        if (isNameExist(technologyRequest)) {
	            throw new Exception("Entered programming technology name is exist! name: " + technologyRequest.getName());
	        } else {
	            technology.setName(technologyRequest.getName());
	            technologyRepository.save(technology);
	        }
	}

	@Override
	public List<ProgrammingTechnologyResponse> getAll() {
		List<ProgrammingTechnology> technology = technologyRepository.findAll();

        List<ProgrammingTechnologyResponse> technologyResponse = technology.stream()
                .map(tech -> new ProgrammingTechnologyResponse(tech.getId(), tech.getName()))
                .collect(Collectors.toList());

        return technologyResponse;
	}

	@Override
	public ProgrammingTechnologyResponse getById(int id) {
		ProgrammingTechnology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programming technology couldn't find by id: " + id));
        ProgrammingTechnologyResponse technologyResponse = new ProgrammingTechnologyResponse();
        technologyResponse.setId(technology.getId());
        technologyResponse.setName(technology.getName());

        return technologyResponse;
	}
	
	private boolean isNameExist(CreateProgrammingTechnologyRequest technologyRequest) {
        List<ProgrammingTechnology> programmingTechnologies = technologyRepository.findAll();
        boolean isNameExist = programmingTechnologies.stream().anyMatch(x -> x.getName().equals(technologyRequest.getName()));
        return isNameExist;
    }
}