package com.example.myfirstkotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class MainActivity : AppCompatActivity() {
    lateinit var tvHello: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("HelloWorld")
        tvHello = findViewById(R.id.tvHello)
        tvHello.text = "kienkien"
        // Log.d("kien", inYear(31).toString())
        // inYear(31)
        // check(1)
        //testmutable()
        var rs = 3.Add(4)

        var hello = "HelloWorld"
        hello.appends("kien")
        Log.d("kien", rs.toString())


    }


}

fun String.appends(string: String): String {
    return this + string
}

fun Int.Add(a: Int): Int {
    return this + a
}

fun testmutable() {
    var ds1: MutableList<Int> = mutableListOf()
    ds1.add(0, 4)
    ds1.add(1, 5)
    ds1.add(2, 6)
    ds1.add(3, 7)
    ds1.add(4, 8)

    for (i in ds1.indices) {
        Log.d("kien", ds1[i].toString())
    }
}

fun arrar() {
    var arr = IntArray(10)
    for (i in 0 until 10) {
        arr[i] = 100
    }
    for (i in arr.indices) {
        Log.d("kien", arr[i].toString())
    }
    var max = arr.indices

}

fun inYear(year: Int) {
    Log.d("kien", "Nam $year la nam nhuan")
}

fun intuoi(tuoi: Int): String {
    var s = when (tuoi) {
        in 1..5 -> "Thieu Nhi"
        in 6..30 -> "Thanh Nien"
        else -> "gia roi"
    }
    return s
}

fun tinhtoan(pheptoan: String, a: Int, b: Int): Int {
    when (pheptoan) {
        "+" -> return a + b
        "-" -> return a - b
        "*" -> return a * b
        "/" -> return a / b
    }


    return 0
}

fun add(x: Int, y: Int): Int {
    var a: Int = 5
    var b: Int = 8
    var c: Int = 2
    a-- // a= 4
    b++ //b= 9
    var z = a++ + ++b - --c + 7

    return z
}


fun kiemtra(dtb: Int) {
    if (dtb >= 5) {
        Log.d("kien", " tren tb nhe")
    }
}

fun check(mausac: Int): String {
    var result = ""
    when (mausac) {
        1 -> result = "mau_do"
        2 -> result = "mau_xanh"
        3 -> result = "mau_tim"
    }
    return result
}

class Phanso : Cloneable {
    var tuso: Int
        get() {
            TODO()
        }
        set(value) {}
    var mauso: Int
        get() {
            TODO()
        }
        set(value) {}

    constructor(tuso: Int, mauso: Int) {
        this.tuso = tuso
        this.mauso = mauso
    }

    fun copy(): Phanso {
        var ps = clone() as Phanso
        return ps
    }

}

class SamPham {
    var ten: String
        get() {
            TODO()
        }
        set(value) {}

}

class SerializableFileFactory {
    fun LuuFile(data: MutableList<SamPham>, path: String): Boolean {
        try {
            var fos = FileOutputStream(path)
            var oos = ObjectOutputStream(fos)
            oos.writeObject(data)
            oos.close()
            fos.close()
            return true
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return false
    }

    fun docFile(path: String): MutableList<SamPham> {
        var data: MutableList<SamPham> = mutableListOf()
        try {
            var fin = FileInputStream(path)
            var ois = ObjectInputStream(fin)
            var  obj = ois.readObject()
            data = obj as MutableList<SamPham>
            ois.close()
            fin.close()

        } catch (ex: Exception) {

        }
        return data
    }

}