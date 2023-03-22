package ru.smak.net

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class Server(port: Int) {

    val ss = ServerSocket(port)

    fun start(){
        try {
            val socket = ss.accept()
            val br = BufferedReader(InputStreamReader(socket.getInputStream()))
            val data = br.readLine()
            println("Клиент прислал: $data")
            val pw = PrintWriter(socket.getOutputStream())
            pw.println("Привет в ответ!")
            pw.flush()
        } catch (e: Throwable){
            println("Ошибка: ${e.message}")
        } finally {
            ss.close()
        }
    }
}