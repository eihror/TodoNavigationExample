package com.eihror.todoappnavigationexample.feature.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eihror.todoappnavigationexample.persistence.DatabaseMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.eihror.todoappnavigationexample.R.layout.activity_main)

        DatabaseMain(applicationContext)
    }

}