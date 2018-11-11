package za.co.knuckles.archcomponentstemplate.dependency_injection.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import za.co.knuckles.archcomponentstemplate.views.activities.MainActivity;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
