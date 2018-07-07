package com.knothing.recyclerviewpayloads

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity: AppCompatActivity() {

//    private var mAdapter:MyAdapter? = null
    lateinit var mAdapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycer)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val recycler = findViewById<RecyclerView>(R.id.recycler);
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycler.layoutManager = layoutManager

        val data = arrayListOf<String>()
        var i = 0
        while (i<1000){
            data.add("i = $i")
            i++
        }

        mAdapter = MyAdapter(data)
        recycler.adapter = mAdapter



        findViewById<Button>(R.id.button).setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                data[3] = "KNohting"
                mAdapter.notifyItemChanged(3,"3333")
            }

        })

    }

}