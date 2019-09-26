package com.example.demo;

import com.example.demo.models.Matches;
import com.example.demo.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "client", url = "http://:10.51.10.111/2000", configuration = FeignConfig.class)
public interface FeignRestClient {

    //Student Registration
    @RequestMapping(method = RequestMethod.POST, value = "students")
    Student registerStudent(@RequestBody Student student);

    //Blind Date Request
    @RequestMapping(method = RequestMethod.POST, value = "matches")
    Matches requestMatch(@RequestParam(name = "firstname")String fName);

    //Reject blind date
    @RequestMapping(method = RequestMethod.PATCH, value = "matches/{matchesId}")
    Matches reject(@RequestParam(name = "fName")String fName, @PathVariable(name = "matchesId")Long Id);
}
