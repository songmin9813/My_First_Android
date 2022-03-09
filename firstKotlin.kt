/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

class BankAccount{//클래스를 생성하는 방법
    val currency:Int//
    val percent:Double
    val name:String
    fun info(){
        println("Your currency is %currency.")
        println("and your percent is %percent.")
    }
    constructor(currency:Int, percent:Double){
        this.currency=currency
        this.percent=percent
        println("Created account")
    }
    constructor(name:String){
        this.name=name
        println("name complete")
    }
}
fun main() {
    for(index in "Hello"){
        println("index is $index")
    }
    sayHello()
    println(Hello("John",13))
   	val result={i1:Int, i2:Int->i1*i2}(10,20)
    println(result)
    val person:BankAccount=BankAccount(percent=3.8,currency=1000)
}
fun sayHello(){
    println("life is short. learn kotlin")
}
fun Hello(name:String, index:Int):String{
    return "Hello $name. You are ${index}th customer."
}