package za.co.knuckles.archcomponentstemplate;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import za.co.knuckles.archcomponentstemplate.dependency_injection.DaggerAppComponent;

public class ArchComponentsTemplateApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate(){
        super.onCreate();
        this.initialiseDagger();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    private void initialiseDagger() {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }
}
