/*
 * Copyright 2013 Rackspace
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.rackspacecloud.blueflood.service;

import java.util.Collection;

public interface ZKShardLockManagerMBean {
    public Collection<Integer> getHeldShards();
    public Collection<Integer> getUnheldShards();
    public Collection<Integer> getErrorShards();
    
    public long getMinLockHoldTimeMillis();
    public void setMinLockHoldTimeMillis(long millis);
    
    public long getLockDisinterestedTimeMillis();
    public void setLockDisinterestedTimeMillis(long millis);
    
    public void forceLockScavenge();
    public long getSecondsSinceLastScavenge();
    public String getZkConnectionStatus();
    
    public boolean release(int shard);
    public boolean acquire(int shard);
}
