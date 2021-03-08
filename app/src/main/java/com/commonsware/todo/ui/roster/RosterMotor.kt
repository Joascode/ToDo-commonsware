package com.commonsware.todo.ui.roster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

data class RosterViewState(
    val items: List<ToDoModel> = listOf()
)

class RosterMotor(private val repo: ToDoRepository) : ViewModel() {
    fun save(model: ToDoModel) {
        viewModelScope.launch {
            repo.save(model)
        }
    }

    val states = repo.items().map { RosterViewState(it) }.asLiveData()
}