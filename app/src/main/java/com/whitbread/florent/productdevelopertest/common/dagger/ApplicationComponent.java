package com.whitbread.florent.productdevelopertest.common.dagger;


import android.content.Context;

import com.whitbread.florent.productdevelopertest.WhitbreadApplication;
import com.whitbread.florent.productdevelopertest.common.mvp.MVPLifeCycle;

import dagger.Component;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent extends BaseComponent {

    MVPLifeCycle mvpLifeCycle();

    Context context();

    void inject(WhitbreadApplication whitbreadApplication);
}
