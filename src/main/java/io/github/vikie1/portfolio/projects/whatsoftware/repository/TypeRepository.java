package io.github.vikie1.portfolio.projects.whatsoftware.repository;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    List<TypeEntity> findAllByCategoryEntity(CategoryEntity categoryEntity);
    TypeEntity findByTypeAllIgnoreCase(String type);
    boolean existsByTypeAllIgnoreCase(String type);
}
