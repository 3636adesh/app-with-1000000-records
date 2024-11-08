package com.example;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@Service
public class CsvParserService {


    private final ResourceLoader resourceLoader;

    public CsvParserService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<SalesRecord> parseCsv() {
        Resource resource = resourceLoader.getResource("classpath:500000_Sales_Records.csv");

        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            CsvToBean<SalesRecord> csvToBean = new CsvToBeanBuilder<SalesRecord>(reader)
                    .withType(SalesRecord.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            return Collections.emptyList();
        } catch (RuntimeException e) {
            System.err.println("Error parsing the CSV file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
