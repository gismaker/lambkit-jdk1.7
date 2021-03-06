/**
 * Copyright (c) 2015-2017, Henry Yang 杨勇 (gismail@foxmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lambkit.core.rpc;

import com.lambkit.common.util.ClassNewer;
import com.lambkit.core.config.ConfigManager;
import com.lambkit.core.rpc.motan.MotanRpc;
import com.lambkit.core.rpc.zbus.ZbusRpc;

public class RpcManager {
    private static RpcManager manager;

    public static RpcManager me() {
        if (manager == null) {
            manager = ClassNewer.singleton(RpcManager.class);
        }
        return manager;
    }


    private RpcPlugin rpc;
    private RpcConfig config = ConfigManager.me().get(RpcConfig.class);


    public Rpc getRpc() {
    	return getPlugin();
    }
    
    public RpcPlugin getPlugin() {
    	if (rpc == null) {
        	rpc = createRpc();
        }
        return rpc;
    }

    private RpcPlugin createRpc() {
        switch (config.getType()) {
            case RpcConfig.TYPE_MOTAN:
                return new MotanRpc();
            case RpcConfig.TYPE_ZBUS:
                return new ZbusRpc();
            default:
            	return new MotanRpc();
        }
    }
}
