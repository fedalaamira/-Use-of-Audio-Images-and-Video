package com.example.multimedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import java.io.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mots= arrayListOf<String>("mot","mot2","mot3")
        val list:ListView=findViewById(R.id.mots)
        val adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,mots)
        list.adapter=adapter
        list.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                val pos: Int = position
                val intent = Intent(baseContext, DetailsActivity::class.java)
                intent.putExtra("pos", pos)
                startActivity(intent)
            }
        }
    }
}
