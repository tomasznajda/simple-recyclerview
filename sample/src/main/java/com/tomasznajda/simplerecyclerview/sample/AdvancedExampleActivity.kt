package com.tomasznajda.simplerecyclerview.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tomasznajda.simplerecyclerview.adapter.AdvancedSrvAdapter
import com.tomasznajda.simplerecyclerview.sample.entity.Advertisement
import com.tomasznajda.simplerecyclerview.sample.entity.User
import com.tomasznajda.simplerecyclerview.sample.viewholder.AdvertisementViewHolder
import com.tomasznajda.simplerecyclerview.sample.viewholder.UserViewHolder
import kotlinx.android.synthetic.main.activity_advanced_example.*
import java.util.*

class AdvancedExampleActivity : AppCompatActivity() {

    private val adapter = AdvancedSrvAdapter().apply {
        addViewHolder(User::class, R.layout.viewholder_user) { UserViewHolder(it) }
        addViewHolder(Advertisement::class, R.layout.viewholder_ad) { AdvertisementViewHolder(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_example)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnSetList.setOnClickListener { initialize() }
        btnInsertSingle.setOnClickListener { insertSingle() }
        btnInsertList.setOnClickListener { insertList() }
        btnRemove.setOnClickListener { remove() }
        btnMove.setOnClickListener { move() }
        btnReplace.setOnClickListener { replace() }

        initialize()
    }

    private fun generateRandomItem() =
        if (Random().nextInt(2) == 0) generateRandomUser()
        else generateRandomAd()

    private fun generateRandomUser() = User("FirstUser ${Random().nextInt()}")

    private fun generateRandomAd() = Advertisement("http://advertisement.com/${Random().nextInt()}")

    private fun initialize() {
        adapter.set((0..2).map { generateRandomItem() })
    }

    private fun insertSingle() {
        val position = Random().nextInt(adapter.itemCount)
        adapter.insert(generateRandomItem(), position)
    }

    private fun insertList() {
        val positionStart = Random().nextInt(adapter.itemCount)
        adapter.insert((0..2).map { generateRandomItem() }, positionStart)
    }

    private fun remove() {
        if(adapter.itemCount == 0) return
        val position = Random().nextInt(adapter.itemCount)
        adapter.remove(position)
    }

    private fun move() {
        if(adapter.itemCount < 2) return
        val fromPosition = Random().nextInt(adapter.itemCount)
        val toPosition = Random().nextInt(adapter.itemCount)
        adapter.move(fromPosition, toPosition)
    }

    private fun replace() {
        if(adapter.itemCount == 0) return
        val position = Random().nextInt(adapter.itemCount)
        adapter.replace(generateRandomItem(), position)
    }
}