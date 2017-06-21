/*
 * Copyright (c) 2017 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.sdk.server.events.operators;

import javax.annotation.Nullable;

import org.eclipse.milo.opcua.sdk.server.events.OperatorContext;
import org.eclipse.milo.opcua.sdk.server.model.nodes.objects.BaseEventNode;
import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.structured.FilterOperand;

public class IsNull implements Operator<Boolean> {

    IsNull() {}

    @Nullable
    @Override
    public Boolean apply(
        OperatorContext context,
        BaseEventNode eventNode,
        FilterOperand[] operands) throws UaException {

        if (operands.length < 1) {
            throw new UaException(StatusCodes.Bad_FilterOperandCountMismatch);
        }

        Object value = context.resolve(operands[0], eventNode);

        return value == null;
    }

}
