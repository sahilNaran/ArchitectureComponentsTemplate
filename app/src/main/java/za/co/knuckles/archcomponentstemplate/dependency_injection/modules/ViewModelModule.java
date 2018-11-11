package za.co.knuckles.archcomponentstemplate.dependency_injection.modules;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import za.co.knuckles.archcomponentstemplate.view_models.ViewModelFactory;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
