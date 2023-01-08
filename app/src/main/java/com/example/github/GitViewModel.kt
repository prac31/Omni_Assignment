package com.example.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.Repository
import androidx.lifecycle.viewModelScope
import com.example.github.GitResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Response

class GithubViewModel:ViewModel() {
    private val livedata= MutableLiveData<Response<GitResponse>>()
    val list:LiveData<Response<GitResponse>>
    get() = livedata


 fun Everything(){
       viewModelScope.launch(Dispatchers.IO) {
             val result= Repository.getEverything()
             if(result.code()==200){
                 livedata.postValue(result)
             }
        }
    }


}