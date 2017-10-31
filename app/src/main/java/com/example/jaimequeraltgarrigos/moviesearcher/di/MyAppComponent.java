package com.example.jaimequeraltgarrigos.moviesearcher.di;

import android.app.Application;

import com.example.jaimequeraltgarrigos.moviesearcher.MovieSearcherApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class, ActivityBuilderModule.class})
public interface MyAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        MyAppComponent build();

    }

    void inject(MovieSearcherApp movieSearcherApp);
}

