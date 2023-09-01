package com.curso.android.app.practica.pairstring.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.pairstring.model.PairString
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val pairString: LiveData<PairString> get() = _pairString
    private var _pairString = MutableLiveData<PairString>(PairString("", ""))

    fun asignStrings(str1:String, str2:String) {
        viewModelScope.launch {
            _pairString.value = PairString(str1, str2)
        }
    }
    fun comparePairStr():Boolean {
        return (_pairString.value?.string2 == _pairString.value?.string1)
    }
}

