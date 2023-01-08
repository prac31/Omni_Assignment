package com.example.github

import com.example.github.RetrofitHelper

object Repository {

   suspend fun getEverything()= RetrofitHelper.api.getEverything()
}