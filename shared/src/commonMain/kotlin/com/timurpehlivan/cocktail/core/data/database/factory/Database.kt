package com.timurpehlivan.cocktail.core.data.database.factory

import app.cash.sqldelight.db.SqlDriver
import com.timurpehlivan.cocktail.CocktailDatabase

fun createDatabase(driver: SqlDriver): CocktailDatabase {
    return CocktailDatabase(driver)
}