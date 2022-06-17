package com.buupass.moshclient.repositories

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.buupass.moshclient.model.FakeDataRes
import com.masjid.timetable.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeDataRepository : FakeDataInterface {

    val fakeDataResponse: MutableState<FakeDataRes> = mutableStateOf(
        FakeDataRes(
        )
    )

    override suspend fun getFakeData(): FakeDataRes {
        RetrofitClient.instance.getData(
        ).enqueue(object :
            Callback<FakeDataRes> {

            override fun onResponse(
                call: Call<FakeDataRes>,
                response: Response<FakeDataRes>
            ) {
                if (response.code().equals(200)) {

                    Log.d("TAG", "onResponse: ${response.body()}")
                    response.body()?.let {
                        fakeDataResponse.value = it
                    }

                }


            }

            override fun onFailure(call: Call<FakeDataRes>, t: Throwable) {
                Log.d("TAG", "onFailure: Error")

            }

        })

        return fakeDataResponse.value!!
    }
}