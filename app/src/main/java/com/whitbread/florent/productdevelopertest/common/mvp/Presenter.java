package com.whitbread.florent.productdevelopertest.common.mvp;

public interface Presenter {

    void attachView(PresenterView presenterView);

    void detachView();

    void destroy();
}
