package com.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.main.entity.ProjectReport;
import com.main.service.ProjectReportService;

@Controller
public class ProjectReportController {

    @Autowired
    private ProjectReportService service;

    @PostMapping("/submitReport")
    public String submitReport(@ModelAttribute ProjectReport report) {
        service.saveReport(report);
        return "redirect:/Savemsg";
    }
}
