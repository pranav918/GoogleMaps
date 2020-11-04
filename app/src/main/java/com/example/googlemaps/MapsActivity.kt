package com.example.googlemaps

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val vimannagar = LatLng(18.5668961,73.8999763)
        val hadapsar = LatLng(18.4972508,73.9043993)
        val katraj = LatLng(18.4442854,73.8451703)
        val hinjewadi = LatLng(18.5994774,73.6821994)



        mMap.addMarker(MarkerOptions().position(vimannagar).title("Marker in Home"))
        // Motion of camera is animated (Cool!)
        mMap.animateCamera(
                (
                    CameraUpdateFactory.newLatLngZoom(
                            vimannagar,
                            12f
                    )
                )
        )
        mMap.addPolyline(
                PolylineOptions()
                        .add(vimannagar)
                        .add(katraj)
                        .width(8f)
                        .color(Color.RED)
        )

        mMap.addPolygon(
                PolygonOptions()
                        .add(vimannagar)
                        .add(hadapsar)
                        .add(katraj)
                        .add(hinjewadi)
        )

        mMap.addCircle(
                CircleOptions()
                        .center(vimannagar)
                        .radius(1000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))
        )

        mMap.addCircle(
                CircleOptions()
                        .center(hadapsar)
                        .radius(1000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))
        )

        mMap.addCircle(
                CircleOptions()
                        .center(katraj)
                        .radius(1000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))
        )

        mMap.addCircle(
                CircleOptions()
                        .center(hinjewadi)
                        .radius(1000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))
        )

        // For enabling traffic
        mMap.isTrafficEnabled = true
        // For enabling 3d buildings
        mMap.isBuildingsEnabled = true

        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isRotateGesturesEnabled = true

    }
}