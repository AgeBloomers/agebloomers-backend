package com.example.agebloomersbackend.controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CrawlingController {

    @GetMapping("/data")
    public Object getData() {
        try {
            String baseUrl = "https://www.mohw.go.kr/react/policy/index.jsp?PAR_MENU_ID=06&";

            String[] urls = {
                    baseUrl + "MENU_ID=063901",
                    baseUrl + "MENU_ID=063902",
                    baseUrl + "MENU_ID=063802",
                    baseUrl + "MENU_ID=063803"
            };
            String[] keys = {"노인정책", "노인지원", "출산정책", "아동복지정책"};

            Map<String, List<Map<String, String>>> combinedData = new HashMap<>();

            for (int i = 0; i < urls.length; i++) {
                List<Map<String, String>> data = new ArrayList<>();

                Document doc = Jsoup.connect(urls[i]).get();
                Elements policyList = doc.select(".policy_list li");

                for (Element element : policyList) {
                    String title = element.select("p span").text();
                    String policyLink = "https://www.mohw.go.kr" + element.select("a").attr("href");

                    Map<String, String> policyData = new HashMap<>();
                    policyData.put("title", title);
                    policyData.put("policyLink", policyLink);

                    data.add(policyData);
                }

                combinedData.put(keys[i], data);
            }

            return combinedData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}