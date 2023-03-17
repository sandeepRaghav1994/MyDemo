package com.example.sandeepdemo.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sandeepdemo.data.repository.MainRepository
import com.example.sandeepdemo.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {



    fun getCountries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getCountries()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}