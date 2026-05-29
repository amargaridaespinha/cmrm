package com.example.coolweatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    private fun weatherAPICall(lat: Float, lon: Float): WeatherData {

        val reqString =
            "https://api.open-meteo.com/v1/forecast?" +
                    "latitude=$lat&longitude=$lon&" +
                    "current_weather=true&" +
                    "hourly=pressure_msl"

        URL(reqString).openStream().use {

            return Gson().fromJson(
                InputStreamReader(it, "UTF-8"),
                WeatherData::class.java
            )
        }
    }

    private fun fetchWeatherData(lat: Float, lon: Float): Thread {

        return Thread {

            val weather = weatherAPICall(lat, lon)

            updateUI(weather)
        }
    }

    private fun updateUI(request: WeatherData) {

        runOnUiThread {

            val latitude = findViewById<TextView>(R.id.latitudeValue)
            val longitude = findViewById<TextView>(R.id.longitudeValue)
            val temperature = findViewById<TextView>(R.id.tempValue)
            val pressure = findViewById<TextView>(R.id.pressureValue)
            val windSpeed = findViewById<TextView>(R.id.windSpeedValue)
            val windDirection = findViewById<TextView>(R.id.windDirectionValue)
            val time = findViewById<TextView>(R.id.timeValue)
            val weatherImage = findViewById<ImageView>(R.id.weatherImage)

            latitude.text = "Latitude: ${request.latitude}"

            longitude.text = "Longitude: ${request.longitude}"

            temperature.text =
                "Temperature: ${request.current_weather.temperature}°C"

            pressure.text =
                "Pressure: ${request.hourly.pressure_msl[0]} hPa"

            windSpeed.text =
                "Wind Speed: ${request.current_weather.windspeed} km/h"

            windDirection.text =
                "Wind Direction: ${request.current_weather.winddirection}°"

            time.text =
                "Time: ${request.current_weather.time}"

            when (request.current_weather.weathercode) {

                0 -> weatherImage.setImageResource(R.drawable.clear_day)

                1, 2 -> weatherImage.setImageResource(R.drawable.partly_cloudy_day)

                3 -> weatherImage.setImageResource(R.drawable.cloudy)

                45, 48 -> weatherImage.setImageResource(R.drawable.fog)

                51, 53, 55,
                61, 63, 65 ->
                    weatherImage.setImageResource(R.drawable.rain)

                else ->
                    weatherImage.setImageResource(R.drawable.cloudy)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        fetchWeatherData(38.76f, -9.12f).start()

        val updateButton = findViewById<Button>(R.id.updateButton)

        updateButton.setOnClickListener {

            val latInput =
                findViewById<android.widget.EditText>(R.id.latitudeInput)

            val lonInput =
                findViewById<android.widget.EditText>(R.id.longitudeInput)

            val lat = latInput.text.toString().toFloat()

            val lon = lonInput.text.toString().toFloat()

            fetchWeatherData(lat, lon).start()
        }
    }
}
