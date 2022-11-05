package KodlamaIo.Devs.dataAccess.concretes;

//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import KodlamaIo.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
//import KodlamaIo.Devs.entities.concretes.ProgrammingLanguage;
//
//@Repository
//public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageRepository{
//
//	List<ProgrammingLanguage> programmingLanguages;
//	public InMemoryProgrammingLanguageDao() {
//		programmingLanguages = new ArrayList<ProgrammingLanguage>();
//		programmingLanguages.add(new ProgrammingLanguage(1, "C#"));
//		programmingLanguages.add(new ProgrammingLanguage(2, "Java"));
//	}
//	
//	@Override
//	public void add(ProgrammingLanguage programmingLanguage) {
//		programmingLanguages.add(programmingLanguage);
//	}
//
//	@Override
//	public void delete(int id) {
//		programmingLanguages.removeIf(PL -> PL.getId() == id);
//	}
//
//	@Override
//	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
//		for (ProgrammingLanguage language : programmingLanguages) {
//			if (language.getId() == programmingLanguage.getId()) {
//				programmingLanguages.set(language.getId() - 1, programmingLanguage);
//			}
//		}
//	}
//
//	@Override
//	public List<ProgrammingLanguage> getList() {
//		return programmingLanguages;
//	}
//
//	@Override
//	public ProgrammingLanguage getById(int id) {
//		return programmingLanguages.get(id - 1);
//	}
//}