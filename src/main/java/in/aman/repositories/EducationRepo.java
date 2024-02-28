package in.aman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aman.entities.EducationEntity;

public interface EducationRepo extends JpaRepository<EducationEntity, Integer> {

}
