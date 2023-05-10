package com.example.minggu10;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Acara34_2 extends AppCompatActivity implements OnMapReadyCallback {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    private Location mLastLocation;
    private Circle mCircle;

    private static final double CIRCLE_LAT = -7.5946; // Latitude of circle center
    private static final double CIRCLE_LONG = 111.9047; // Longitude of circle center
    private static final float CIRCLE_RADIUS = 500; // Radius of circle in meters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara34_2);

        // Initialize FusedLocationProviderClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and initialize the map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Request location permission if not granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
            return;
        }

        // Enable My Location on the map
        mMap.setMyLocationEnabled(true);

        // Start listening for location updates
        startLocationUpdates();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted, enable My Location on the map and start location updates
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // ask permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION_PERMISSION);
                return;
            }
            mMap.setMyLocationEnabled(true);
            startLocationUpdates();
        } else {
            Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void startLocationUpdates() {
        // Create a location request
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000); // Update location every 10 seconds

        // Create a location callback to handle location updates
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                // Get the current location
                Location location = locationResult.getLastLocation();
                if (location != null) {

                    // Update the map with the current location
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Current Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));

                    // Add a circle with the given radius from the current location
                    double manualLatitude = -7.5946; // Replace with the desired latitude
                    double manualLongitude = 111.9047; // Replace with the desired longitude
                    double radiusInMeters = 500; // Change this value to set the desired radius in meters
                    CircleOptions circleOptions = new CircleOptions()
                            .center(new LatLng(manualLatitude, manualLongitude))
                            .radius(radiusInMeters)
                            .strokeWidth(2)
                            .strokeColor(R.color.colorCircle)
                            .fillColor(R.color.colorCircleFill); // Change the color as desired
                    mCircle = mMap.addCircle(circleOptions);

                    proximity();
                }
            }
        };

        // Request location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.requestLocationUpdates(locationRequest, mLocationCallback, null);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Remove location updates when the activity is stopped
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    private void proximity() {

        // Get the current user's location
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // ask permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // Create a LatLng object for the circle center
        LatLng circleCenter = new LatLng(CIRCLE_LAT, CIRCLE_LONG);

        // Calculate the distance between the user's location and the circle center
        float[] distance = new float[2];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(),
                CIRCLE_LAT, CIRCLE_LONG, distance);

        if (isLocationSignificantlyChanged(location)) {
            // The user has moved significantly, remove the proximity alert
            // Check if the user is outside the circle
            if (distance[0] > CIRCLE_RADIUS) {
                Toast.makeText(this, "Please move within the proximity circle", Toast.LENGTH_LONG).show();
            } else {
                // The user is inside the circle, set up proximity alert to open URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://uptime.yoganova.my.id"));
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);
                locationManager.addProximityAlert(CIRCLE_LAT, CIRCLE_LONG, CIRCLE_RADIUS, -1, pendingIntent);
                Toast.makeText(this, "Location is within the proximity circle", Toast.LENGTH_LONG).show();
            }
        }
        mLastLocation = location;
    }

    private boolean isLocationSignificantlyChanged(Location location) {
        // Check if the location is significantly different from the previous location
        if (mLastLocation == null) {
            // If there is no previous location, consider the location as significantly changed
            return true;
        }

        // Calculate the distance between the current location and previous location
        float distance = location.distanceTo(mLastLocation);

        // Check if the distance is greater than a threshold (e.g., 20 meters)
        if (distance > 20) {
            // If the distance is greater than the threshold, consider the location as significantly changed
            return true;
        }

        return false;
    }
}
