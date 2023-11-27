package com.larisantos.aulainjecaodependenciashilt

    class Carro(private val motor: Motor){
    /*class Carro{

        lateinit var motor: Motor*/

    fun ligar(){
        //val motor = Motor() //Alto Acoplamento
        motor.acionar()
        println("Carro ligado")
    }
}

interface Motor{
    fun acionar()
}

class MotorGasolina(val marca: String) : Motor {
    override fun acionar(){
        println("Motor ligado a gasolina $marca")
    }
}

class MotorEletrico() : Motor{
    override fun acionar() {
        println("Motor ligado elétrico")

    }

}

object LocalizadorServico{
    fun proverMotorGasolina() : Motor {
        return MotorGasolina("Ferrari")
    }
}

fun main() {

    //Tela 01
    val motorGasolina = LocalizadorServico.proverMotorGasolina()
    val carro = Carro(motorGasolina)
    //val carro = Carro()
    //carro.motor = motorGasolina
    carro.ligar()

    //Tela 02
    val motorGasolina2 = LocalizadorServico.proverMotorGasolina()
    val carro2 = Carro(motorGasolina2)
    carro2.ligar()

}