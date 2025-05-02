package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.ProjectReportRepository;
import com.main.entity.ProjectReport;

@Service
public class ProjectReportService {

    @Autowired
    private ProjectReportRepository repository;

    public ProjectReport saveReport(ProjectReport report) {
        return repository.save(report);
    }
}
