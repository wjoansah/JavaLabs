package com.wjoansah;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("LeLogProcessorApp")
                .master("local[*]")
                .getOrCreate();

        JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());

        // Read log file
        JavaRDD<String> logLines = sc.textFile("./application.log");

        JavaRDD<String> errorLogs = logLines.filter(line -> line.contains("ERROR"));

        Map<String, Long> errorCounts = errorLogs
                .map(line -> line.split(" ")[2])
                .countByValue();

        errorCounts.forEach((key, value) -> System.out.println(key + ": " + value));

        sc.parallelize(errorCounts.entrySet().stream()
                        .map(e -> e.getKey() + " : " + e.getValue())
                        .collect(Collectors.toList()))
                .saveAsTextFile("output/error_summary");

        sc.close();
    }
}
