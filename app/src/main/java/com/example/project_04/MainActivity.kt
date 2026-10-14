
package com.example.project_04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val foods = mutableListOf<Food>()

    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = FoodAdapter(foods)

        val recyclerView: RecyclerView =
            findViewById(R.id.foodRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addFoodButton: Button =
            findViewById(R.id.addFoodButton)

        addFoodButton.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {
            (application as BitFitApplication).db.foodDao()
                .getAll().collect { databaseList ->

                    val mappedList = databaseList.map { entity ->
                        Food(
                            entity.name,
                            entity.calories
                        )
                    }

                    foods.clear()
                    foods.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
        }
    }
}
