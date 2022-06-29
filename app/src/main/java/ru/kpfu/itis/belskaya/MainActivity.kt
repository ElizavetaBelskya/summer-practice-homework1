package ru.kpfu.itis.belskaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val maxWeight: Float = 250f
    private val maxHeight: Int = 250
    private val maxAge: Int = 150
    private val minWeight: Float = 0f
    private val minHeight: Int = 0
    private val minAge: Int = 0
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? =  null
    private var age: EditText? = null
    private var button: Button? = null
    private var result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editTextName)
        height = findViewById(R.id.editTextHeight)
        weight = findViewById(R.id.editTextWeight)
        age = findViewById(R.id.editTextAge)
        result = findViewById(R.id.textViewResult)
        button = findViewById(R.id.button)
        button?.setOnClickListener {
            if (checkName() && checkHeight() && checkWeight() && checkAge()) {
                var n = name?.getText().toString()
                var h = height?.getText().toString().toInt()
                var w = weight?.getText().toString().toFloat()
                var a = age?.getText().toString().toInt()
                var value = calculate(n, h, w, a)
                result?.setText("Ответ: $value")
            } else {
                result?.setText("Данные введены некорректно")
            }
            result?.setVisibility(View.VISIBLE)
        }

    }

    fun checkName(): Boolean {
        if (name?.getText().toString().length == 0) {
            name?.setError("Пустое поле")
        } else {
            return true
        }
        return false
    }

    fun checkHeight(): Boolean {
        if (height?.getText().toString().length == 0) {
            height?.setError("Пустое поле")
        } else if (height?.getText().toString().toInt() <= minHeight) {
            height?.setError("Рост должен быть больше $minHeight")
        } else if (height?.getText().toString().toInt() >= maxHeight) {
            height?.setError("Рост должен быть меньше $maxHeight")
        } else {
            return true
        }
        return false
    }

    fun checkWeight(): Boolean {
        if (weight?.getText().toString().length == 0) {
            weight?.setError("Пустое поле")
        } else if (weight?.getText().toString().toFloat() <= minWeight) {
            weight?.setError("Вес должен быть больше $minWeight")
        } else if (weight?.getText().toString().toFloat() >= maxWeight) {
            weight?.setError("Вес должен быть меньше $maxWeight")
        } else {
            return true
        }
        return false
    }

    fun checkAge(): Boolean {
        if (age?.getText().toString().length == 0) {
            age?.setError("Пустое поле")
        } else if (age?.getText().toString().toInt() <= minAge) {
            age?.setError("Возраст должен быть больше $minAge")
        } else if (age?.getText().toString().toInt() >= maxAge) {
            age?.setError("Возраст должен быть меньше $maxAge")
        } else {
            return true
        }
        return false
    }

    fun calculate(name: String, height: Int, weight: Float, age: Int): Float {
        return (name.length + height*weight + age)
    }
}