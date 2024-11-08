package com.example;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesRecord {

    @CsvBindByName(column = "Region")
    private String region;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Item Type")
    private String itemType;

    @CsvBindByName(column = "Sales Channel")
    private String salesChannel;

    @CsvBindByName(column = "Order Priority")
    private String orderPriority;

    @CsvBindByName(column = "Order Date")
    private String orderDate;

    @CsvBindByName(column = "Order ID")
    private int orderId;

    @CsvBindByName(column = "Ship Date")
    private String shipDate;

    @CsvBindByName(column = "Units Sold")
    private int unitsSold;

    @CsvBindByName(column = "Unit Price")
    private double unitPrice;

    @CsvBindByName(column = "Unit Cost")
    private double unitCost;

    @CsvBindByName(column = "Total Revenue")
    private double totalRevenue;

    @CsvBindByName(column = "Total Cost")
    private double totalCost;

    @CsvBindByName(column = "Total Profit")
    private double totalProfit;


}