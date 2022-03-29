package com.akul.capwayinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akul.capwayinterview.ui.main.AccountFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AccountFragment.newInstance())
                .commitNow()
        }
    }
}