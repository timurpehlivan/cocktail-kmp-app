package com.timurpehlivan.cocktail.core.data.database.factory

import app.cash.sqldelight.db.SqlDriver
import org.koin.core.scope.Scope

expect fun Scope.createPlatformDatabaseDriver(): SqlDriver