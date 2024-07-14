package com.example.springbootrest.SpringBootRest.controller;

import com.example.springbootrest.SpringBootRest.model.JobPost;
import com.example.springbootrest.SpringBootRest.service.JobService;
import com.example.springbootrest.SpringBootRest.wrapper.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestJobController {

    @Autowired
    private JobService service;


    @GetMapping(path = "jobs", produces = {"application/json"})
    public ResponseEntity<CommonResponse<List<JobPost>>> getAllJobs() {

//        CommonResponse commonResponse = new CommonResponse<List<JobPost>>();
//        commonResponse.setData(service.returnAllJobPosts());
//        commonResponse.setMessage("Unable to fetch record");
//        commonResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commonResponse);


        CommonResponse<List<JobPost>> commonResponse = new CommonResponse<List<JobPost>>();
        List<JobPost> list = service.returnAllJobPosts();
        String message = (list == null || list.isEmpty()) ? "No records" : list.size() + " Records found";
        commonResponse.setData(list);
        commonResponse.setMessage(message);
        commonResponse.setStatus(String.valueOf(HttpStatus.OK.value()));

        return ResponseEntity.ok().body(commonResponse);
    }

    @GetMapping("job/{postId}")
    public JobPost getJobById(@PathVariable int postId) {
        return service.getJobById(postId).orElse(null);
    }

    @PostMapping(path = "job", consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJobPost(jobPost);
        return service.getJobById(jobPost.getPostId()).orElse(null);
    }

    @DeleteMapping("job/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Job Deleted";
    }

    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return service.updateJob(jobPost);
    }
}
