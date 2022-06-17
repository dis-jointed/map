package com.buupass.moshclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.buupass.moshclient.display.home.HomeScreen
import com.buupass.moshclient.display.home.HomeViewModel
import com.buupass.moshclient.display.home.ProgressBar
import com.buupass.moshclient.ui.theme.MoshClientTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val homeViewModel: HomeViewModel by viewModels()
    private var ProgressDialogMessage: MutableState<String> = mutableStateOf("")
    private var showProgressDialog: MutableState<Boolean> = mutableStateOf(false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LaunchedEffect(key1 = true, block = {
                //getting all masjids
                lifecycleScope.launch {

                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        ProgressDialogMessage.value = "Getting data"
                        showProgressDialog.value = true

                        homeViewModel.getFakeData.collect {
                            if (it != null) {
                                homeViewModel.setList(it)
                                Log.d("TAAAG", "onCreate: $it")
                                delay(3000)
                                showProgressDialog.value = false

                            }

                        }
                        /* CredentialViewModel.loginUser.collect {

                             if (it.status) {
                                 move.value += 1
                                 CredentialViewModel.setUserData(it)
                                 if (move.value <= 1) {
                                     Log.d("TAGTT", "onCreate: $it")
                                     showProgressDialog.value = false
                                     navController.navigate("waitingroom_screen")
                                 }
                                 showProgressDialog.value = false

                             }

                         }*/

                    }
                }
            })
            MoshClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    if (showProgressDialog.value) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ProgressBar(
                                message = ProgressDialogMessage.value,
                                show = showProgressDialog.value,
                                color = Color.Black
                            ) {
                                showProgressDialog.value = false
                            }
                        }
                    }

                    if (showProgressDialog.value == false) {
                        HomeScreen(productList = homeViewModel.listt.value)
                    }
                }
            }
        }
    }
}

