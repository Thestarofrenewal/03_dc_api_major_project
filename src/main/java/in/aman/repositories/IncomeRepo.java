package in.aman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aman.entities.IncomeEntity;

public interface IncomeRepo extends JpaRepository<IncomeEntity, Integer> {

}
