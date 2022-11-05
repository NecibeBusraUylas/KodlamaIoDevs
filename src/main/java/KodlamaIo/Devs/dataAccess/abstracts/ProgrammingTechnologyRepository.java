package KodlamaIo.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIo.Devs.entities.concretes.ProgrammingTechnology;

@Repository
public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer>{
}