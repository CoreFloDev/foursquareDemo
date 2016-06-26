package com.whitbread.florent.productdevelopertest.search;

import android.os.Bundle;

import com.whitbread.florent.productdevelopertest.R;
import com.whitbread.florent.productdevelopertest.common.ComponentsManager;
import com.whitbread.florent.productdevelopertest.common.activity.BaseActivity;
import com.whitbread.florent.productdevelopertest.common.mvp.MVPLifeCycle;
import com.whitbread.florent.productdevelopertest.search.dagger.SearchComponent;
import com.whitbread.florent.productdevelopertest.search.dagger.DaggerSearchComponent;
import com.whitbread.florent.productdevelopertest.search.dagger.SearchModule;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity implements SearchPresenter.View{

    @Inject
    MVPLifeCycle lifeCycle;

    @Inject
    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initDagger(savedInstanceState == null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifeCycle.onAttachView(presenter, this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifeCycle.onDetachView(presenter);
    }

    @Override
    protected void onDestroy() {
        lifeCycle.onDestroy(this, presenter);
        super.onDestroy();
    }

    private void initDagger(boolean requireNewComponent) {
        ComponentsManager componentsManager = ComponentsManager.get();
        SearchComponent component;
        if (!requireNewComponent) {
            component = componentsManager.getBaseComponent(SearchComponent.KEY);
            component.inject(this);
            return;
        }
        SearchModule searchModule = new SearchModule();
        component = DaggerSearchComponent.builder().applicationComponent(componentsManager.getAppComponent()).searchModule(searchModule).build();
        componentsManager.putBaseComponent(SearchComponent.KEY, component);
        component.inject(this);
    }
}
