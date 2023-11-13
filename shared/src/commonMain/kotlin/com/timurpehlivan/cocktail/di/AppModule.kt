package com.timurpehlivan.cocktail.di

import app.cash.sqldelight.db.SqlDriver
import com.timurpehlivan.cocktail.CocktailDatabase
import com.timurpehlivan.cocktail.core.data.database.factory.createDatabase
import com.timurpehlivan.cocktail.core.data.database.factory.createPlatformDatabaseDriver
import com.timurpehlivan.cocktail.core.data.network.factory.createHttpClient
import com.timurpehlivan.cocktail.data.database.dao.CocktailDao
import com.timurpehlivan.cocktail.data.datasource.local.LocalDataSource
import com.timurpehlivan.cocktail.data.datasource.local.LocalDataSourceImpl
import com.timurpehlivan.cocktail.data.datasource.remote.RemoteDataSource
import com.timurpehlivan.cocktail.data.datasource.remote.RemoteDataSourceImpl
import com.timurpehlivan.cocktail.data.network.service.CocktailService
import com.timurpehlivan.cocktail.data.network.service.CocktailServiceImpl
import com.timurpehlivan.cocktail.data.repository.CocktailRepositoryImpl
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository
import com.timurpehlivan.cocktail.domain.usecase.CheckCocktailSavedUseCase
import com.timurpehlivan.cocktail.domain.usecase.DeleteCocktailUseCase
import com.timurpehlivan.cocktail.domain.usecase.GetCocktailDetailUseCase
import com.timurpehlivan.cocktail.domain.usecase.GetCocktailListUseCase
import com.timurpehlivan.cocktail.domain.usecase.GetSavedCocktailListUseCase
import com.timurpehlivan.cocktail.domain.usecase.SaveCocktailUseCase
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailViewModel
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListViewModel
import com.timurpehlivan.cocktail.presentation.feature.saved.SavedCocktailListViewModel
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration? = {}) =
    startKoin {
        appDeclaration?.let { it() }
        modules(
            databaseModule,
            networkModule,
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
    }

private val databaseModule = module {
    single { createPlatformDatabaseDriver() }
    single { createDatabase(driver = get<SqlDriver>()) }
    single { CocktailDao(cocktailDatabase = get<CocktailDatabase>()) }
}

private val networkModule = module {
    single<HttpClient> { createHttpClient() }
    single<CocktailService> { CocktailServiceImpl(httpClient = get<HttpClient>()) }
}

private val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(cocktailService = get<CocktailService>()) }
    single<LocalDataSource> { LocalDataSourceImpl(cocktailDao = get<CocktailDao>()) }
}

private val repositoryModule = module {
    single<CocktailRepository> {
        CocktailRepositoryImpl(
            remoteDataSource = get<RemoteDataSource>(),
            localDataSource = get<LocalDataSource>()
        )
    }
}

private val useCaseModule = module {
    single<GetCocktailListUseCase> { GetCocktailListUseCase(cocktailRepository = get<CocktailRepository>()) }
    single<GetCocktailDetailUseCase> { GetCocktailDetailUseCase(cocktailRepository = get<CocktailRepository>()) }
    single<SaveCocktailUseCase> { SaveCocktailUseCase(cocktailRepository = get<CocktailRepository>()) }
    single<DeleteCocktailUseCase> { DeleteCocktailUseCase(cocktailRepository = get<CocktailRepository>()) }
    single<CheckCocktailSavedUseCase> { CheckCocktailSavedUseCase(cocktailRepository = get<CocktailRepository>()) }
    single<GetSavedCocktailListUseCase> { GetSavedCocktailListUseCase(cocktailRepository = get<CocktailRepository>()) }
}

private val viewModelModule = module {
    single<CocktailListViewModel> {
        CocktailListViewModel(getCocktailListUseCase = get<GetCocktailListUseCase>())
    }
    single<SavedCocktailListViewModel> {
        SavedCocktailListViewModel(
            getSavedCocktailListUseCase = get<GetSavedCocktailListUseCase>()
        )
    }
    single<CocktailDetailViewModel> {
        CocktailDetailViewModel(
            getCocktailDetailUseCase = get<GetCocktailDetailUseCase>(),
            checkCocktailSavedUseCase = get<CheckCocktailSavedUseCase>(),
            saveCocktailUseCase = get<SaveCocktailUseCase>(),
            deleteCocktailUseCase = get<DeleteCocktailUseCase>(),
        )
    }
}