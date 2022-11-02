package KodlamaIo.Devs.dataAccess.abstracts;

import java.util.List;

import KodlamaIo.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void update(ProgrammingLanguage programmingLanguage) throws Exception;	
	List<ProgrammingLanguage> getList();
	ProgrammingLanguage getById(int id);
}