package com.mhmdjalal.maaps1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setupToolbar()

        Picasso.get()
            .load("https://www.dicoding.com/images/small/avatar/201712041255273e89358a73bd7ac20f4343537a6c9b41.jpg")
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .into(image_profile)
    }

    fun setupToolbar() {
        toolbar.setTitleTextAppearance(this, R.style.customToolbarfont)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("About")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_left)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
