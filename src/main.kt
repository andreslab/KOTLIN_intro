//renombrar el archivo  final compilado y con ese nombre desde otras clases se la llamará
@file:JvmName("first")


import java.math.BigInteger
import java.util.*

//VERSION DE FUNCIONES ESTATICAS
class f {
    companion object{
        @JvmStatic // se peude usar para indicar que la siguiente funcion es estatica pero se usa mas cuando se llama desde un archivo externo java
        fun show(){
            println("::::::::::")
            //se puede llamar en main asi: f.show()
        }
    }
}



//OBJECT KEYWORD

data class book (var name: String, var price: Int)
object bookshelf{
    //es una simple clase pero se puede acceder a ella sin instanciar, ocmo estatica
    var books = arrayListOf<book>()

    fun showbook(){
       for (i in books){
           println(i)
       }
    }
}



//DATA CLASS
//data permite que se pueda copiar un objeto de una clase ya instanciado en una vaiable y poder copiarlo a otra
data class laptop(val brand: String, val price:Int){
    fun show(){
       println("awesome machine")
    }
}


//INTERFAZ
//en las interfacez todos los metodos son abstractos es decir que no se describen su función
interface a{
    fun show()
    //en kotlin puedes deinir metodos
    fun abc(){
        println("...abc....")
    }
}
interface b{
    fun put()
    fun abc(){
        println("...abc....")
    }
}

class c: a, b{
    override fun show(){
        println("....show....")
    }
    override fun put(){
        println("....show....")
    }
    override fun abc(){
        //al existir la misma funcion en las 2 interfaces solo hay que especificarla como 1 sola
        println("....abc.....")
    }
}



//ABSTRACT
abstract class clase4 {
    abstract  fun metodo()
    //no puedes definir metdos, solo declararlos

    fun talk(){
        println("talking....")
    }
}

class clase5: clase4(){

    override fun metodo(){
        println("metodo")
    }

    fun impri(){
        println(".........")
    }
}





//CONSRUCTOR
//class humano constructor(var n :String){
//o tamb
//class humano (var n :String){
//class humano (var n :String = "rill"){ //default value
class humano (n :String){ //default value
    //var name: String = n
    var name: String = ""
    var age:Int = 0

    //otra frma de crear un constructor
    /*init {
    //se usa en conjunto con el "class humano (var n :String)" para capturar el parametro y usarlo
        name = n
        println("constructor inicializado")

    }*/

    //otra forma de crear un contructor
    constructor(age: Int, name: String): this(name){
        //necesario el this(name) porque el constructor primario "class humano (var n :String)" esta usando va variable n en name
        this.age = age
    }


    fun think(){
       println("init kotlin con nombre $name")
    }
}

//HERENCIA

/*
* La palabra final aplicada a variables significa que el valor de la
* variable no puede ser modificado. Esto permite al compilador asegurar
* que la variable solo es inicializada en su declaración (en el caso de atributos de clase,
* la variable debe ser asignada al declararse o en el constructor de la clase). En caso que
* la variable sea reinicializada, esto lanzará un error de compilación.
* */

open class clase1{
    //por default todas las funciones son fnal hasta que se le pone el open
    //por default todas las clases son fnal, lo que indica que no pueden ser heredades en otra clase hasta que se le pone el open
    open fun think(){
       //con el open se puede sobreescribir la funcion en otra clase
        println("clase 1")
    }
}


class clase2 : clase1(){
    override fun think(){
        //clase sobreescrita
        println("funcion sobre escrita")
    }
}


/**
 * Created by macbookpro on 7/1/17.
 */
fun main(args: Array<String>){

    //filter y map
    var lista_2 = listOf<Int>(3,34,24,6)
    var event = lista_2.filter { it%2==0 } //condicion para acptar los valores de lista_2, que el valor dividido para 2 de como reciduo 0
    var doublevalues = event.map { it * 2 } // cada valor se multiplica por 2 y se guarda en doublevalues

    //higher order function
    var lista_ = listOf<Int>(3,34,24,6)
    lista_.forEach({println(it)})
    lista_.forEach(::println) // otra forma solo  le pasas la funcion que usaras en cada item de la lista
    // lista_.forEach(name_clase::metodo_clase)


    //LIST OBJECT
    var listaLaptop = listOf<laptop>(laptop("dell", 2000), laptop("hp", 3400))

    //LIST
    //existen lista mutables e inmutables
    var lista: List<Int> = listOf<Int>(2,4,6,2,6) // lista inmutable, no s epuede agregar nuevos elementos
    var lista_mutable= mutableListOf<Int>(2,4,6,2,6) // lista mutable, se pueden agregar nuevos elementos
    for(i in lista){
        println(i)
    }

    println(lista.get(3)) //devuelve el valor de la posicion 3
    println(lista.indexOf(4)) // devuelva valor 2 q es la posicion

    lista_mutable.add(3)



    //array
    var numarray = intArrayOf(10,20,10,34,32)
    numarray[1] = 65
    numarray.set(3,56) // primer valor index y el segundo el valor
    for (i in numarray){
        println(i)
    }
    println(numarray.size)

    var numarray2 = IntArray(4) // esta indicando que el array tiene 4 espacios
    numarray2.set(0,1)
    numarray2.set(1,5)
    numarray2.set(2,7)
    numarray2.set(3,65)

    println(numarray2)

    var numarray3 = arrayOfNulls<String>(10) // un array con 10 elementos nul





    //input
    var sc = Scanner(System.`in`)
    var num22 = sc.nextInt()
    println(num22)

    var linestring = readLine()
    println(linestring)



    //object keyword
    bookshelf.books.add(book("java", 50))
    bookshelf.books.add(book("c", 69))
    bookshelf.books.add(book("go", 100))
    bookshelf.books.add(book("kotlin", 10))

    bookshelf.showbook()





    var lap1 = laptop("dell", 2000)
    var lap2 = laptop("apple", 2500)

    println(lap1 == lap2) //comparacion entre elementos que posee, los elemntos que se pasan en el constructor
    println(lap1)
    var n7 = lap1.copy() //copy funciona por el "data" en la clase laptop
    var n8 = lap1.copy(price = 2200) //se puede cambiar un valor que tenga

    //,metodos abstractos
    var n6: clase4 = clase5()
    n6.talk()
    n6.metodo()





    //rueba para herencia
    var n3 = clase2()
    //var n3 : clase1 = clase2()
    n3.think()

    //prueba para constructor
    var v = humano(20,"rick")
    v.think()

    //val se usa para declara constantes
    println("hola kotlin")

    var a = clasekotlin()
    var nombre = a.name

    println(nombre)
    println("el nombre es "+ nombre)
    println("el segudno nombre es ${nombre}")
    println("nombre: ${nombre} , el apellido es ${a.apellido}")


    //comparacion de clases con java y kotlin

    var clasekotlin = clasekotlin()
    var clasejava = clasejava()

    clasekotlin.nombre = "jaime"

    println("nombre kotlin : ${clasekotlin.nombre}")

    clasejava.nombre = "andres"

    println("nombre java : ${clasejava.nombre}")

    //operaciones

    var num1 : Int = 4
    var num2 : Int = 3

    println("resultado: ${num1 + num2}")

    println("numeros 1 es: $num1 , el numero 2 es: $num2")

    //expresiones
    if(num1 < num2)
        println("valor $num1 es menor a $num2")
    else
        println("valor $num1 es mayor a $num2")


    var resultado = if(num1 < num2)
        //println("valor $num1 es menor a $num2")
        num1
    else
        //println("valor $num1 es mayor a $num2")
        num2

    println("el resultado es $resultado")


    var resultado2 = if(num1 < num2)
    //println("valor $num1 es menor a $num2")
        num1
    else if (num1 > num2)
    //println("valor $num1 es mayor a $num2")
        num2
    else
        0


    //string comparation

    var str1: String = "Navin"
    var str2 :String = "Navin"

    if(str1.equals(str2))
        println("Same")
    else
        println("Not Same")


    var str_1: String = "Navin"
    var str_2 :String = "navin"

    if(str_1.equals(str_2,true)) // ignorando las mayusculas por eso el resultado es true
        println("Same")
    else
        println("Not Same")


    //null handing .. encargado de los nulos

    var name :String? = null

    println(name?.length)

    //var a : alien? = alien()
    //a = null


    //expresión switch

    val n : Int = 2

    when(n) {
        1 -> println("one")
        2 -> println("two")
        3 -> println("three")
        2 -> println("other two") //no llega
        else -> println("nothing")
    }

    var r = when(n) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        2 -> "other two" //no llega
        else -> "nothing"
    }


    println("resultado: $r")


    //bucles o loops, range

    var nums = 1..5 //     1 until 5    ||   1.until(5)


    for(a in nums){
        println("valor: $a")
    }

    for(a in nums step 2){
        println("valor con step 2: $a")
    }

    var nums2 = 16 downTo 1 //o  16.downTo(1)

    for (a in nums2){
        println("valor reverso: $a")
    }


    var nums3 = 1.until(16)

    for (a in nums3.reversed()){
        println("valor con reversed: $a")
    }

    println("count: ${nums3.count()}")


    var char1 = 'A'..'Z'

    for (a in char1){
        println(a)
    }


    //list y map

    var nums4 = listOf<Int>(1,2,3,4,5,6,7,8)

    for (i in nums4) {
        println("valor de list: $i")

    }

    for ((i,value) in nums4.withIndex()) {
        println("valor de list: index es $i y valor es $value")
    }


    var content = TreeMap<String,Int>()
    content["key1"] = 532
    content["key2"] = 234

    for((keyvalue, number) in content){

        println("$keyvalue : $number")
    }


    //functions
    imprime()
    var r2 = add(2,3)
    println("respuesta $r2")

    var r3 = add2(4,2)
    println("respuesta $r3")

    var r4 = max(2,7)
    println("respuesta: $r4")

    //Default y named paremeters

    var finalAmt = calcAmount(50)
    println("res: $finalAmt")

    var finalAmt2 = calcAmount(amt = 50) //se puede colocar el nombre del parametro manualmente
    println("res: $finalAmt2")



    //string to integer

    var str3 : String = "4"
    var num6 : Int = str3.toInt()

    num6++
    println(num6)

    var num7: Int = 0
    var str: String = "4a"

    try{
         num7 = str.toInt()
    }catch (e: NumberFormatException){
        println("give promper input")
    }
    finally {
        println("finaliza")
    }
    num7++

    //puede ser una expresión para una variable

    var num8: Int = try {
        str.toInt()
    }catch (e: NumberFormatException){
        -1
    }



    //funciones extendidas
    var a1 = clasekotlin()
    a1.nombre = "jaime"
    a1.show()


    var a2 = clasekotlin()
    a2.nombre = "andrade"
    a2.show()

    var a3 = a1.plus_f(a2)
    //a1 plus a2 -> asi tamb se puede representar
    a3.show()


    //infix permite a las funciones de un objeto (a4) ser representadas sin .
    var a4 = clasekotlin()
    var valor = "hola"
    var f = a4 p valor //<- representacion infix sin . , solo se puede usar con un parametro


    //operator .... usas el operador + para representar la funcion "plus", y asi mismo para minus (-) o multiply (*)
    var a5 = a1 + a2
    a5.show()


    //recursion
    mostrar()

    var num10 = 5

    println(fact(num10))

    println(fact2(BigInteger("70")))

}
//recursion
fun fact(num: Int): Int
{
    if(num == 0)
        return 1
    else
        return num * fact(num - 1)
}


fun fact2(num: BigInteger): BigInteger
{
    if(num == BigInteger.ZERO)
        return BigInteger.ONE
    else
        return num * fact2(num - BigInteger.ONE)
}
//recursion ... llamar la misma funcion dentro de la funcion
fun mostrar(){
    println("hello")
    //mostrar()
}


//operato
operator infix fun clasekotlin.plus(a: clasekotlin): clasekotlin{
    var b = clasekotlin()
    b.nombre = this.nombre + " " + a.nombre
    return b

}
//infix function
infix fun clasekotlin.p(v: String){
    println("el valor es: ${v}")
}


//funciones extendidas o extension function
fun clasekotlin.plus_f(a: clasekotlin): clasekotlin{
    var b = clasekotlin()
    b.nombre = this.nombre + " " + a.nombre
    return b

}


//functions

fun imprime(){
    println("imprimir")
}

fun add(a:Int, b:Int):Int{
    return a + b
}

fun add2(a:Int, b:Int): Int = a + b

fun max(a:Int, b:Int): Int = if(a>b) a else b


fun calcAmount(amt: Int): Int{
    return (amt + amt*0.04).toInt()
}

fun calcAmount2(amt: Int, interes: Double = 0.04): Int{
    //default value interes = 0.04
    return (amt + amt*interes).toInt()
}


//al llamar la funcion desde una clase java pueda omitir el valor interes que ya tiene un valor por defecto
@JvmOverloads
fun calcAmount3(amt: Int, interes: Double = 0.04): Int{
    //default value interes = 0.04
    return (amt + amt*interes).toInt()
}


//extension funcion

