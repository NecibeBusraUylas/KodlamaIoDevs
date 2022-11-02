package KodlamaIo.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIo.Devs.business.abstracts.ProgrammingLanguageService;
import KodlamaIo.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import KodlamaIo.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		for (ProgrammingLanguage pl : programmingLanguageRepository.getList()) {
			if (pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu isimli programlama dili zaten mevcut!");
			}
			if (pl.getId() == programmingLanguage.getId()) {
				throw new Exception("İd tekrar edemez!");
			}
		}
		programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) throws Exception {
		for (ProgrammingLanguage programmingLanguage : programmingLanguageRepository.getList()) {
			if (programmingLanguage.getId() == id ) {
				programmingLanguageRepository.delete(id);
			}
		}
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili boş geçilemez!");
		}
		
		for (ProgrammingLanguage pl : programmingLanguageRepository.getList()) {
			if (pl.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu isimli programlama dili zaten mevcut!");
			}
		}
		programmingLanguageRepository.update(programmingLanguage);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getList();
	}

	@Override
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		return programmingLanguageRepository.getById(id);
	}

}