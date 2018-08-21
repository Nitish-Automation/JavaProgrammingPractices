package com.githubdemo.operations;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.githubdemo.getpull.PullReqFlowController;
import com.githubdemo.getpull.PullReqValidator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


// This class can be used to hold common functionality across test classes

public class BaseTest {
	
	protected PullReqFlowController pullReqFlowController = new PullReqFlowController();
	protected PullReqValidator pullReqValidate = new PullReqValidator();

	JsonParser parser = new JsonParser();

	// To get response as json object, as validations and iteration is easy to handle on objects
	public JsonObject getAsJsonObject(HttpResponse response) throws UnsupportedOperationException, IOException {
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		JsonObject responceObject = parser.parse(responseString).getAsJsonObject();
		System.out.println("INFO: Json Response: \n"+responseString);

		return responceObject;
	}
	
	// To get response as json array, as validations and iteration is easy to handle for List response
	public JsonArray getAsJsonArray(HttpResponse response) throws UnsupportedOperationException, IOException {
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("INFO: Json Response: \n"+responseString);
		JsonArray jsonArray = parser.parse(responseString).getAsJsonArray();
		
		return jsonArray;
	}

	// Print response as string
	public String getAsString(HttpResponse response) throws UnsupportedOperationException, IOException {
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println("INFO: Json Response: \n"+responseString);
		
		return responseString;
	}
	
}
