package com.githubdemo.pullrequest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.SkipException;

import com.githubdemo.operations.CrudOperations;
import com.githubdemo.resources.GitHubPull;





/* This class is added to handle cases specific to Pull Request flows,
 * this class can implement any related interface to handle multiple calls
 * We can have saparate classes in this package for Update and merge pull etc.
*/


public class PullReqReadOperations extends CrudOperations implements GitHubPull {

	public HttpResponse listPullRequests(String endpoint) throws ClientProtocolException, IOException {
		System.out.println("INFO: Endpoint URL formed : "+endpoint+"/pulls");
		
		HttpResponse response = get(endpoint+"/pulls");
		if (response!=null)
			return response;
		else {
			throw new SkipException("ERROR: Null Response returned");
		}
	}

	public HttpResponse getSinglePullRequest(String endpoint, int pullReqNo) throws ClientProtocolException, IOException {
		System.out.println("INFO: Endpoint URL formed : "+endpoint+"/pulls/"+Integer.toString(pullReqNo));
		
		HttpResponse response = get(endpoint+"/pulls/"+Integer.toString(pullReqNo));
		if (response!=null)
			return response;
		else {
			throw new SkipException("ERROR: Null Response returned");
		}
	}

	public HttpResponse listCommitsOnPullRequest(String endpoint, int pullReqNo) throws ClientProtocolException, IOException {
		System.out.println("INFO: Endpoint URL formed : "+endpoint+"/pulls/"+Integer.toString(pullReqNo));
		
		HttpResponse response = get(endpoint+"/pulls/"+Integer.toString(pullReqNo)+"/commits");
		if (response!=null)
			return response;
		else {
			throw new SkipException("ERROR: Null Response returned");
		}
	}

	public HttpResponse listPullRequestsFiles(String endpoint, int pullReqNo) throws ClientProtocolException, IOException {
		System.out.println("INFO: Endpoint URL formed : "+endpoint+"/pulls/"+Integer.toString(pullReqNo));
		
		HttpResponse response = get(endpoint+"/pulls/"+Integer.toString(pullReqNo)+"/files");
		if (response!=null)
			return response;
		else {
			throw new SkipException("ERROR: Null Response returned");
		}
	}

	public HttpResponse getIfPullRequestMerged(String endpoint, int pullReqNo) throws ClientProtocolException, IOException {
		System.out.println("INFO: Endpoint URL formed : "+endpoint+"/pulls/"+Integer.toString(pullReqNo));
		
		HttpResponse response = get(endpoint+"/pulls/"+Integer.toString(pullReqNo)+"/merge");
		if (response!=null)
			return response;
		else {
			throw new SkipException("ERROR: Null Response returned");
		}	
		
	}

}
