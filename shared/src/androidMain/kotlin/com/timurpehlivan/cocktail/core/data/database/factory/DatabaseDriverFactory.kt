package com.timurpehlivan.cocktail.core.data.database.factory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.timurpehlivan.cocktail.CocktailDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

const val DATABASE_NAME: String = "Cocktail.db"

actual fun Scope.createPlatformDatabaseDriver(): SqlDriver {
    return AndroidSqliteDriver(CocktailDatabase.Schema, androidContext(), DATABASE_NAME)
}