package com.lambkit.plugin.nim.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.StrKit;
import com.lambkit.plugin.nim.CheckSumBuilder;
import com.lambkit.plugin.nim.NimConfig;
import com.lambkit.plugin.nim.NimUser;

public class NimTest {

	public static void main(String[] args) {
		String url = "https://api.netease.im/nimserver/user/getUinfos.action";
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accids", "['lll']"));
		try {
			NimConfig config = new NimConfig();
			config.setAppKey("b950e72c78df6f44cb4378c2b7e007a7");
			config.setAppSecret("430fa8c4f12b");
			HttpResponse response = connect(config, url, nvps);
			JSONObject responseBody = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
			System.out.println(responseBody.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static HttpResponse connect(NimConfig config, String url, List<NameValuePair> nvps) throws IOException {
		if (config == null || StrKit.isBlank(url))
			return null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);

		String appKey = config.getAppKey();
		String appSecret = config.getAppSecret();
		String nonce = "12345";
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", appKey);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求的参数
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		// 执行请求
		HttpResponse response = httpClient.execute(httpPost);
		return response;
	}
}
