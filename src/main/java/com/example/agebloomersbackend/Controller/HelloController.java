package com.example.agebloomersbackend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/api/hello")
    @ResponseBody
    public List<String> Hello() {
        return Arrays.asList("서버입니다.", "클라이언트입니다.");
    }
}
