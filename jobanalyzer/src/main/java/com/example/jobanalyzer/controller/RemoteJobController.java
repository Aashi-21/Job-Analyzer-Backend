package com.example.jobanalyzer.controller;

import com.example.jobanalyzer.entity.RemoteJob;
import com.example.jobanalyzer.service.RemoteJobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class RemoteJobController {

    private final RemoteJobService service;

    public RemoteJobController(RemoteJobService service) {
        this.service = service;
    }

    @GetMapping
    public List<RemoteJob> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/{id}")
    public RemoteJob getJobById(@PathVariable Long id) {
        return service.getJobById(id);
    }

    @GetMapping("/search")
    public List<RemoteJob> search(@RequestParam String keyword) {
        return service.searchJobs(keyword);
    }

    @GetMapping("/top-companies")
    public List<Object[]> topCompanies() {
        return service.getTopCompanies();
    }
}
