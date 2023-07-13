package com.example.yandexmapsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yandexmapsapi.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mapview: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        MapKitFactory.setApiKey("7a0eaf60-78c0-4cbd-bee5-85ac580c1cce")
        MapKitFactory.initialize(this)
        setContentView(binding.root)
        mapview = findViewById(R.id.mapview)
        mapview.map.move(CameraPosition(Point(42.889667, 74.852095), 11.0f, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH, 300f), null)
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