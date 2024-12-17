package lms.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
