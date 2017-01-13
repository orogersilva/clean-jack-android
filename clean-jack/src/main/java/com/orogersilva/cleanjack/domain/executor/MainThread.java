package com.orogersilva.cleanjack.domain.executor;

/**
 * Created by orogersilva on 1/12/2017.
 */

public interface MainThread {

    // region METHODS

    void post(final Runnable runnable);

    // endregion
}
