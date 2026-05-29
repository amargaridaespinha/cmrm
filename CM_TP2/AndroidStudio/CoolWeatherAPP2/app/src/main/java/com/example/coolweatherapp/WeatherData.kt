package com.example.coolweatherapp

data class WeatherData(
    var latitude: Float,
    var longitude: Float,
    var current_weather: CurrentWeather,
    var hourly: Hourly
)

data class CurrentWeather(
    var temperature: Float,
    var windspeed: Float,
    var winddirection: Int,
    var weathercode: Int,
    var time: String
)

data class Hourly(
    var pressure_msl: ArrayList<Double>
)