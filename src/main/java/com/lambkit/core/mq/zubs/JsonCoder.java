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
package com.lambkit.core.mq.zubs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import io.zbus.mq.Message;

public class JsonCoder implements Coder {
	public JsonCoder() {
	}

	public Message encode(Object obj) {
		Message msg = new Message();
		msg.setBody(JSON.toJSONString(obj, SerializerFeature.WriteClassName, SerializerFeature.IgnoreNonFieldGetter));
		return msg;
	}
	
	public <T> T decode(Class<T> tClass, Message msg) throws Exception {
		String textMsg = msg.getBodyString();
		return JSON.parseObject(textMsg, tClass);
	}
}
