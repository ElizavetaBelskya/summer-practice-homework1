package ru.kpfu.itis.belskaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.kpfu.itis.belskaya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val maxWeight: Float = 250f
    private val maxHeight: Int = 250
    private val maxAge: Int = 150
    private val minWeight: Float = 0f
    private val minHeight: Int = 0
    private val minAge: Int = 0
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateBtn.setOnClickListener {
            if (checkName() && checkHeight() && checkWeight() && checkAge()) {
                val n = binding.etName.getText().toString()
                val h = binding.etHeight.getText().toString().toInt()
                val w = binding.etWeight.getText().toString().toFloat()
                val a = binding.etAge.getText().toString().toInt()
                val value = calculate(n, h, w, a)
                binding.tvResult.setText("Ответ: $value")
            } else {
                binding.tvResult.setText("Данные введены некорректно")
            }
            binding.tvResult.setVisibility(View.VISIBLE)
        }

    }

    private fun checkName(): Boolean =  when(binding.etName.getText().toString().length) {
        0 -> {
            binding.etName.setError("Пустое поле");
            false
        }
        else -> true
    }

    private fun checkHeight(): Boolean {
        val s: String = binding.etHeight.getText().toString()
        val ans = when(s.length) {
            0 -> {
                binding.etHeight.setError("Пустое поле")
                false
            }
            else -> {
                when {
                    s.toInt() <= minHeight -> {
                        binding.etHeight.setError("Рост должен быть больше $minHeight")
                        false
                    }
                    s.toInt() >= maxHeight -> {
                        binding.etHeight.setError("Рост должен быть меньше $maxHeight")
                        false
                    }
                    else -> true
                }
            }
        }
        return ans
    }

    private fun checkWeight(): Boolean {
        val s: String = binding.etWeight.getText().toString()
        val ans = when(s.length) {
            0 -> {
                binding.etWeight.setError("Пустое поле")
                false
            }
            else -> {
                when {
                    s.toInt() <= minWeight -> {
                        binding.etWeight.setError("Вес должен быть больше $minWeight")
                        false
                    }
                    s.toInt() >= maxWeight -> {
                        binding.etWeight.setError("Вес должен быть меньше $maxWeight")
                        false
                    }
                    else -> true
                }
            }
        }
        return ans
    }

    private fun checkAge(): Boolean {
        val s: String = binding.etAge.getText().toString()
        val ans = when(s.length) {
            0 -> {
                binding.etAge.setError("Пустое поле")
                false
            }
            else -> {
                when {
                    s.toInt() <= minAge -> {
                        binding.etAge.setError("Возраст должен быть больше $minAge")
                        false
                    }
                    s.toInt() >= maxAge -> {
                        binding.etAge.setError("Возраст должен быть меньше $maxAge")
                        false
                    }
                    else -> true
                }
            }
        }
        return ans
    }

    private fun calculate(name: String, height: Int, weight: Float, age: Int): Float = (name.length + height * weight + age)

}