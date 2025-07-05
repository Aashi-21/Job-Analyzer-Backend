package com.example.jobanalyzer.repository;

import com.example.jobanalyzer.entity.RemoteJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RemoteJobRepository extends JpaRepository<RemoteJob, Long> {

    List<RemoteJob> findByTitleContainingIgnoreCase(String keyword);
    List<RemoteJob> findByDescriptionContainingIgnoreCase(String keyword);

    @Query("""
        SELECT company, COUNT(*) 
        FROM RemoteJob
        GROUP BY company
        ORDER BY COUNT(*) DESC
    """)
    List<Object[]> findTopCompanies();
}
