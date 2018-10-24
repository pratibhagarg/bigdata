package com.bdt;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;
import org.apache.hadoop.io.Text;

@Description(
	name = "Salute_add", 
	value = "_FUNC_(gender, name) - Adds salutation", 
	extended = "This function will return salutation and name"
)
@UDFType(deterministic = true, stateful = false)
public class Salutations extends UDF {
   public Text evaluate(String str) {
      return str == null ? null : new Text("Mr. "+str);
   }
   public Text evaluate(String gender,String name) {
	   
	   if(gender.equalsIgnoreCase("M")){
			String str=	"Mr. " + name;
			return name == null ? null : new Text(str);
	   }else
		   return name == null ? null : new Text("Mrs. "+ name);
	   
      //return name == null ? null : new Text(str);
   }
   
 /*public static void main(String[] args) {
	   Salutation obj=new Salutation();
	  System.out.println(obj.evaluate("BigDataTech"));
	  System.out.println(obj.evaluate("M","BigDataTech"));
	  System.out.println(obj.evaluate("F", "BigDataTech"));
}
   */
}