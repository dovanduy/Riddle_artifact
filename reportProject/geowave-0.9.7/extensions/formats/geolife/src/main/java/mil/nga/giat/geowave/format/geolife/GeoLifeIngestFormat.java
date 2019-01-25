/*******************************************************************************
 * Copyright (c) 2013-2017 Contributors to the Eclipse Foundation
 * 
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License,
 * Version 2.0 which accompanies this distribution and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.txt
 ******************************************************************************/
package mil.nga.giat.geowave.format.geolife;

import mil.nga.giat.geowave.adapter.vector.ingest.AbstractSimpleFeatureIngestFormat;
import mil.nga.giat.geowave.adapter.vector.ingest.AbstractSimpleFeatureIngestPlugin;
import mil.nga.giat.geowave.core.ingest.avro.WholeFile;
import mil.nga.giat.geowave.core.ingest.spi.IngestFormatOptionProvider;

/**
 * This represents an ingest format plugin provider for GeoLife data. It will
 * support ingesting directly from a local file system or staging data from a
 * local files system and ingesting into GeoWave using a map-reduce job.
 */
public class GeoLifeIngestFormat extends
		AbstractSimpleFeatureIngestFormat<WholeFile>
{

	@Override
	protected AbstractSimpleFeatureIngestPlugin<WholeFile> newPluginInstance(
			IngestFormatOptionProvider options ) {
		return new GeoLifeIngestPlugin();
	}

	@Override
	public String getIngestFormatName() {
		return "geolife";
	}

	@Override
	public String getIngestFormatDescription() {
		return "files from Microsoft Research GeoLife trajectory data set";
	}
}
