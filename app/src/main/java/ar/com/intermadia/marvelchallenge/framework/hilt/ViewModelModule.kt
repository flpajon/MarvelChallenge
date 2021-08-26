package ar.com.intermadia.marvelchallenge.framework.hilt

import ar.com.intermadia.marvelchallenge.data.character.CharacterDataSourceImpl
import ar.com.intermadia.marvelchallenge.data.character.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class ViewModelModule {

    @Provides
    fun provideIsUserAuth(dataSourceCharacter: CharacterDataSourceImpl) = CharacterRepository(dataSourceCharacter)
}