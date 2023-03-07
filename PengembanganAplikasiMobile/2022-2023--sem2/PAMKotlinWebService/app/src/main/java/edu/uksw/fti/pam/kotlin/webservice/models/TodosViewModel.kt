package edu.uksw.fti.pam.kotlin.webservice.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uksw.fti.pam.kotlin.webservice.repositories.JSONPlaceholderTypicodeRepository
import kotlinx.coroutines.launch

class TodosViewModel : ViewModel() {
    private var _toDoList = mutableStateListOf<TodosModel>()

    var errorMessage: String by mutableStateOf("")
    val toDoList: List<TodosModel>
        get() = _toDoList

    fun getToDoList() {
        viewModelScope.launch {
            val apiClient = JSONPlaceholderTypicodeRepository.getClient()
            try {
                _toDoList.clear()
                _toDoList.addAll(apiClient.getTodos())
            }
            catch (e: Exception) {
                errorMessage = e.message!!
            }
        }
    }
}