package com.example.yandexmapsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.yandexmapsapi.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {
    lateinit var mapview: MapView
    lateinit var trafficbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("7a0eaf60-78c0-4cbd-bee5-85ac580c1cce")
        MapKitFactory.initialize(this)
        trafficbutton = findViewById(R.id.trafficbutton)
        mapview = findViewById(R.id.mapview)
        mapview.map.move(
            CameraPosition(Point(42.889667, 74.852095), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 10f), null
        )
        var mapkit: MapKit = MapKitFactory.getInstance()
        var probki = mapkit.createTrafficLayer(mapview.mapWindow)
        var probkiison = false
        trafficbutton.setOnClickListener {
            when (probkiison) {
                false -> probkiison = true; probki.isTrafficVisible = true
                true ->
            }
        }
    }

    override fun onStop() {
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}