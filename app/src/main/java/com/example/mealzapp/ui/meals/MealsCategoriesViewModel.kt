package com.example.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.response.MealResponse
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository : MealsRepository = MealsRepository.getInstance()) :
    ViewModel() {

        init {
            viewModelScope.launch {
                val meal = getMeals()
                mealState.value = meal


            }
        }
    val mealState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

        suspend fun getMeals(): List<MealResponse> {
            return repository.getMeals().categories
        }
}