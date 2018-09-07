package com.tomasznajda.simplerecyclerview.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tomasznajda.simplerecyclerview.adapter.BasicSrvAdapter
import com.tomasznajda.simplerecyclerview.sample.entity.Advertisement
import com.tomasznajda.simplerecyclerview.sample.entity.User
import com.tomasznajda.simplerecyclerview.sample.viewholder.AdvertisementViewHolder
import com.tomasznajda.simplerecyclerview.sample.viewholder.UserViewHolder
import kotlinx.android.synthetic.main.activity_basic_example.*


class BasicExampleActivity : AppCompatActivity() {

    private val adapter = BasicSrvAdapter().apply {
        addViewHolder(User::class, R.layout.viewholder_user) { UserViewHolder(it) }
        addViewHolder(Advertisement::class, R.layout.viewholder_ad) { AdvertisementViewHolder(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_example)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.items = listOf(
                User("FirstUser 1"),
                User("FirstUser 2"),
                Advertisement("http://advertisement.com/1"),
                User("FirstUser 3"),
                User("FirstUser 4"),
                User("FirstUser 5"),
                Advertisement("http://advertisement.com/2"),
                User("FirstUser 6"),
                User("FirstUser 7"),
                User("FirstUser 8"),
                User("FirstUser 9"),
                User("FirstUser 10")
        )
    }
}