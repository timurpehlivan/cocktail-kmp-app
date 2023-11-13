# Cocktail - Kotlin Multiplatform App
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
![Badge-ios](http://img.shields.io/badge/platform-ios-EAEAEA.svg?style=flat)
![Badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)

## Overview

Cocktail is a **Kotlin Multiplatform** project developed entirely in **Kotlin** for both **iOS** and **Android** platforms, 
built with **Compose Multiplatform** based on **Model-View-Intent (MVI)** and **Clean Architecture** principles.
The app allows users to search for cocktails from a remote service, display recipes, and save them to the local database.

## Architecture

![MVI - Clean Architecture](https://github.com/JetBrains/compose-multiplatform/assets/23058439/d5295d89-d7b6-4f7e-ac7f-21409d2aa8eb)

## Tech Stack & Library

* [Kotlin](https://github.com/JetBrains/kotlin): For programming language.
* [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform): For sharing code across multiple platforms.
* [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform): For sharing declarative UI across multiple platforms.
* [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines): For asynchronous operations.
* [Ktor](https://github.com/ktorio/ktor): For http client.
* [SqlDelight](https://github.com/cashapp/sqldelight): For local data storage.
* [Koin](https://github.com/InsertKoinIO/koin): For dependency injection.
* [Moko ViewModel](https://github.com/icerockdev/moko-mvvm): For ViewModel component.
* [Voyager](https://github.com/adrielcafe/voyager): For navigation within the app.
* [Kamel](https://github.com/Kamel-Media/Kamel): For image handling.
* [Material 3](https://m3.material.io): For a modern, consistent design language and dynamic colors support.