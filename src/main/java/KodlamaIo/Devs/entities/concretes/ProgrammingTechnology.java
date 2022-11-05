package KodlamaIo.Devs.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "programming_technologies")
public class ProgrammingTechnology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technology_id")
	private int id;
	
	@Column(name = "technology_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "programmingLanguageId")
	private ProgrammingLanguage programmingLanguage;
}