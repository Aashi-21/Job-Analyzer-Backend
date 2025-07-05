package com.example.jobanalyzer.service;

import com.example.jobanalyzer.entity.RemoteJob;
import com.example.jobanalyzer.repository.RemoteJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteJobService {

    private final RemoteJobRepository repository;

    public RemoteJobService(RemoteJobRepository repository) {
        this.repository = repository;
    }

    public List<RemoteJob> getAllJobs() {
        return repository.findAll();
    }

    public RemoteJob getJobById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<RemoteJob> searchJobs(String keyword) {
        List<RemoteJob> byTitle = repository.findByTitleContainingIgnoreCase(keyword);
        List<RemoteJob> byDescription = repository.findByDescriptionContainingIgnoreCase(keyword);
        byDescription.removeAll(byTitle);
        byTitle.addAll(byDescription);
        return byTitle;
    }

    public List<Object[]> getTopCompanies() {
        return repository.findTopCompanies();
    }
}
