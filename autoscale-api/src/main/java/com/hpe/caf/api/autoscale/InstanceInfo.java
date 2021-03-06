/*
 * Copyright 2015-2018 Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hpe.caf.api.autoscale;


import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


/**
 * Contains information about the instances of a currently running service.
 */
public final class InstanceInfo
{
    private final int instancesRunning;
    private final int instancesStaging;
    private final Collection<ServiceHost> hosts;


    public InstanceInfo(final int running, final int staging, final Collection<ServiceHost> hosts)
    {
        this.instancesRunning = running;
        this.instancesStaging = staging;
        this.hosts = Collections.unmodifiableCollection(Objects.requireNonNull(hosts));
    }


    /**
     * @return the number of instances of a service that are running and active
     */
    public int getInstancesRunning()
    {
        return instancesRunning;
    }


    /**
     * @return the number of instances of a service that are being prepared to run
     */
    public int getInstancesStaging()
    {
        return instancesStaging;
    }


    /**
     * @return the combination of the number of running instances and those being prepared
     */
    public int getTotalInstances()
    {
        return getInstancesRunning() + getInstancesStaging();
    }


    /**
     * @return the hosts that these instances are running upon
     */
    public Collection<ServiceHost> getHosts()
    {
        return hosts;
    }
}
