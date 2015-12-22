package com.gaadi.dagger.junit.dagger;

import android.app.Application;

import com.gaadi.dagger.junit.ui.activity.AutoCompleteActivity;
import com.gaadi.dagger.junit.ui.activity.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vinodtakhar on 2/12/15.
 */
public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent= DaggerMyApplication_ApplicationComponent.builder().appModule(new AppModule()).build();

        component().inject(this);
    }

    public ApplicationComponent component() {
        return applicationComponent;
    }

//    public void setApplicationComponent(ApplicationComponent component) {
//        this.applicationComponent = component;
//    }

    @Singleton
    @Component(modules = AppModule.class)
    public interface ApplicationComponent {
        void inject(MyApplication application);

        void inject(LoginActivity loginActivity);

        void inject(AutoCompleteActivity autoCompleteActivity);
    }
}
