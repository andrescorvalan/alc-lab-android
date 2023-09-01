package com.curso.android.app.practica.pairstring.view

//import com.curso.android.app.practica.pairstring.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.pairstring.R
import com.curso.android.app.practica.pairstring.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.pairString.observe(this){ 
            if (mainViewModel.comparePairStr())
                binding.TextViewResult.text=getString(R.string.mje_equal)
            else
                binding.TextViewResult.text=getString(R.string.mje_distint)
        }
        binding.ButtonCompare.setOnClickListener {
            mainViewModel.asignStrings(binding.EditTextString1.text.toString(), binding.EditTextString2.text.toString())
        }
        binding.EditTextString1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                binding.TextViewResult.text=getString(R.string.mje_changed)
            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        binding.EditTextString2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                binding.TextViewResult.text=getString(R.string.mje_changed)
            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                              before: Int, count: Int) {
            }
        })
    }
}