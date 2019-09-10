package com.mhmdjalal.maaps1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_post.*

class DetailPostActivity : AppCompatActivity() {

    private var id: Int = 0
    private var title: String = ""
    private var overview: String = ""
    private var date: String = ""
    private var imgUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)
        setupToolbar()

        id = intent.getIntExtra("id", 0)
        title = intent.getStringExtra("title")
        overview = intent.getStringExtra("overview")
        date = intent.getStringExtra("date")
        imgUrl = intent.getStringExtra("imgUrl")

        tv_title.text = title
        tv_date.text = date
        tv_overview.text = overview
        Picasso.get()
            .load(imgUrl)
            .placeholder(R.drawable.thumbnail)
            .error(R.drawable.thumbnail)
            .into(iv_banner)
    }

    fun setupToolbar() {
        toolbar.setTitleTextAppearance(this, R.style.customToolbarfont)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Detail Berita")
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_left)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
