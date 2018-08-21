package com.githubdemo.getpull;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.githubdemo.operations.BaseTest;
import com.githubdemo.operations.Repository;


/* 
 * For pull requests below are the use cases identified to be covered in test framework
 * - As a user I want to get all open pull req
 * - As a user I want to get information of a given pull req.
 * - As a user I want to check if a given pull req id is merged
 * - As a user I want to know information on the the commits for a given pull req 
 * - As a user I want to know information on files changed in a specific pull req
 * 
 * Cases not covered (Non idempotent in nature)
 * - Merging a pull req 
 * - Update a pull req
 * 
 * Tests are configurable:
 * 
 * 1. Add Proerty file '/githubdemo/src/main/resources/com/github/getpull' with all repos from an owner you want to run tests on
 * 2. Update '/githubdemo/src/main/java/com/github/operations/RepoConstants.java' for added property file and repos to keep all values at one place
 * 3. Make sure to have added repo's condition is updated in /githubdemo/src/main/java/com/github/utils/PropertyFileLoader.java
 * ------------ You are good to go ------------ 
*/



public class GetPullOperations extends BaseTest {
	
	@Test
	public void githubPullReqTests() throws ClientProtocolException, IOException {
		
		System.out.println("INFO: Execution Starting from Test Class");
		
		// To get all open pull requests from the given repo and validate response code.
		// Also fetch some basic details from response
		HttpResponse response = pullReqFlowController.getAllOpenPullRequests(Repository.GOOGLE_LEVELDB);
		pullReqValidate.responseCodeOk(response);
		pullReqValidate.getDetailsOfOpenPullRequests(getAsJsonArray(response));

		response = pullReqFlowController.getAllOpenPullRequests(Repository.NETFILX_POLLYJS);
		pullReqValidate.responseCodeOk(response);
		pullReqValidate.getDetailsOfOpenPullRequests(getAsJsonArray(response));
		
		// To get details of a specific pull requests using pullID and validate response code.
		// Also fetch some basic details from response
		response = pullReqFlowController.getPullReqDetails(Repository.NETFILX_SCUMBLR, 109);
		pullReqValidate.responseCodeOk(response);
		pullReqValidate.getDetailsOfPullRequest(getAsJsonObject(response));

		// To get details if a specific pull request is merged
		response = pullReqFlowController.getPullReqMergeDetails(Repository.NETFILX_SCUMBLR, 243);
		pullReqValidate.pullMergedResponse(response);

		// To get details if a specific pull request is merged
		response = pullReqFlowController.getPullReqMergeDetails(Repository.NETFILX_SCUMBLR, 109);
		pullReqValidate.pullNotMergedResponse(response);

		// To get details of a commit on a specific pull requests using pullID and validate response code.
		// Also fetch some basic details from response
		response = pullReqFlowController.getCommitInformation(Repository.NETFILX_SCUMBLR, 245);
		pullReqValidate.responseCodeOk(response);
		pullReqValidate.getDetailsOfCommitsOnPullRequest(getAsJsonArray(response));

		// To get details of a files changed on a specific pull requests using pullID and validate response code.
		// Also fetch some basic details from response
		response = pullReqFlowController.getFileInformationInCommit(Repository.NETFILX_SCUMBLR, 245);
		pullReqValidate.responseCodeOk(response);
		pullReqValidate.getDetailsOfFilesInCommitsOnPullRequest(getAsJsonArray(response));
				
		
	}

}
