package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequset(){
        return "Hi, getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id,
                               @RequestParam(name="password") String pwd
    ){
        String password = "asdf";
        System.out.println("id: " + id);
        System.out.println("password: "+ pwd);
        return id + pwd;
    }

    // multParameter?account&email&page -> 개수가 많을 때 -> 객체로 받아야함.
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        // Spring에서 객체를 리턴하는거면 자동으로 json형태로 리턴 된다.
        return searchParam;
    }



}
