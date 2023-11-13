package com.timurpehlivan.cocktail.core.data.database.factory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.timurpehlivan.cocktail.CocktailDatabase
import org.koin.core.scope.Scope

const val DATABASE_NAME: String = "Cocktail.db"

actual fun Scope.createPlatformDatabaseDriver(): SqlDriver {
    return NativeSqliteDriver(CocktailDatabase.Schema, DATABASE_NAME)
}