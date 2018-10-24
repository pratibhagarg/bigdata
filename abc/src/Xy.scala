

object Xy {
    
  def main(args: Array[String]): Unit = {
    for(x<-args) println("x is::"+x)
    args.foreach(println)
    println("----------------")
    val s=new Stu(1,"pqr",23.0)
    println(s.id+"--"+s.name)
    s.setConf(44)
    s.getConf()
  }
}


class Stu (var id:Int, val name:String, fee:Double)
{
  private var con=10
  def getConf():Int={ println("inside getters")
  println(con);
    con
  
  }   
  
  def setConf(i:Int){
  this.con=i;}
}

case class Emp(id:Int,name:String,dept:Float)