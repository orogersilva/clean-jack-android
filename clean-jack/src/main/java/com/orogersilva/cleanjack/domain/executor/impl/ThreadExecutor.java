package com.orogersilva.cleanjack.domain.executor.impl;

import com.orogersilva.cleanjack.domain.executor.Executor;
import com.orogersilva.cleanjack.domain.usecase.base.AbstractUseCase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by orogersilva on 1/12/2017.
 */

public class ThreadExecutor implements Executor {

    // region FIELDS

    private static ThreadExecutor sThreadExecutor;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    // endregion

    // region CONSTRUCTORS

    private ThreadExecutor() {

        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    // endregion

    // region STATIC METHODS

    public static ThreadExecutor getInstance() {

        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }

        return sThreadExecutor;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void execute(final AbstractUseCase useCase) {

        mThreadPoolExecutor.submit(new Runnable() {

            @Override
            public void run() {

                useCase.run();
                useCase.onFinished();
            }
        });
    }

    // endregion
}
