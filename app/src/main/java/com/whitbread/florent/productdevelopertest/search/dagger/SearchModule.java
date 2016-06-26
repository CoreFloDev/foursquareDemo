package com.whitbread.florent.productdevelopertest.search.dagger;

import com.whitbread.florent.productdevelopertest.search.SearchPresenter;
import com.whitbread.florent.productdevelopertest.search.SearchService;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

    @Provides
    @SearchScope
    public SearchPresenter provideSearchPresenter(SearchService searchService) {
        return new SearchPresenter(searchService);
    }

    @Provides
    @SearchScope
    public SearchService provideSearchService() {
        return new SearchService();
    }
}
