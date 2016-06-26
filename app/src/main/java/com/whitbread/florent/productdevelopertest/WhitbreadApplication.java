package com.whitbread.florent.productdevelopertest;

import android.app.Application;
import android.content.Context;

import com.whitbread.florent.productdevelopertest.common.ComponentsManager;
import com.whitbread.florent.productdevelopertest.common.dagger.ApplicationComponent;
import com.whitbread.florent.productdevelopertest.common.dagger.DaggerApplicationComponent;
import com.whitbread.florent.productdevelopertest.common.dagger.ApplicationModule;

public class WhitbreadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger(this);
    }

    private void initDagger(Context context) {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(context)).build();
        ComponentsManager.get().setAppComponent(applicationComponent);
        applicationComponent.inject(this);
    }


}
