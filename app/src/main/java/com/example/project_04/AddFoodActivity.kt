
package com.example.project_04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddFoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        val foodNameInput: EditText =
            findViewById(R.id.foodNameInput)

        val caloriesInput: EditText =
            findViewById(R.id.caloriesInput)

        val saveFoodButton: Button =
            findViewById(R.id.saveFoodButton)

        val foodDao: FoodDao =
            (application as BitFitApplication).db.foodDao()

        saveFoodButton.setOnClickListener {

            val foodName = foodNameInput.text.toString().trim()
            val calories = caloriesInput.text.toString().toIntOrNull()

            if (foodName.isBlank() || calories == null || calories < 0) {
                Toast.makeText(
                    this,
                    getString(R.string.please_enter_valid_food_info),
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                val food = FoodEntity(
                    name = foodName,
                    calories = calories
                )

                lifecycleScope.launch(IO) {
                    foodDao.insertFood(food)

                    runOnUiThread {
                        finish()
                    }
                }
            }
        }
    }
}
