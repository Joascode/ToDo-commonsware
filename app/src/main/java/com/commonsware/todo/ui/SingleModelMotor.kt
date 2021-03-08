package com.commonsware.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.commonsware.todo.repo.ToDoModel
import com.commonsware.todo.repo.ToDoRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

data class SingleModelViewState(
    val item: ToDoModel? = null
)

class SingleModelMotor(
    private val repo: ToDoRepository,
    private val modelId: String?
) : ViewModel() {
    val states: LiveData<SingleModelViewState> =
        repo.find(modelId).map { SingleModelViewState(it) }.asLiveData()

    fun save(model: ToDoModel) {
        viewModelScope.launch {
            repo.save(model)
        }
    }
    fun delete(model: ToDoModel) {
        viewModelScope.launch {
            repo.delete(model)
        }
    }
}