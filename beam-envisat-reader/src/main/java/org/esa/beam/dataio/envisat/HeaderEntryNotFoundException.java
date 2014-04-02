/*
 * Copyright (C) 2010 Brockmann Consult GmbH (info@brockmann-consult.de)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see http://www.gnu.org/licenses/
 */
package org.esa.beam.dataio.envisat;

import org.esa.beam.framework.dataio.ProductIOException;

/**
 * Thrown if an entry in an ENVISAT header could not be found.
 */
public class HeaderEntryNotFoundException extends ProductIOException {

    private static final long serialVersionUID = -946209513433311834L;

    /**
     * Constructs a new exception with the given error message.
     *
     * @param message the error message
     */
    public HeaderEntryNotFoundException(String message) {
        super(message);
    }
}