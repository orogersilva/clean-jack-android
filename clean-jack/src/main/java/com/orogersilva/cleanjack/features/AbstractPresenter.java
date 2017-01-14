package com.orogersilva.cleanjack.features;

import com.orogersilva.cleanjack.domain.executor.Executor;
import com.orogersilva.cleanjack.domain.executor.MainThread;

/**
 * Created by orogersilva on 1/14/2017.
 */

public abstract class AbstractPresenter {

    // region FIELDS

    protected Executor mExecutor;
    protected MainThread mMainThread;

    // endregion

    // region CONSTRUCTORS

    public AbstractPresenter(Executor executor, MainThread mainThread) {

        mExecutor = executor;
        mMainThread = mainThread;
    }

    // endregion
}
