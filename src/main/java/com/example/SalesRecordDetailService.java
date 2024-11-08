package com.example;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRecordDetailService {

    private final CsvParserService csvParserService;

    public SalesRecordDetailService(CsvParserService csvParserService) {
        this.csvParserService = csvParserService;
    }


    public List<SalesRecord> getSalesRecords() {
        return csvParserService.parseCsv();
    }

    public static List<?> getDataByFileHeader(String header,  List<SalesRecord> salesRecords) {

        return switch (header) {
            case HeaderRecord.REGION -> salesRecords.stream()
                    .map(SalesRecord::getRegion)
                    .toList();
            case HeaderRecord.COUNTRY -> salesRecords.stream()
                    .map(SalesRecord::getCountry)
                    .toList();
            case HeaderRecord.ITEM_TYPE -> salesRecords.stream()
                    .map(SalesRecord::getItemType)
                    .toList();
            case HeaderRecord.SALES_CHANNEL -> salesRecords.stream()
                    .map(SalesRecord::getSalesChannel)
                    .toList();
            case HeaderRecord.ORDER_PRIORITY -> salesRecords.stream()
                    .map(SalesRecord::getOrderPriority)
                    .toList();
            case HeaderRecord.ORDER_DATE -> salesRecords.stream()
                    .map(SalesRecord::getOrderDate)
                    .toList();
            case HeaderRecord.ORDER_ID -> salesRecords.stream()
                    .map(SalesRecord::getOrderId)
                    .toList();
            case HeaderRecord.SHIP_DATE -> salesRecords.stream()
                    .map(SalesRecord::getShipDate)
                    .toList();
            case HeaderRecord.UNIT_PRICE -> salesRecords.stream()
                    .map(SalesRecord::getUnitPrice)
                    .toList();
            case HeaderRecord.UNIT_COST -> salesRecords.stream()
                    .map(SalesRecord::getUnitCost)
                    .toList();
            case HeaderRecord.TOTAL_REVENUE -> salesRecords.stream()
                    .map(SalesRecord::getTotalRevenue)
                    .toList();
            case HeaderRecord.TOTAL_COST -> salesRecords.stream()
                    .map(SalesRecord::getTotalCost)
                    .toList();
            case HeaderRecord.TOTAL_PROFIT -> salesRecords.stream()
                    .map(SalesRecord::getTotalProfit)
                    .toList();
            default -> throw new IllegalArgumentException("Invalid header: " + header);
        };
    }


}
