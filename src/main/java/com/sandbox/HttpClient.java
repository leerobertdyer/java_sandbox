package com.sandbox;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {
    private URI URI;
    private String token;
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    HttpClient(String uri, String token) {
        try {
            this.URI = new URI(uri);
            this.token = token;
        } catch (URISyntaxException e) {
            System.out.println("Error: " + e);
        }
    }

    public String getUri() {
        return URI.toString();
    }

    public void setUri(URI uri) {
        this.URI = uri;
    }
    
    public String testGet() {
        HttpGet get = new HttpGet(URI);
        get.setHeader("athorization", "Bearer " + token);
        get.setHeader("content-type", "application/json");
        
        try {
            HttpResponse httpresponse = httpclient.execute(get);
            return "Status Code: " + httpresponse.getStatusLine().getStatusCode();
        } catch (Exception e) {
            return "Error: " + e;
        }
    }   

    public String testPost() {
        HttpPost post = new HttpPost();
        post.setURI(URI);
        post.addHeader("Athorization", "Bearer " + token);
        post.addHeader("content-type", "application/json");
        try {
            HttpResponse httpresponse = httpclient.execute(post);
            return "Status Code: " + httpresponse.getStatusLine().getStatusCode() + httpresponse.toString();
        } catch (Exception e) {
         return "Error: " + e;
        }
    }



}
