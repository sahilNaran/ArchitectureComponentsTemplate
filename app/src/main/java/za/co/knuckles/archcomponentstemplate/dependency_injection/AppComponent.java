package za.co.knuckles.archcomponentstemplate.dependency_injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import za.co.knuckles.archcomponentstemplate.ArchComponentsTemplateApplication;
import za.co.knuckles.archcomponentstemplate.dependency_injection.modules.ActivityModule;
import za.co.knuckles.archcomponentstemplate.dependency_injection.modules.AppModule;
import za.co.knuckles.archcomponentstemplate.dependency_injection.modules.FragmentModule;

@Singleton
@Component(modules = {ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(ArchComponentsTemplateApplication application);

}
