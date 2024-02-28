package in.aman.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.aman.bindings.DcSummary;
import in.aman.bindings.Education;
import in.aman.bindings.Income;
import in.aman.bindings.Kids;
import in.aman.bindings.PlanSelection;
import in.aman.service.DcService;

@RestController
public class DcRestController {

	@Autowired
	DcService dcService;

	@GetMapping("/plans")
	public Map<Integer, String> getPlans() {

		return dcService.getPlans();
	}

	@PostMapping("/plansel")
	public ResponseEntity<String> savePlanSelection(@RequestBody PlanSelection planSelInfo) {

		boolean status = dcService.savePlanSelection(planSelInfo);
		
		if (status) {
			return new ResponseEntity<String>("Plan Selection Saved", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Problem Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/income")
	public ResponseEntity<String> saveIncome(@RequestBody Income income) {
	
		boolean status = dcService.saveIncome(income);
		
		if (status) {
			return new ResponseEntity<String>("Income Saved", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Problem Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/education")
	public ResponseEntity<String> saveIncome(@RequestBody Education education) {
		
		boolean status = dcService.saveEducation(education);
		
		if (status) {
			return new ResponseEntity<String>("Education Saved", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Problem Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/kids")
	public ResponseEntity<String> saveIncome(@RequestBody Kids kids) {
		
		boolean status = dcService.saveKids(kids);
		
		if (status) {
			return new ResponseEntity<String>("Kids Saved", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Problem Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/dc-summary/{caseNum}")
	public ResponseEntity<DcSummary> getDcSummary(@PathVariable Long caseNum) {
		
		DcSummary summaryInfo = dcService.fetchSummaryInfo(caseNum);

		return new ResponseEntity<>(summaryInfo, HttpStatus.OK);
	}

}
