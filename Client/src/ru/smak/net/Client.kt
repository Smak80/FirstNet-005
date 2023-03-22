package ru.smak.net

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client(host: String, port: Int) {

    private val cs = Socket(host, port)
    fun start(){
        try {
            PrintWriter(cs.getOutputStream()).apply {
                println("Привет!")
                flush()
            }
            BufferedReader(InputStreamReader(cs.getInputStream())).apply {
                readLine()?.let { println(it) }
            }
        } catch (e: Throwable){
            println("Ошибка: ${e.message}")
        } finally {
            cs.close()
        }
    }
}