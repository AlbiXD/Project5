package com.example.project_04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val foods: MutableList<Food>,
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FoodViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food, parent, false)

        return FoodViewHolder(view)
    }

    class FoodViewHolder(
        mView: View,
    ) : RecyclerView.ViewHolder(mView) {

        val mFoodName: TextView =
            mView.findViewById(R.id.foodName)

        val mFoodCalories: TextView =
            mView.findViewById(R.id.foodCalories)
    }

    override fun onBindViewHolder(
        holder: FoodViewHolder,
        position: Int,
    ) {
        val food = foods[position]

        holder.mFoodName.text = food.name
        holder.mFoodCalories.text = food.calories.toString()
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun addFood(food: Food) {
        foods.add(food)
        notifyItemInserted(foods.size - 1)
    }
}