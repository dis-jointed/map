package com.buupass.moshclient.repositories

import android.graphics.Bitmap
import android.net.Uri
import com.buupass.moshclient.model.FakeDataRes


interface FakeDataInterface {


    suspend fun getFakeData(
    ): FakeDataRes
}