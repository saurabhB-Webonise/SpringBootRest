package com.example.springbootrest.SpringBootRest.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@AllArgsConstructor
@Data
@Component
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;

    public JobPost(){

    }
    public  JobPost(int i, String postProfile, String postDesc, int i1, List<String> es) {
        this.postId = i;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = i1;
        this.postTechStack = es;
    }
}