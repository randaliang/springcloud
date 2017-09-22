/**
 * <p>PURPOSE:
 * <p>DESCRIPTION: 
 * <p>DESCRIPTION:
 * <p>CALLED BY:	
 * <p>CREATE DATE: 2017-5-17
 * <p>UPDATE DATE: 
 * <p>UPDATE USER: 
 * <p>HISTORY:		1.0
 * @version 1.0
 * @author 冉大亮
 * @since java 1.6.0
 * @see 
 */
package com.ctjsoft.nontax.restfultest;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.*;

/**
 * Created by hackcoder on 15-4-20.
 */
public class NetUtil {
    public static String GET(String url){
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                return "Method failed: " + method.getStatusLine();
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            return new String(responseBody);

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
        return null;
    }
    public static String POST(String url,Map<String,Object> dataForm){
        HttpClient httpClient = new HttpClient();
        PostMethod post = new PostMethod(url);
        List<NameValuePair> data = new ArrayList<NameValuePair>();
        if(dataForm!=null){
            Set<String> keys = dataForm.keySet();
            for(String key:keys){
                NameValuePair nameValuePair = new NameValuePair(key, (String) dataForm.get(key));
                data.add(nameValuePair);
            }
        }
        post.setRequestBody(data.toArray(new NameValuePair[0]));
        try {
            int statusCode = httpClient.executeMethod(post);
            if (statusCode != HttpStatus.SC_OK) {
                return "Method failed: " + post.getStatusLine();
            }

            // Read the response body.
            byte[] responseBody = post.getResponseBody();
            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            return new String(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            post.releaseConnection();
        }
        return null;
    }

    public static String DELETE(String url,Map<String,Object> dataForm){
        HttpClient httpClient = new HttpClient();
        DeleteMethod deleteMethod = new DeleteMethod(url);

        List<NameValuePair> data = new ArrayList<NameValuePair>();
        if(dataForm!=null){
            Set<String> keys = dataForm.keySet();
            for(String key:keys){
                NameValuePair nameValuePair = new NameValuePair(key, (String) dataForm.get(key));
                data.add(nameValuePair);
            }
        }
        deleteMethod.setQueryString(data.toArray(new NameValuePair[0]));
        try {
            int statusCode = httpClient.executeMethod(deleteMethod);
            if (statusCode != HttpStatus.SC_OK) {
                return "Method failed: " + deleteMethod.getStatusLine();
            }

            // Read the response body.
            byte[] responseBody = deleteMethod.getResponseBody();
            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            return new String(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            deleteMethod.releaseConnection();
        }
        return null;
    }
    
//    public void a(){
//    	 // 创建默认的httpClient实例.
//    	  HttpClient httpclient = new HttpClient();
//    	  // 创建httppost
//    	  PostMethod httppost = new PostMethod(
//    	    "http://li72-pc:8080/test/login.action");
//    	  // 创建参数队列
//    	  List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
//    	  formparams.add(new BasicNameValuePair("userName","admin"));
//    	  formparams.add(new BasicNameValuePair("password", "admin"));
//    	  UrlEncodedFormEntity uefEntity;
//    	  try {
//    	   uefEntity = new UrlEncodedFormEntity( formparams, "UTF-8" );
//    	   httppost.setEntity(uefEntity);
//    	   System.out.println("executing request " + httppost.getURI());
//    	   HttpResponse response;
//    	   httpclient.executeMethod(method);
//    	   HttpEntity entity = response.getEntity();
//    	   if (entity != null) {
//    	    System.out.println("--------------------------------------");
//    	    System.out.println("Response content: "
//    	      + EntityUtils.toString(entity, "UTF-8"));
//    	    System.out.println("--------------------------------------");
//    	    
//    	   }
//    	  } catch (ClientProtocolException e) {
//    	   e.printStackTrace();
//    	  } catch (UnsupportedEncodingException e1) {
//    	   e1.printStackTrace();
//    	  } catch (IOException e) {
//    	   e.printStackTrace();
//    	  } finally {
//    	   // 关闭连接,释放资源
//    	   httpclient.getConnectionManager().shutdown();
//    	  }
//    	 }
//    }
    
    public static void main( String args[] ){
//    	String s = GET("http://127.0.0.1:7001/nontax/dicitem/96");
//    	System.out.println( s );
    	String url = "http://127.0.0.1:7001/nontax/billtype/100";
		String  s = DELETE(url,new HashMap<String,Object>());
		System.out.println(s);
    }
     

}