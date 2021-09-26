package com.example.daggerhilt_playground.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.daggerhilt_playground.datasources.repositories.MainRepository
import com.example.daggerhilt_playground.domain.models.Blog
import com.example.daggerhilt_playground.domain.utils.DataState


class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun getBlogs(): LiveData<DataState<List<Blog>>> =
        mainRepository.getBlogs().asLiveData()
}