package com.other.updown.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;
import com.other.updown.constant.Constants;
import com.other.updown.constant.ResponseStatusType;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ChenCaihua
 * @version 2017-06-20
 * @since jdk1.8
 */
public class HttpClientUtil {

    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    // 单位毫秒
    // setConnectTimeout：设置连接超时时间，。
    // setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间。这个属性是新加的属性，因为目前版本是可以共享连接池的。
    // setSocketTimeout：请求获取数据的超时时间。如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。

    // 连接超时时间,毫秒
    private static final int CONNECT_TIMEOUT = 60000;
    // 从http连接池获取Connection 超时时间，毫秒
    private static final int CONNECT_REQUEST_TIMEOUT = 60000;
    // 请求获取数据的超时时间，需要修改通常该这里，
    public static final int SOCKET_TIMEOUT = 30000;

    private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
        .setConnectionRequestTimeout(CONNECT_REQUEST_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();

    /**
     * 基于fastJson发送http请求
     * 
     * @param apiUrl 请求url
     * @param reqMap 请求的map
     * @return 请求结果
     * @throws Exception 异常
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> sendHttpPostWithMap(final String apiUrl, final Map<String, Object> reqMap)
        throws Exception {

        String entityStr = post(apiUrl, JSON.toJSONString(reqMap), new HashMap<String, String>() {
            {
                put(HTTP.CONTENT_TYPE, HttpClientUtil.DEFAULT_CONTENT_TYPE);
            }
        });

        return JSON.parseObject(entityStr, Map.class);

    }

    public static Map<String, Object> sendHttpPostWithMap(final String apiUrl, final Map<String, Object> reqMap,
        final Map<String, String> headers) throws Exception {

        String entityStr = post(apiUrl, JSON.toJSONString(reqMap), headers);

        return JSON.parseObject(entityStr, Map.class);

    }

    /**
     * 基于fastJson发送http请求
     * 
     * @param apiUrl 请求url
     * @param reqJson 请求json参数
     * @return 请求结果
     * @throws Exception 异常
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> sendHttpPostWithJsonStr(final String apiUrl, final JSONObject reqJson)
        throws Exception {
        String entityStr = post(apiUrl, reqJson.toJSONString(), null);
        return JSON.parseObject(entityStr, Map.class);

    }

    /**
     * 基于fastJson发送http请求
     * 
     * @param apiUrl 请求url
     * @param jsonString 请求参数json字符串
     * @return 请求结果
     * @throws Exception 异常
     */
    public static String sendHttpPostWithJsonStr(final String apiUrl, final String jsonString, final String contentType)
        throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put(HTTP.CONTENT_TYPE, contentType);
        return post(apiUrl, jsonString, header);

    }

    /**
     * 获取本地IP
     * 
     * @return
     * @throws UnknownHostException
     */
    public static String getLocalIpAddress() throws UnknownHostException {
        String localHost = "localHost";
        localHost = InetAddress.getLocalHost().getHostAddress();

        return localHost;
    }

    /**
     * 
     * @param url 请求url
     * @param jsonString 请求json字符串参数
     * @param headers 请求header
     * @return
     * @throws Exception
     */
    public static String post(final String url, final String jsonString, final Map<String, String> headers)
        throws Exception {
        HttpPost post = new HttpPost(url);

        if (StringUtil.isNotEmpty(jsonString)) {
            post.setEntity(new StringEntity(jsonString, Constants.ENCODING_UTF_8));
        }

        post.setConfig(REQUEST_CONFIG);
        if (null != headers) {
            for (String header : headers.keySet()) {
                post.setHeader(header, headers.get(header));
            }
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            EntityUtils.consume(entity);
            return content;

        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.close(response);
            IOUtils.close(httpClient);
        }

    }

    /**
     * viid视图库请求
     * 
     * @param method 请求方法
     * @param urlPath
     * @param json
     * @param header
     * @return
     */
    public static Map<String, String> viidURLConnRequest(HttpMethod method, String urlPath, String json,
        Map<String, String> header) {

        Map<String, String> result = new HashMap<String, String>();
        HttpURLConnection httpUrlconnection = null;
        try {
            // 初始化HttpURLConnection
            httpUrlconnection = initHttpURLConnection(urlPath, header, method);

            if (json.length() > 0) {
                httpUrlconnection.getOutputStream().write(json.getBytes(Constants.ENCODING_UTF_8));
            }

            httpUrlconnection.getOutputStream().flush();
            httpUrlconnection.getOutputStream().close();

            result = dealResponse(urlPath, httpUrlconnection);
        } catch (Exception e) {
            result.put("message", "访问url[" + urlPath + "],方法[" + method + "]发生异常");
        } finally {
            if (httpUrlconnection != null) {
                httpUrlconnection.disconnect();
            }
        }
        return result;
    }

    /**
     * 初始化HttpURLConnection
     * 
     * @param urlPath
     * @param header
     * @param method
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    private static HttpURLConnection initHttpURLConnection(String urlPath, Map<String, String> header, HttpMethod method)
        throws MalformedURLException, IOException {
        HttpURLConnection httpUrlconnection;
        URL url = new URL(urlPath);
        httpUrlconnection = (HttpURLConnection)url.openConnection();
        httpUrlconnection.setDoInput(true);
        httpUrlconnection.setDoOutput(true);
        httpUrlconnection.setConnectTimeout(CONNECT_TIMEOUT);// 设置连接主机超时（单位：毫秒）
        httpUrlconnection.setReadTimeout(SOCKET_TIMEOUT);// 设置从主机读取数据超时（单位：毫秒）

        if (header != null) {
            for (Entry<String, String> entry : header.entrySet()) {
                httpUrlconnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        httpUrlconnection.setRequestMethod(method.name());
        return httpUrlconnection;
    }

    private static Map<String, String> dealResponse(String urlPath, HttpURLConnection httpUrlconnection)
        throws IOException {
        int responseCode = httpUrlconnection.getResponseCode();
        Map<String, String> result = new HashMap<String, String>();

        result.put("code", String.valueOf(responseCode));
        if (ResponseStatusType.UNAUTHORIZED_401.getStatusCode() == responseCode) {// 鉴权不通过，需要注册
            result.put("message", httpUrlconnection.getHeaderField(Constants.HTTP_HEADER_WWW_AUTHENTICATE));
        } else if (result.get("code").startsWith(Constants.SUCCESS_RESPONSE_CODE_PREFIX)) {
            DataInputStream in = null;
            try {
                in = new DataInputStream(httpUrlconnection.getInputStream());
                int len = in.available();
                byte[] by = new byte[len];
                in.readFully(by);
                result.put("message", new String(by, Charset.forName(Constants.ENCODING_UTF_8)));
            } catch (IOException e) {
                throw e;
            } finally {
                if (null != in) {
                    in.close();
                }
            }
        } else {
            result.put("message", "请求地址：" + urlPath + "异常， 状态码:" + responseCode + "");
        }
        return result;
    }
}