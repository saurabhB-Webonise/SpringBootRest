package com.example.springbootrest.SpringBootRest.service;

import com.example.springbootrest.SpringBootRest.exception.CustomException;
import com.example.springbootrest.SpringBootRest.model.JobPost;
import com.example.springbootrest.SpringBootRest.repo.JobRepo;
import com.example.springbootrest.SpringBootRest.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobService {

    @Autowired
    public JobRepo repo;

    @Autowired
    JobRepository jobRepository;

    public List<JobPost> returnAllJobPosts() {
        return jobRepository.findAll();
    }

    public Optional<JobPost> getJobById(int postId) {
        return jobRepository.findById(postId);
    }

    public void addJobPost(JobPost jobPost) {
        String message = "";

        if (jobPost.getPostDesc().isBlank()) {
            message += " Post Decription Required";
        }
        if (jobPost.getPostProfile().isBlank()) {
            message += " Post Profile Required";
        }
        if (jobPost.getReqExperience() == 0) {
            message += " Required Experience is empty";
        }
        if (jobPost.getPostTechStack().isEmpty()) {
            message += " Post Tech Stack Required ";
        }

        if (!message.isBlank()) {
            throw new CustomException(message, HttpStatus.BAD_REQUEST);
        }
        jobRepository.save(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepository.deleteById(postId);
    }

    public JobPost updateJob(JobPost jobPost) {
        return jobRepository.save(jobPost);
    }
}
