package com.githubdemo.getpull;

import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.testng.Assert;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PullReqValidator {

	public void responseCodeOk(HttpResponse response) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "ERROR: GET response Failed.");
	}

	public void pullMergedResponse(HttpResponse response) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 204, "ERROR: GET response Failed.");
	}
	
	public void pullNotMergedResponse(HttpResponse response) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404, "ERROR: GET response Failed.");
	}
	
	public void getDetailsOfOpenPullRequests(JsonArray jsonArray) {
		
		System.out.println("INFO: Toatl Open Pull Requests: "+jsonArray.size());
		Iterator<JsonElement> iter = jsonArray.iterator();
		while (iter.hasNext()) {
			JsonObject jobj = iter.next().getAsJsonObject();
			System.out.println("URL: "+jobj.get("url").getAsString());
			System.out.println("TITLE: "+jobj.get("title").getAsString());
			System.out.println("ID PULL: "+jobj.get("id").getAsString());
			System.out.println("CREATED AT: "+jobj.get("created_at").getAsString());
			System.out.println("USER ID: "+jobj.get("user").getAsJsonObject().get("login").getAsString());
			System.out.println("LABEL: "+jobj.get("base").getAsJsonObject().get("label").getAsString());
			System.out.println("--------------------------------------------------------");
		}
	}

	public void getDetailsOfPullRequest(JsonObject jobj) {
		
		System.out.println("URL: "+jobj.get("url").getAsString());
		System.out.println("TITLE: "+jobj.get("title").getAsString());
		System.out.println("ID PULL: "+jobj.get("id").getAsString());
		System.out.println("CREATED AT: "+jobj.get("created_at").getAsString());
		System.out.println("USER ID: "+jobj.get("user").getAsJsonObject().get("login").getAsString());
		System.out.println("CREATED AT: "+jobj.get("created_at").getAsString());
		System.out.println("LABEL: "+jobj.get("base").getAsJsonObject().get("label").getAsString());
		System.out.println("CREATED AT: "+jobj.get("created_at").getAsString());
		System.out.println("--------------------------------------------------------");

		
	}

	public void getDetailsOfCommitsOnPullRequest(JsonArray jsonArray) {
		
		System.out.println("INFO: Toatl Commits Pull Requests: "+jsonArray.size());
		Iterator<JsonElement> iter = jsonArray.iterator();
		while (iter.hasNext()) {
			JsonObject jobj = iter.next().getAsJsonObject();
			System.out.println("COMMITER NAME: "+jobj.get("commit").getAsJsonObject().get("committer").getAsJsonObject().get("name").getAsString());
			System.out.println("COMMITER EMAIL: "+jobj.get("commit").getAsJsonObject().get("committer").getAsJsonObject().get("email").getAsString());
			System.out.println("COMMITER DATE: "+jobj.get("commit").getAsJsonObject().get("committer").getAsJsonObject().get("date").getAsString());
			System.out.println("COMMITER DATE: "+jobj.get("commit").getAsJsonObject().get("message").getAsString());

			System.out.println("--------------------------------------------------------");
		}
		
		
	}

	public void getDetailsOfFilesInCommitsOnPullRequest(JsonArray jsonArray) {
		System.out.println("INFO: Toatl Files Changes In Pull Requests: "+jsonArray.size());
		Iterator<JsonElement> iter = jsonArray.iterator();
		while (iter.hasNext()) {
			JsonObject jobj = iter.next().getAsJsonObject();
			System.out.println("FILE NAME: "+jobj.get("filename").getAsString());
			System.out.println("STATUS: "+jobj.get("status").getAsString());
			System.out.println("ADDITIONS: "+jobj.get("additions").getAsString());
			System.out.println("DELETIONS: "+jobj.get("deletions").getAsString());
			System.out.println("CHANGES: "+jobj.get("changes").getAsString());
			
			System.out.println("--------------------------------------------------------");
		}		
	}

}
