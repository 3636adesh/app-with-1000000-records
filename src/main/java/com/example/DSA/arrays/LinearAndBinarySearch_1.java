package com.example.DSA.arrays;

import com.example.HeaderRecord;
import com.example.SalesRecord;
import com.example.SalesRecordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LinearAndBinarySearch_1 {


    @Autowired
    SalesRecordDetailService detailService;

    @Bean
    ApplicationRunner init() {
        return args -> search1();
    }

    void search1() {
        List<SalesRecord> salesRecords = detailService.getSalesRecords();

        List<?> orderIdList = SalesRecordDetailService.getDataByFileHeader(HeaderRecord.ORDER_ID, salesRecords);

        var array = orderIdList.toArray(new Integer[0]);

        long sortStart = System.nanoTime();
        Arrays.sort(array);
        long sortEnd = System.nanoTime();

        long binarySearchStart = System.nanoTime();
        int result = binarySearch(array, 880811536);
        long binarySearchEnd = System.nanoTime();

        System.out.println("Array Sort Time: " + (sortEnd - sortStart) / 1000 + " µs");
        System.out.println("Binary Search Time: " + (binarySearchEnd - binarySearchStart) / 1000 + " µs");


        long linearSearchStart = System.nanoTime();
        int linearResult = linearSearch(array, 880811536);
        long linearSearchEnd = System.nanoTime();

        if (linearResult == -1) {
            System.out.println("Linear Search: Element not found");
        } else {
            System.out.println("Linear Search: Element found with index " + linearResult + " Item type: " + salesRecords.get(linearResult).getItemType());
        }

        if (result == -1) {
            System.out.println("Binary Search: Element not found");
        } else {
            System.out.println("Binary Search: Element found with index " + result + " Item type: " + salesRecords.get(result).getItemType());
        }

        System.out.println("Linear Search Time: " + (linearSearchEnd - linearSearchStart) / 1000 + " µs");
        System.out.println("Binary Search Time: " + (binarySearchEnd - binarySearchStart) / 1000 + " µs");
    }

    static int linearSearch(Integer[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;

    }

    static int binarySearch(Integer[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid].equals(target)) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
