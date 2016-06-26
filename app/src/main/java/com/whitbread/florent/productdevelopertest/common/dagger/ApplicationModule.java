package com.whitbread.florent.productdevelopertest.common.dagger;

import android.content.Context;

import com.whitbread.florent.productdevelopertest.common.mvp.MVPLifeCycle;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    public Context provideAppContext() {
        return context;
    }

    @Provides
    @ApplicationScope
    public MVPLifeCycle provideMVPLifeCycle() {
        return new MVPLifeCycle();
    }
}
