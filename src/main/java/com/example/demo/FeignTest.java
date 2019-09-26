package com.example.demo;

import com.example.demo.models.Matches;
import com.example.demo.models.Student;
import org.springframework.boot.CommandLineRunner;

public class FeignTest implements CommandLineRunner {

    private final FeignRestClient feignRestClient;

    public FeignTest(FeignRestClient feignRestClient) {
        this.feignRestClient = feignRestClient;
    }

    @Override
    public void run(String... args) throws Exception {

        //Registering a student
        Student reg = feignRestClient.registerStudent(new Student("94117", "Sandra"));
        System.out.println("Student created: "+reg);

        //Requesting a match
        Matches req = feignRestClient.requestMatch("Leone");
        System.out.println("Match requested");

        //Reject match
        Matches reject = feignRestClient.reject("Leone","");
        System.out.println("Match rejected: "+reject);
    }
}
