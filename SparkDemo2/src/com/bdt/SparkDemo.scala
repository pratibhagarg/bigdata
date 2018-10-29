

package com.bdt

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level

object SparkDemo {
  
  //For Developing spark applications create scala project
  //Add spark dependent jar -> project->buildpath->configure build path->add external jars
  //Add all jars in spark/jars folder
  //OR- use SBT/MVN
  
  
  //for spark applications::
  //Testing - we create saprkSession with sparkconfiguration hard  coded
  //Running in production-> we pass empty spark configurtaion and provide all configuration in 
  //Command line as arguments using --conf or --properties
  
  def main(args: Array[String]): Unit = {
    //create configuration and create sparksession Object
     Logger.getLogger("org").setLevel(Level.ERROR)   
    val conf=new SparkConf()
   
    /*production 
     * val conf=new SparkConf()
     */
    
   // enableHiveSuuport()  //required for working with HQL
   // import org.apache.spark.sql.t
    val spark=SparkSession
    .builder()            //existing session object reusing
    .appName("SparkDemo")
    .config(conf)
    .enableHiveSupport()
    .getOrCreate()
    
   
    
    val sc=spark.sparkContext
    
    import spark.implicits._  //to convert RDD into DF
    //cleansing/ RDDs
    val empRDD=sc.textFile(args(0));
    empRDD.foreach(println)
    println("-----------------applictaion completed-------------------")
    
    val empRDD1=empRDD.filter(line => ! line.contains("id,name,sal"))
    .map(line=>(line.split(",")(0),line.split(",")(1),line.split(",")(2),line.split(",")(3)))
    .foreach(println)
    
     val empDF=empRDD.filter(line => ! line.contains("id,name,sal"))
    .map(line=>(line.split(",")(0),line.split(",")(1),line.split(",")(2),line.split(",")(3)))
    .toDF("id","name","sal","dept")
    empDF.printSchema();
    empDF.show()
    
    empDF.createOrReplaceTempView("emp_table")
    val empDF1=spark.sql("select id,name,sal+1000 as sal1,dept from emp_table")
    empDF1.show()
    //empDF1.write.saveAsTable("enp_table1")
    spark.sql("create table if not exists emp_demo as select * from emp_table")
    spark.sql("insert overwrite table emp_demo select * from emp_table")
    println("**store***")
  }
}