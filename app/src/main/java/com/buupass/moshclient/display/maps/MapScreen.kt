package com.masjid.timetable.fragments.maps

import android.location.Location
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.android.libraries.maps.model.PolylineOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private lateinit var mapView: MapView

@Composable
fun MapScreen(
    currentLocation: Location? = null,
    modifier: Modifier,
    zoom: Float
) {
    mapView = rememberMapViewWithLifeCycle()

    val context = LocalContext.current


    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        AndroidView(
            { mapView }
        ) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                val map = mapView.awaitMap()
                map.uiSettings.isZoomControlsEnabled = true
                /* if (currentLocation !=null){*/

                val destination = LatLng(-1.3052784, 36.6849352)
                val markerOptions = MarkerOptions()
                    .title("kok")
                    .position(destination)
                map.addMarker(markerOptions)
           /*     list.forEach {


                    // val destination = LatLng(currentLocation!!.latitude, currentLocation!!.longitude)
                    val destination = LatLng(it.location.latitude, it.location.longitude)
                    val markerOptions = MarkerOptions()
                        .title(it.masjidname)
                        .position(destination)
                    map.addMarker(markerOptions)

                    map.addPolyline(
                        PolylineOptions()
                            //  .clickable(true)
                            .add(
                                currentLocation?.let {
                                    LatLng(
                                        it.latitude,
                                        currentLocation.longitude
                                    )
                                },
                                LatLng(it.location.latitude, it.location.longitude),

                                )
                    )

                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, zoom))
                }*/
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, zoom))

                /*}*/ /*else {

                    val destination = com.google.android.libraries.maps.model.LatLng(-1.3053022341047844, 36.68497288225285)
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(destination, 6f))
                    val markerOptions =  MarkerOptions()
                        .title("Static location")
                        .position(destination)
                    map.addMarker(markerOptions)
                }*/
            }
        }
    }
}

@Composable
fun rememberMapViewWithLifeCycle(): MapView {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            id = com.google.maps.android.ktx.R.id.map_frame
        }
    }
    val lifeCycleObserver = rememberMapLifecycleObserver(mapView)
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifeCycle) {
        lifeCycle.addObserver(lifeCycleObserver)
        onDispose {
            lifeCycle.removeObserver(lifeCycleObserver)
        }
    }

    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }

