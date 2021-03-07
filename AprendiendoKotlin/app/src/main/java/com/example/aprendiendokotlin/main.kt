package com.example.aprendiendokotlin

var nueva = 3

fun main() {
    println("Hola a todos")

    var a : Int = 1 // Valor se puede modificar en cualquier momento
    val b : Int = 2 // Valor no se puede modificar
    var c : Int = a + b
    println(nueva)

    var a1 = 4 // Kotlin infiere el tipo de variable
    val b1 : Int
    b1 = 5

    var a2 :String? = null
    println(a2)

    a2 = "otra cosa"
    println(a2)
    println("-------------------------------")

    // Clases e instancias

    val persona : Persona = Persona("Javier", 38)
    persona.presentacion()
    val persona2 : Persona = Persona()
    persona2.nombre = "Juan"
    persona2.presentacion()

    // Data class
    val usuario : Usuario = Usuario("Hola", "hola@gmail.com")
    // Copy - copia el objeto el objeto y te permite cambair valores a las propiedades
    val usuario2 = usuario.copy(correo = "holanuevo@gmial.com")
    println(usuario.toString())
    println(usuario2.toString())
    val (nombre, correo) = usuario
    println("Los usuarios son iguales: ${if (usuario == usuario2) "si son" else "no son"}")

    var iguales = if (usuario == usuario2) "si son" else "no son";
    println(iguales)

    println("CONTROL DE FLUJO-------------")

    // IF

    var num1 : Int = 1
    var num2 = 2
    var max : Int

    max = if(num1 > num2) {
        num1
    } else {
        num2
    }

    if(num1 > num2) println(num1.toString()) else println(num2.toString())

    // WHEN
    var xw = 9
    when(xw){ // if-else-if
        1 -> {println("xw es 1")}
        2 -> println("xw es 2")
        3 -> println("xw es 3")
        4, 5 -> println("xw puede ser 4 o 5, valor $xw")
        else -> {println("xw no corresponde a ninguna opción")}
    }

    when(xw){
        in 1..10 -> println("xw esta en el rango")
        !in 11..20 -> println("xw no esta en el rango")
        else -> println("xw no se encuentra en ninguna opcion")
    }

    // While

    var wh = 1
    while(wh<=4){
        println("El valor es $wh")
        wh++
    }

    // For

    // listas

    var listaNombres = mutableListOf<String>("Juan", "Manuel", "Rosa", "Pedro")
    listaNombres.add("Jose")

    var listaAnimales = listOf<String>("Perro", "Gato", "Conejo")


    for(nom in listaNombres){
        println("El nombre es $nom")
    }

    for((index, value) in listaNombres.withIndex()){
        println("El index es $index, el valor es $value")
    }

    for(i in listaAnimales.indices){
        println(listaAnimales[i])
    }
    //Funciones de expresiones
    listaAnimales.forEach { el -> println(el) }

    listaAnimales.forEachIndexed{ index, el -> println("index: $index, valor: $el")}

    // Expresiones de rango

    for(i in 1..6 step 3){
        println(i)
    }
    println("-----")
    for(i in 6 downTo 0 step 2){
        println(i)
    }

    for(i in 1 until 10) { // Excluyendo el 10
        print(i)
    }
    println("---")
    // Funciones
    println(suma(3, 4))
    println(suma2(2,2))
    imprimirSuma(1,3)

}

// Clase
class Persona(var nombre : String = "", var edad : Int = 0) {
    fun presentacion() {
        println("El es $nombre y tiene $edad años")
    }
}

// Data class
data class Usuario(val nombre : String, val correo : String)

// Funciones

fun suma(numero1 : Int, numero2 : Int) : Int {
    return numero1 + numero2
}

// Funcion como una expresión
fun suma2(a: Int, b: Int) = a + b

fun imprimirSuma(a : Int, b : Int) : Unit {
    println("La suma de $a y $b es ${a + b}")

}