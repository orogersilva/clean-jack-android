package com.orogersilva.cleanjack.domain.executor;

import com.orogersilva.cleanjack.domain.usecase.base.AbstractUseCase;

/**
 * Created by orogersilva on 1/12/2017.
 */

public interface Executor {

    // region METHODS

    void execute(final AbstractUseCase useCase);

    // endregion
}
