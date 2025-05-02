package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.ProjectReport;

@Repository
public interface ProjectReportRepository extends JpaRepository<ProjectReport, Long> {
}
