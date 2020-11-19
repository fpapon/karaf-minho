/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.core;

import java.util.List;

public class KarafConfig {

    public String baseDirectory = System.getProperty("java.io.tmpdir") + "/karaf";
    public String dataDirectory = baseDirectory + "/data";
    public String etcDirectory = baseDirectory + "/etc";
    public String cacheDirectory = baseDirectory + "/cache";
    public boolean clearCache = false;
    public int defaultBundleStartLevel = 50;
    public List<String> applications;

    private KarafConfig() {
    }

    public KarafConfig withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        this.cacheDirectory = baseDirectory + "/cache";
        this.dataDirectory = baseDirectory + "/data";
        System.setProperty("karaf.data", dataDirectory);
        this.etcDirectory = baseDirectory + "/etc";
        System.setProperty("karaf.etc", etcDirectory);
        return this;
    }

    public KarafConfig withClearCache(boolean clearCache) {
        this.clearCache = clearCache;
        return this;
    }

    public KarafConfig withDefaultBundleStartLevel(int level) {
        this.defaultBundleStartLevel = level;
        return this;
    }

    public KarafConfig withApplication(String url) {
        this.applications.add(url);
        return this;
    }

    public static KarafConfig build() {
        return new KarafConfig();
    }
}
