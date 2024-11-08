package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CsvController {

    private final CsvParserService csvParserService;

    public CsvController(CsvParserService csvParserService) {
        this.csvParserService = csvParserService;
    }

    @GetMapping("/parse-csv")
    public List<SalesRecord> parseCsv() {
        return csvParserService.parseCsv();
    }


//    @Bean
//    ApplicationRunner runner(){
//        return args -> {
//            System.out.println("Count :-"+csvParserService.parseCsv().size());
//        };
//    }
}
