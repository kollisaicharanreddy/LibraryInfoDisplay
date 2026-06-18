package com.assignment1.LibraryInfoDisplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.LibraryInfoDisplay.dto.LibraryReportDTO;
import com.assignment1.LibraryInfoDisplay.service.ReportService;

@RestController
@RequestMapping("/api/books/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public LibraryReportDTO getReport() {
        return reportService.generateReport();
    }
}