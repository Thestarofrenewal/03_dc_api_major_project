package in.aman.bindings;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Kid {

	private String kidName;
	
	private LocalDate kidDob;
	
	private Long kisSsn;
}
