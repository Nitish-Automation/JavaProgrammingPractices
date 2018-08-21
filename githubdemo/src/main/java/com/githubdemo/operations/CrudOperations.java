package com.githubdemo.operations;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

// More crud operations can be implemented in this class GET, PUT, POST, DELETE ...!!!
// This is Common Use 

public class CrudOperations {

	HttpClient client = HttpClientBuilder.create().build();
	
	// Implemented common GET operation
	public HttpResponse get(String endpoint) throws ClientProtocolException, IOException  {
		
		try {
			HttpGet request = new HttpGet(endpoint);
			request.addHeader("Content-Type", "application/json");
			HttpResponse getResponse = client.execute(request);

			System.out.println("INFO: Hitting Endpoint for GET call");
			return getResponse;	
		}
	
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
	
}
