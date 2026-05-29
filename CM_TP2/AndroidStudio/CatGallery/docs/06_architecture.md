# Architecture

Architecture pattern: MVVM

Layers:

## UI Layer
- MainActivity
- CatAdapter
- XML layouts

## ViewModel Layer
- MainViewModel

## Repository Layer
- CatRepository

## API Layer
- CatApiService
- Retrofit

Data flow:

MainActivity → MainViewModel → CatRepository → CatApiService → The Cat API