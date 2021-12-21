package com.example.myapplicationmap15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ScrollingView
import com.google.android.material.bottomsheet.BottomSheetDialog
//import com.example.myapplicationmap15.R
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.mapbox.geojson.Point




class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    lateinit var btnShowBottomSheet: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Mapbox.getInstance(applicationContext,getString(R.string.my_acess_token))

        mapView = findViewById(R.id.mapView)
        btnShowBottomSheet = findViewById(R.id.idBtnDismiss);

        //função botão título inicial
        btnShowBottomSheet.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)

            //função botão adicionar pin
            val addbtn = view.findViewById<Button>(R.id.idbtnAddPin)
            addbtn.setOnClickListener {

            }

            //função botão visualizar pin
            val addview = view.findViewById<Button>(R.id.idbtnVisualizarPin)
            addview.setOnClickListener{

            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }

    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }



}