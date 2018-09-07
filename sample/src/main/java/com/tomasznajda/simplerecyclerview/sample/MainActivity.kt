package com.tomasznajda.simplerecyclerview.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic.onClickStartActivity(BasicExampleActivity::class)
    }

    private fun <ActivityT : Activity> Button.onClickStartActivity(activityClass: KClass<ActivityT>) =
            setOnClickListener { startActivity(Intent(this@MainActivity, activityClass.java)) }
}
