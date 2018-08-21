package com.githubdemo.resources;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

/*
 * Interface to have actual operations offered in the API
 */

public interface GitHubPull {
	
	//Refer documentation for method details as method names are same as operations offered-
	//https://developer.github.com/v3/pulls/#get-if-a-pull-request-has-been-merged
	
	public HttpResponse listPullRequests(String endpoint) throws ClientProtocolException, IOException;
	public HttpResponse getSinglePullRequest (String endpoint, int pullReqNo) throws ClientProtocolException, IOException;
	public HttpResponse listCommitsOnPullRequest (String endpoint, int pullReqNo) throws ClientProtocolException, IOException;
	public HttpResponse listPullRequestsFiles(String endpoint, int pullReqNo) throws ClientProtocolException, IOException;
	public HttpResponse getIfPullRequestMerged (String endpoint, int pullReqNo) throws ClientProtocolException, IOException;
	

}
