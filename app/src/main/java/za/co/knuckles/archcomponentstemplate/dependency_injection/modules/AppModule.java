package za.co.knuckles.archcomponentstemplate.dependency_injection.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import za.co.knuckles.archcomponentstemplate.BuildConfig;
import za.co.knuckles.archcomponentstemplate.repositories.database.ArchComponentsTemplateDatabase;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    //Web api
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.API_BASE_URL)
                .build();
        return retrofit;
    }

    //Database
    @Provides
    @Singleton
    ArchComponentsTemplateDatabase provideDatabase(Application application) {
        return Room
                .databaseBuilder(application, ArchComponentsTemplateDatabase.class, BuildConfig.DATABASE_NAME)
                .build();
    }


}
