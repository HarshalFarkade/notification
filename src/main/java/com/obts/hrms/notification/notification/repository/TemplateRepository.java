package com.obts.hrms.notification.notification.repository;

import com.obts.hrms.notification.notification.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
    Optional<TemplateEntity> findByTemplateNameAndActiveTrueAndIsDeleteFalse(String templateName);
}
