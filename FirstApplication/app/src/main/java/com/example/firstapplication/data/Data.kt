package com.example.firstapplication.data

import kotlin.random.Random

var joinedList = mutableListOf<String>()

fun listbase(): String {

    var maleNames = listOf("Luke","Enrico","Ali","Hamza")

    var femaleNames = listOf("Lucy","Jennifer","Sumaya","Mai")

    joinedList.addAll(maleNames)
    joinedList.addAll(femaleNames)


    var r2 = (1..joinedList.size).random()
    val random = Random
    var r = random.nextInt(joinedList.count())
    return joinedList[r]

}