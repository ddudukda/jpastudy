package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <from>
    // ajax 검색
    // http post body -> data
    // json, xml, multipart-form, test-plain
    // produces = {"application-json"} 방식 지정

    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }
}
