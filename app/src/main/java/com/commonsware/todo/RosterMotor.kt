package com.commonsware.todo

import androidx.lifecycle.ViewModel

class RosterMotor(private val repo: ToDoRepository) : ViewModel() {
    fun save(model: ToDoModel) {
        repo.save(model)
    }

    fun getItems() = repo.items
}