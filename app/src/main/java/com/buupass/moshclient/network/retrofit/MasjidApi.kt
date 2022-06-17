package com.buupass.moshclient.network.retrofit




import android.graphics.Bitmap
import android.net.Uri
import com.buupass.moshclient.model.FakeDataRes
import retrofit2.Call
import retrofit2.http.*

interface MasjidApi {

    @GET("products")
    fun getData(
    ): Call<FakeDataRes>
}