/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.shop.payment.store;

import java.util.List;
import java.util.UUID;

import org.mayocat.shop.payment.model.PaymentOperation;
import org.mayocat.store.Store;
import org.xwiki.component.annotation.Role;

/**
 * @version $Id$
 */
@Role
public interface PaymentOperationStore extends Store<PaymentOperation, UUID>
{
    List<PaymentOperation> findAllForOrderId(UUID order);
}