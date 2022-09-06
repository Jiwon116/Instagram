package com.example.instagram

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.instagram.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Exception
import java.util.*

class MapActivity: AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding
    private lateinit var mMap: GoogleMap
    lateinit var mapFragment: SupportMapFragment

    private lateinit var mLocationManager: LocationManager
    private lateinit var mLocationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map_view_fm) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnMapClickListener(listener)
        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        mLocationListener = LocationListener { location ->
            mMap.clear()
            val curLocation = LatLng(location.latitude, location.longitude)
            mMap.addMarker(MarkerOptions().position(curLocation).title("내 위치"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(curLocation, 15f))

            val geocoder = Geocoder(this@MapActivity, Locale.getDefault())
            try {
                val addressList = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                if(addressList.size > 0) {
                    Log.d("addressList", addressList[0].toString())
                }
            } catch (e : Exception) {
                e.printStackTrace()
            }
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, mLocationListener)
            val lastknownLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (lastknownLocation != null) {
                val lastKnowLatLng = LatLng(lastknownLocation.latitude, lastknownLocation.longitude)
                mMap.addMarker(MarkerOptions().position(lastKnowLatLng).title("내 위치"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastKnowLatLng,15f))
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1) {
            if(grantResults.size < 1) {
                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1f, mLocationListener)
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    private val listener = GoogleMap.OnMapClickListener { p0 ->
        mMap.clear()
        val geocoder = Geocoder(this@MapActivity, Locale.getDefault())
        var address = ""
        try {
            val addressList = geocoder.getFromLocation(p0.latitude, p0.longitude,1)
            if (addressList.size > 0 ) {
                if (addressList[0].thoroughfare != null) {
                    address += addressList[0].thoroughfare
                    if (addressList[0].subThoroughfare != null) {
                        address += addressList[0].subThoroughfare
                    }
                }
            }
        } catch (e:Exception){
            e.printStackTrace()
        }
        mMap.addMarker(MarkerOptions().position(p0).title(address))
    }
}
