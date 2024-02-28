package in.aman.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import in.aman.bindings.DcSummary;
import in.aman.bindings.Education;
import in.aman.bindings.Income;
import in.aman.bindings.Kid;
import in.aman.bindings.Kids;
import in.aman.bindings.PlanSelection;
import in.aman.entities.AppEntity;
import in.aman.entities.EducationEntity;
import in.aman.entities.IncomeEntity;
import in.aman.entities.KidEntity;
import in.aman.entities.PlanEntity;
import in.aman.entities.PlanSelEntity;
import in.aman.repositories.AppRepo;
import in.aman.repositories.EducationRepo;
import in.aman.repositories.IncomeRepo;
import in.aman.repositories.KidRepo;
import in.aman.repositories.PlanRepo;
import in.aman.repositories.PlanSelRepo;

public class DcServiceImpl implements DcService {

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanSelRepo planSelRepo;

	@Autowired
	private IncomeRepo incomeRepo;

	@Autowired
	private EducationRepo educationRepo;

	@Autowired
	private KidRepo kidRepo;

	@Autowired
	private AppRepo appRepo;

	@Override
	public Map<Integer, String> getPlans() {

		Map<Integer, String> plansMap = new HashMap<>();

		List<PlanEntity> entities = planRepo.findAll();

		for (PlanEntity planEntity : entities) {

			plansMap.put(planEntity.getPlanId(), planEntity.getPlanName());
		}

		return plansMap;
	}

	@Override
	public boolean savePlanSelection(PlanSelection planSel) {

		PlanSelEntity entity = new PlanSelEntity();

		BeanUtils.copyProperties(planSel, entity);

		entity = planSelRepo.save(entity);

		return entity.getPlanSelId() > 0;
	}

	@Override
	public boolean saveIncome(Income income) {

		IncomeEntity entity = new IncomeEntity();

		BeanUtils.copyProperties(income, entity);

		entity = incomeRepo.save(entity);

		return entity.getIncomeId() > 0;
	}

	@Override
	public boolean saveEducation(Education education) {
		EducationEntity entity = new EducationEntity();

		BeanUtils.copyProperties(education, entity);

		entity = educationRepo.save(entity);

		return entity.getEduId()> 0;
	}

	@Override
	public boolean saveKids(Kids kids) {
		
		List<Kid> kidsList = kids.getKidsList();
		
//		Integer caseNum = kids.getCaseNum();
		
		for (Kid kid : kidsList) {
			
			KidEntity entity = new KidEntity();
			BeanUtils.copyProperties(kid, entity);
			kidRepo.save(entity);
		}
				
		return true;
	}

	@Override
	public DcSummary fetchSummaryInfo(Long caseNum) {
		
//		DcSummary summary = new DcSummary();
		
		Optional<AppEntity> findById = appRepo.findById(caseNum);

		if(findById.isPresent()) {
//			AppEntity appEntity = findById.get();
			
		}
		
		return null;
	}

}
