package com.sandbox;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {
    private String URL;
    private OkHttpClient client = new OkHttpClient();

    public OkHttpTest(String URL) {
        this.URL = URL;
    }

    public String getUrl() {
        return URL;
    }

    public void setUrl(String URL) {
        this.URL = URL;
    }



String run(String url) throws IOException {
    System.out.println("Running OkHttpTest.run()");
  Request request = new Request.Builder()
      .url(url)
      .build();

  try (Response response = client.newCall(request).execute()) {
    if (response.isSuccessful()) {
        return "Status Code: " + response.code() + "\n";
    }
    return "Error: " + response.code() + "\n";
    }
    catch(Exception e) {
        return "Error: " + e + "\n";
    }
}




}