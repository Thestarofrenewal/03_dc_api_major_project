package in.aman.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class PlanSelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planSelId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Integer userId;
	
	@OneToOne
	@JoinColumn(name = "case_num")
	private Integer caseNum;

}
