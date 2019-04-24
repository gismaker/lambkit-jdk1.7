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
package com.lambkit.distributed.node;

public class NodeConstants {
	/**
	 * lambkit 服务 在consul service中的前缀
	 */
	public static final String CONSUL_SERVICE_LAMBKIT_PRE = "lambkit_";

	/**
	 * lambkit协议在consul tag中的前缀
	 */
	public static final String CONSUL_TAG_LAMBKIT_PROTOCOL = "protocol_";

	public static final String CONSUL_TAG_LAMBKIT_URL = "URL_";

	/**
	 * lambkit 服务 在consul中存储command的目录
	 */
	public static final String CONSUL_LAMBKIT_COMMAND = "lambkit/command/";

	/**
	 * 默认consul agent的ip
	 */
	public static String DEFAULT_HOST = "localhost";

	/**
	 * 默认consul agent的端口
	 */
	public static int DEFAULT_PORT = 8500;

	/**
	 * service 最长存活周期（Time To Live），单位秒。 每个service会注册一个ttl类型的check，在最长TTL秒不发送心跳
	 * 就会将service变为不可用状态。
	 * 30秒
	 */
	public static int TTL = 30;

	/**
	 * HEARTBEAT_TTL的字符串格式
	 */
	public static String TTL_STR = TTL + "s";

	/**
	 * 心跳周期，取ttl的2/3
	 * 值=20000=20秒
	 */
	public static int HEARTBEAT_CIRCLE = (TTL * 1000 * 2) / 3;
	
	/**
	 * 连续检测开关变更的最大次数，超过这个次数就发送一次心跳
	 */
	public static int MAX_SWITCHER_CHECK_TIMES = 10;
	
	/**
	 * 检测开关变更的频率，连续检测MAX_SWITCHER_CHECK_TIMES次必须发送一次心跳。
	 */
	public static int SWITCHER_CHECK_CIRCLE = HEARTBEAT_CIRCLE / MAX_SWITCHER_CHECK_TIMES;

	/**
	 * consul服务查询默认间隔时间。单位毫秒
	 */
	public static int DEFAULT_LOOKUP_INTERVAL = 30000;

	/**
	 * consul心跳检测开关。
	 */
	@Deprecated
	public static final String CONSUL_PROCESS_HEARTBEAT_SWITCHER = "feature.consul.heartbeat";

	/**
	 * consul block 查询时 block的最长时间,单位，分钟
	 */
	public static int CONSUL_BLOCK_TIME_MINUTES = 10;
	
	/**
	 * consul block 查询时 block的最长时间,单位，秒
	 */
	public static long CONSUL_BLOCK_TIME_SECONDS = CONSUL_BLOCK_TIME_MINUTES * 60;
}
