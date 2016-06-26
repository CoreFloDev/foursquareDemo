package com.whitbread.florent.productdevelopertest.search;

import com.whitbread.florent.productdevelopertest.common.mvp.Presenter;
import com.whitbread.florent.productdevelopertest.common.mvp.PresenterView;

public class SearchPresenter implements Presenter {

    private SearchService searchService;
    private View presenterView;

    public SearchPresenter(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public void attachView(PresenterView presenterView) {
        this.presenterView = (View) presenterView;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {

    }

    interface View extends PresenterView {

    }
}
