package za.co.knuckles.archcomponentstemplate.view_models;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory{

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends  ViewModel> creator = creators.get(modelClass);

        if(creator == null){
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()){
                if(modelClass.isAssignableFrom(entry.getKey())){
                    creator = entry.getValue();
                    break;
                }
            }
        }

        if(creator == null) {
            throw new IllegalArgumentException(String.format("Invalid model %s", modelClass));
        }

        return (T) creator.get();

    }
}