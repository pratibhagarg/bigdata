package com.bdt

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf



object SparkDemo {
  def main(args: Array[String]): Unit = {
    
  
  var conf=new SparkConf();
  val spark=SparkSession
  .builder()
  .appName("Sample spark")
  .config(conf)
  .config("spark.app.name","Spark Demo")
  .master("local[*]")
  .getOrCreate()
  
  val sc=spark.sparkContext
  val df1=spark.range(100)
    df1.show(5)
  
 /*def main(args: Array[String]): Unit = {
   println("-------------------hello spark")
 } */
}
}