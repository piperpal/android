package com.piperpal.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HTTPHandler {

	static String response = null;
	public final static int GET = 1;
	public final static int POST = 2;

	public HTTPHandler() {

	}

	/*
	 * Making service call
	 *
	 * @url - url to make request
	 *
	 * @token - base64 encrypt o the user data
	 */
	public String makeServiceCall(String url, int method) {
		return this.makeServiceCall(url, null, method, null);
	}

	/*
	 * Making service call
	 *
	 * @url - url to make request
	 *
	 * @token - base64 encript o the user data
	 *
	 * @method - http request method
	 */
	public String makeServiceCall(String url, String token, int method) {
		return this.makeServiceCall(url, token, method, null);
	}

	/*
	 * Making service call
	 *
	 * @url - url to make request
	 *
	 * @token - base64 encript o the user data
	 *
	 * @method - http request method
	 *
	 * @json - json with the data of the data to be post
	 */
	public String makeServiceCall(String url, String token, int method,
			String json) {
		return this.makeServiceCall(url, token, method, null, json);
	}

	/*
	 * Making service call
	 *
	 * @url - url to make request
	 *
	 * @method - http request method
	 *
	 * @params - http request params
	 */
	public String makeServiceCall(String url, String token, int method,
			List<NameValuePair> params, String json) {
		try {
			// http client
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;

			// Checking http request method type
			if (method == POST) {
				HttpPost httpPost = new HttpPost(url);

				// adding post params
				if (params != null) {
					httpPost.setEntity(new UrlEncodedFormEntity(params));
				} else if (json != null) {
				    // Log.i("Eff-Json", "enviannnndo!!!");
				    //	Log.i("Eff-Json", "Normal" + new StringEntity(json));
				    //	Log.i("Eff-Json", "encoded" + EntityUtils.toString(new StringEntity(json), "UTF-8"));
					// Post the data:
					httpPost.setHeader("Content-Type", "application/json");
					httpPost.setHeader("Authorization", "Basic " + token);
					// TODO: Will this need a UTF-8 codification???
					httpPost.setEntity(new StringEntity(json));
					// Log.i("Eff-Json", "enviado!!!");
				}

				httpResponse = httpClient.execute(httpPost);

			} else if (method == GET) {

				// appending params to url
				if (params != null) {
					String paramString = URLEncodedUtils
							.format(params, "utf-8");
					url += "?" + paramString;
				}
				HttpGet httpGet = new HttpGet(url);
				httpGet.setHeader("Authorization", "Basic " + token);
				httpResponse = httpClient.execute(httpGet);

			}
			httpEntity = httpResponse.getEntity();
			response = EntityUtils.toString(httpEntity, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;

	}
}
