/*
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @version $Id$
 */
public enum AddonSource
{
    PLATFORM,
    THEME;

    @JsonValue
    public String toJson()
    {
        return name().toLowerCase();
    }

    @JsonCreator
    public static AddonSource fromJson(String text)
    {
        return valueOf(text.toUpperCase());
    }

}
