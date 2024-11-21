package com.wjoansah;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;
import scala.Tuple2;

import java.util.Arrays;

public class WordCountSparkApp {
    public static void main(String[] args) {

        // Step 1: Create a Spark configuration and context
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Step 2: Load the input data (from a file or hardcoded text for simplicity)
        String inputFile = "data.txt"; // Update the path to your file
        JavaRDD<String> input = sc.textFile(inputFile);

        // Step 3: Perform the word count
        JavaPairRDD<String, Integer> wordCounts = input
                .flatMap(line -> Arrays.asList(line.split(" ")).iterator())  // Split each line into words
                .mapToPair(word -> new Tuple2<>(word, 1))                    // Map each word to a (word, 1) tuple
                .reduceByKey(Integer::sum);                                  // Sum all the values for each word

        // Step 4: Save the result (optional: print or store to a file)
        wordCounts.saveAsTextFile("spark_output.txt");
        // OR print the result to console
        wordCounts.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));

        // Step 5: Stop the Spark context
        sc.stop();
    }
}