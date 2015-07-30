/*
 * Copyright (C) 2014 by Array Systems Computing Inc. http://www.array.ca
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
package org.esa.snap.dem.dataio.srtm3_geotiff;

import org.esa.snap.dem.dataio.EarthGravitationalModel96;
import org.esa.snap.framework.datamodel.GeoPos;
import org.esa.snap.framework.datamodel.PixelPos;
import org.esa.snap.framework.datamodel.Product;
import org.esa.snap.framework.dataop.dem.BaseElevationTile;

import java.io.IOException;

public final class SRTM3GeoTiffElevationTile extends BaseElevationTile {

    private final EarthGravitationalModel96 egm;

    public SRTM3GeoTiffElevationTile(final SRTM3GeoTiffElevationModel dem, final Product product) throws IOException {
        super(dem, product);
        egm = EarthGravitationalModel96.instance();
    }

    protected void addGravitationalModel(final int index, final float[] line) throws Exception {
        final PixelPos pixPos = new PixelPos();
        final double[][] v = new double[4][4];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != noDataValue) {
                pixPos.setLocation(i, index);
                GeoPos geoPos = demModel.getGeoPos(pixPos);
                line[i] += egm.getEGM(geoPos.lat, geoPos.lon, v);
            }
        }
    }
}
