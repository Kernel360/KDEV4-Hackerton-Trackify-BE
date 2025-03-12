package com.example.trackify;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/test")
    @ResponseBody
    public Map<String, String> test(
            @RequestBody Map<String, String> requestData
    ) {
        Map<String, String> response = new HashMap<>();
        response.put("content", "데이터 수신 완료");
        System.out.println(response);
        return response;
    }

    @GetMapping("/test1")
    public String test1() {
        return "Hello World";
    }
}
