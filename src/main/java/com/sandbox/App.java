package com.sandbox;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n\n\n******START******\n\n\n");
        Config config = new Config();
        String token = config.getProperty("CFA_TOKEN");

        String URL = "https://www.google.com";
        OkHttpTest okHttpTest = new OkHttpTest(URL);

        System.out.println("\n\n**** OkHttpTest ****\n");
        System.out.println("Attempting to access: " + okHttpTest.getUrl());
        
        try {
            String response = okHttpTest.run(URL);        
            System.out.print("Response: " );   
            System.out.print(response);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.out.println("\n**** OkHttpTest ****\n\n");

        System.out.println("**** HttpPostTest ****\n");
        
        try {
            HttpClient post = new HttpClient("https://concert-fission-api.qa.ac-utility.redventures.io", token);

            System.out.println("Attempting to access: " + post.getUri());
            System.out.println("Response: " + post.testGet());
            System.out.println("Attempting to post: " + post.getUri());
            System.out.println("Response: " + post.testPost());
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\n**** HttpPostTest ****");
        
        System.out.println("\n\n\n******END******\n\n\n");
    }
}
