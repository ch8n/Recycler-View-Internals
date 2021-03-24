//fun main(args: Array<String>) {
//    println("test")
//
//    val aplha: Char = 'a'
//    val aplha2: String = "a"
//    //println(aplha == aplha2)
//
//    //Student()
//
//    val pet = Pet();  // Create a Pet object
//    val doggo = Dog();  // Create a Dog object
//    val meowri = Cat();  // Create a Cat object
//
//    pet.greet()
//    doggo.greet()
//    meowri.greet()
//
//    val dog: Pet = Dog()
//    dog.greet()
//
//    val cat = Cat() as Pet
//    cat.greet()
//
//
//}
//
//
//open class Increment {
//    protected var value: Int = 0
//    protected fun increment() {
//        value += 1
//    }
//}
//
//class IncrementX2 : Increment() {
//    val currentValue = value
//    fun incrementByTwo() {
//        increment()
//        increment()
//    }
//}
//
////fun test() {
////    val increment = Increment()
////    increment.increment()
////    increment.value
////
////    val incrementX2 = IncrementX2()
////    incrementX2.currentValue
////    incrementX2.incrementByTwo()
////    incrementX2.increment()
////    incrementX2.value()
////}
//
//
//// week 2
//
//// -------- 2.2 --------
////fun doSomething() {
////    // inisde doSomething scope
////    fun doSomethingElse() {
////        // inisde doSomethingElse scope
////    }
////}
////
////fun doCoolThings(){
////    // doCoolThings Scope
////
////    // can't access doSomethingElse ❌
////    doSomethingElse()
////
////
////    // ✅ can access doSomthing!
////    doSomething()
////
////}
//
//
////-------- 2.6 --------
////val alphabet = 'a' // inferenced as Char
////val name = "John Doe" // inference as String
////val kilometers = 2.5 // inference as Double
////val pi = 3.14f // inference as Float
////val number = 100L //inference as Long
////val emergency = 911 //inference as Int
//
////-------- 2.9 --------
////// Globally scoped
////val pi = 3.14f;
////
////fun circleArea () {
////    // Locally scoped
////    val rad = 4
////    val area = pi * rad * rad // gloabl variable pi can be accesses locally
////    println(area)
////}
////
////fun circleCircumference(){
////
////    val circumference = 2 * pi * rad  ❌ // can't access rad in circleArea
////
////    val rad = 4
////    // gloabl variable pi can be accesses locally
////    val circumference = 2 * pi * rad  ✅  // create new local variable
////
////}
////
//
////class Student {
////
////    // empty constructor
////    constructor() {
////        // do stuff
////    }
////
////    // secondary constructor 1
////    constructor(name:String){
////        // do stuff
////    }
////
////    // secondary constructor 2
////    constructor(name:String, rollNumber:Int){
////        // do stuff
////    }
////
////}
//
////interface Emergency {
////    val homeCenter: Int
////    fun dialPolice()
////    fun dialHospital()
////}
////
////class IndianService : Emergency {
////
////    override val homeCenter: Int = 112
////
////    override fun dialPolice() {
////        println("calling...100")
////    }
////
////    override fun dialHospital() {
////        println("calling...102")
////    }
////
////}
////
////class AmericanService : Emergency {
////    override val homeCenter: Int = 911
////
////    override fun dialPolice() {
////        println("calling..$homeCenter")
////    }
////
////    override fun dialHospital() {
////        println("calling..$homeCenter")
////    }
////
////}
//
//abstract class Emergency {
//
//    abstract val homeCenter: Int
//
//    open fun dialPolice() {
//        println("calling.. $homeCenter")
//    }
//
//    open fun dialHospital() {
//        println("calling.. $homeCenter")
//    }
//}
//
//class IndianService : Emergency() {
//
//    override val homeCenter: Int = 112
//
//    override fun dialPolice() {
//        println("calling...100")
//    }
//
//    override fun dialHospital() {
//        println("calling...102")
//    }
//}
//
//class AmericanService : Emergency() {
//    override val homeCenter: Int = 911
//}
//
////// 👇 open for inheritance
////open class BaseClass() {
////    protected fun doSomething() {
////        println("I am doing thing!")
////    }
////}
//
//// In Kotlin, inheritance is declared using the `:` operator
//// and then you have to mention the Super/base class name.
//
////		👇 child class
////class DerivedClass : BaseClass /* 👈 Super class*/{
////
////    constructor()  {
////
////    }
////
////    public fun doSomethingElse(){
////        println("I am doing something else!")
////    }
////}
////
////fun main() {
////
////    val base = BaseClass()
////    println(base.valueBase) // cannot access private fields
////    println(base.doSomething()) // cannot access protected fields
////
////    // ✨ derived class has its parent functions as well as its own functions and properties
////    val derived = DerivedClass()
////    println(derived.valueBase) // cannot access private fields from super class
////    println(derived.doSomething()) // cannot access protected fields from super class
////    println(derived.doSomethingElse()) // output : I am doing something else!
////}
//
//
////abstract class Parent {
////    val parentVariable: Int = 1
////    fun parentBehaviour() { /*..do stuff*/
////    }
////}
////
////
////interface Child {
////    fun childBehaviour()
////}
////
////
////class Human : Parent(), Child {
////
////    // override values here
////    override fun childBehaviour() {
////        /*..do stuff*/
////    }
////}
//
//open class Shape {
//    open fun area() = 0.0
//}
//
//class Circle(val radius: Double) : Shape() {
//    override fun area() = radius * radius * Math.PI
//}
//
//class Square(val side: Double) : Shape() {
//    override fun area() = side
//}
//
//class Triangle(val height: Double, val base: Double) : Shape() {
//    override fun area() = height * base * 0.5
//}
//
////fun main() {
////    val circle = Circle()
////}
//
//
////open class Pet {
////    open fun greet() {
////        println("pett class")
////    }
////}
////
////class Dog : Pet() {
////    override fun greet() {
////        println("dog class")
////    }
////}
////
////class Cat : Pet() {
////    override fun greet() {
////        println("Cat class")
////    }
////}
////
//
//
//interface Shopper {
//    fun shop()
//}
//
//class Sibling() : Shopper {
//    override fun shop() {
//        /** do stuff **/
//    }
//}
//
//class ElderPerson() : Shopper {
//    private val sibling: Sibling = Sibling()
//
//    override fun shop() {
//        sibling.shop()
//    }
//}
//
//interface DataStore {
//    fun readData(): String
//    fun writeData(value: String)
//}
//
//class FileDataStore : DataStore {
//    override fun readData(): String {
//        TODO("Not yet implemented")
//    }
//
//    override fun writeData(value: String) {
//        TODO("Not yet implemented")
//    }
//}
//
//class EncryptFileDataStore : DataStore {
//
//    private val fileDataStore = FileDataStore()
//
//    fun encrypt(value: String): String {
//        TODO("Not yet implemented")
//    }
//
//    fun decrypt(value: String): String {
//        TODO("Not yet implemented")
//    }
//
//    override fun readData(): String {
//        return fileDataStore.readData()
//    }
//
//    override fun writeData(value: String) {
//        val encryptedData = encrypt(value)
//        fileDataStore.writeData(encryptedData)
//    }
//
//}