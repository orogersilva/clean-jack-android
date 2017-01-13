package com.orogersilva.cleanjack.domain.usecase.base;

import com.orogersilva.cleanjack.domain.executor.Executor;
import com.orogersilva.cleanjack.domain.executor.MainThread;

/**
 * Created by orogersilva on 1/12/2017.
 */

public abstract class AbstractUseCase implements UseCase {

    // region FIELDS

    protected Executor mThreadExecutor;
    protected MainThread mMainThread;

    protected boolean mIsCancelled;
    protected boolean mIsRunning;

    // endregion

    // region CONSTRUCTORS

    public AbstractUseCase(Executor threadExecutor, MainThread mainThread) {

        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    // endregion

    // region ABSTRACT METHODS

    public abstract void run();

    // endregion

    // region PUBLIC METHODS

    public boolean isRunning() {

        return mIsRunning;
    }

    public void cancel() {

        mIsCancelled = true;
        mIsRunning = false;
    }

    public void onFinished() {

        mIsCancelled = false;
        mIsRunning = false;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void execute() {

        mIsRunning = true;

        mThreadExecutor.execute(this);
    }

    // endregion
}
