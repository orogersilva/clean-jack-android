package com.orogersilva.cleanjack;

import android.os.Handler;

import com.orogersilva.cleanjack.domain.executor.MainThread;

/**
 * Created by orogersilva on 1/12/2017.
 */

public class MainThreadImpl implements MainThread {

    // region FIELDS

    private static MainThread INSTANCE;
    private Handler mHandler;

    // endregion

    // region CONSTRUCTORS

    private MainThreadImpl() {

        mHandler = new Handler();
    }

    // endregion

    // region STATIC METHODS

    public static MainThread getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new MainThreadImpl();
        }

        return INSTANCE;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void post(Runnable runnable) {

        mHandler.post(runnable);
    }

    // endregion
}
