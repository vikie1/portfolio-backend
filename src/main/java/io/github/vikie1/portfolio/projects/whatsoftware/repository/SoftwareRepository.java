package io.github.vikie1.portfolio.projects.whatsoftware.repository;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<SoftwareEntity, Long> {
    SoftwareEntity findByNameAllIgnoreCase(String name);
    boolean existsByName(String name);
    void deleteByName(String name);
    List<SoftwareEntity> findAllByTypeEntity(TypeEntity type);
}
