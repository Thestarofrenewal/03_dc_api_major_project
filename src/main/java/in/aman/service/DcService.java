package in.aman.service;

import java.util.Map;

import in.aman.bindings.DcSummary;
import in.aman.bindings.Education;
import in.aman.bindings.Income;
import in.aman.bindings.Kids;
import in.aman.bindings.PlanSelection;

public interface DcService {
	
	public Map<Integer, String> getPlans();

	public boolean savePlanSelection(PlanSelection planSel);

	public boolean saveIncome(Income income);

	public boolean saveEducation(Education education);

	public boolean saveKids(Kids kids);

	public DcSummary fetchSummaryInfo(Long caseNum);
}
