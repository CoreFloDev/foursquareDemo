package com.whitbread.florent.productdevelopertest.search.dagger;

import com.whitbread.florent.productdevelopertest.common.dagger.ApplicationComponent;
import com.whitbread.florent.productdevelopertest.common.dagger.BaseComponent;
import com.whitbread.florent.productdevelopertest.search.SearchActivity;

import dagger.Component;

@SearchScope
@Component(dependencies = ApplicationComponent.class, modules = SearchModule.class)
public interface SearchComponent extends BaseComponent {

    String KEY = SearchComponent.class.getSimpleName();

    void inject(SearchActivity searchActivity);
}
