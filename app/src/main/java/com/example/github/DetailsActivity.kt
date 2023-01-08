package com.example.github

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val repo: Item =intent.getParcelableExtra("REPO")!!
        stars_tv.text=repo.stargazers_count.toString()+" Stars"
        fork_tv.text=repo.forks_count.toString()+" forks"
        Picasso.get().load(repo.owner!!.avatar_url).into(image_view)
        repo_name.text=repo.name
        author_name.text=repo.full_name
        gitView.webViewClient = WebViewClient()
        gitView.loadUrl(repo.html_url)
        gitView.settings.javaScriptEnabled = true
        gitView.settings.setSupportZoom(true)
    }
}