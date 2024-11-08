package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CsvController {

    private final CsvParserService csvParserService;

    public CsvController(CsvParserService csvParserService) {
        this.csvParserService = csvParserService;
    }

    @GetMapping("/parse-csv")
    public List<SalesRecord> parseCsv() {
        try {
            return csvParserService.parseCsv();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }


//    @Bean
//    ApplicationRunner runner(){
//        return args -> {
//            System.out.println("Count :-"+csvParserService.parseCsv().size());
//        };
//    }
}
