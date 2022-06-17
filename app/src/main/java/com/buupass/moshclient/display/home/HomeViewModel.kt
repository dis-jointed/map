package com.buupass.moshclient.display.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.buupass.moshclient.model.FakeDataRes
import com.buupass.moshclient.model.FakeDataResItem
import com.buupass.moshclient.repositories.FakeDataRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeViewModel : ViewModel() {

    val repository = FakeDataRepository()

    val listt : MutableState<List<FakeDataResItem>> = mutableStateOf(
        listOf()
    )



    val getFakeData: Flow<FakeDataRes> = flow {
        while (true) {
            val response = repository.getFakeData()
            emit(response) // Emits the result of the request to the flow
            delay(5000) // Suspends the coroutine for some time
        }
    }
    fun setList(list: ArrayList<FakeDataResItem>){
        val current = ArrayList(listt.value)
        current.clear()

        list.forEach {
            current.add(it)
            listt.value = current
        }

    }
}