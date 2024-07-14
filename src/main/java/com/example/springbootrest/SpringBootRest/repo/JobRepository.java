package com.example.springbootrest.SpringBootRest.repo;

import com.example.springbootrest.SpringBootRest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPost,Integer> {

}
