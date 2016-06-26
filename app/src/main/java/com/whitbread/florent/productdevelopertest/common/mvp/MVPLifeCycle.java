package com.whitbread.florent.productdevelopertest.common.mvp;

import android.app.Activity;

public class MVPLifeCycle {

    public MVPLifeCycle() {
    }

    public void onAttachView(Presenter presenter, PresenterView presenterView) {
        if (presenter == null || presenterView == null) {
            return;
        }
        presenter.attachView(presenterView);
    }

    public void onDetachView(Presenter presenter) {
        if (presenter == null) {
            return;
        }
        presenter.detachView();
    }

    public void onDestroy(Activity activity, Presenter presenter) {
        if (presenter == null) {
            return;
        }
        if (activity.isFinishing()) {
            presenter.destroy();
        }
    }
}
