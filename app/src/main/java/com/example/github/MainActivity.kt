package com.example.github

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm: GithubViewModel
    private lateinit var adapter: AdapterRepo
    private lateinit var list:ArrayList<Item>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list=ArrayList()
        adapter= AdapterRepo(this,list)
        vm=ViewModelProvider(this)[GithubViewModel::class.java]
        vm.Everything()

        vm.list.observe(this) {
            if (it.isSuccessful) {
                list.addAll(it.body()!!.items)
                adapter.notifyDataSetChanged()
            }

        }

        recycler_v.layoutManager=LinearLayoutManager(this)
        recycler_v.adapter=adapter


    }
}