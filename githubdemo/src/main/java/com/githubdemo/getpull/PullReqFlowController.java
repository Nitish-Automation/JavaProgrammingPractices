package com.githubdemo.getpull;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.SkipException;

import com.githubdemo.pullrequest.PullReqReadOperations;
import com.githubdemo.utils.PropertyFileLoader;


/* 
 * This class is to hold the responsibility of calling to different endpoints for a specific test 
 * It also takes care of any special logic or if multiple endpoints needs to be called for any given use case 
 * 
 */
public class PullReqFlowController {

	PullReqReadOperations pullReqReadOps = new PullReqReadOperations();
	PropertyFileLoader fileLoader = new PropertyFileLoader();	
	
	
	public HttpResponse getAllOpenPullRequests(String repositoty) throws ClientProtocolException, IOException { 
		
		System.out.println("INFO: Test Flow Controller");
		if (repositoty!=null) {
			// Get correct repo name from loaded propeties
			Properties prop = fileLoader.getPoperties(repositoty, this.getClass());
			String targetRepository = prop.getProperty(repositoty.split("/")[1]);
			
			return pullReqReadOps.listPullRequests(targetRepository);
		}
		
		else {
			throw new SkipException("ERROR: Cannot Execute, Please specify GitRepo");
		}
		
	}

	public HttpResponse getPullReqDetails(String repositoty, int pullReqNo) throws IOException { 
		
		System.out.println("INFO: Test Flow Controller");
		if (repositoty!=null) {
			// Get correct repo name from loaded propeties
			Properties prop = fileLoader.getPoperties(repositoty, this.getClass());
			String targetRepository = prop.getProperty(repositoty.split("/")[1]);
			
			return pullReqReadOps.getSinglePullRequest(targetRepository, pullReqNo);
		}
		
		else {
			throw new SkipException("ERROR: Cannot Execute, Please specify GitRepo");
		}		
		
	}

	public HttpResponse getPullReqMergeDetails(String repositoty, int pullReqNo) throws IOException {
		
		System.out.println("INFO: Test Flow Controller");
		if (repositoty!=null) {
			// Get correct repo name from loaded propeties
			Properties prop = fileLoader.getPoperties(repositoty, this.getClass());
			String targetRepository = prop.getProperty(repositoty.split("/")[1]);
			
			return pullReqReadOps.getIfPullRequestMerged(targetRepository, pullReqNo);
		}
		
		else {
			throw new SkipException("ERROR: Cannot Execute, Please specify GitRepo");
		}	
	}

	public HttpResponse getCommitInformation(String repositoty, int pullReqNo) throws IOException {
		System.out.println("INFO: Test Flow Controller");
		if (repositoty!=null) {
			// Get correct repo name from loaded propeties
			Properties prop = fileLoader.getPoperties(repositoty, this.getClass());
			String targetRepository = prop.getProperty(repositoty.split("/")[1]);
			
			return pullReqReadOps.listCommitsOnPullRequest(targetRepository, pullReqNo);
		}
		
		else {
			throw new SkipException("ERROR: Cannot Execute, Please specify GitRepo");
		}	
	}

	public HttpResponse getFileInformationInCommit(String repositoty, int pullReqNo) throws IOException {
		System.out.println("INFO: Test Flow Controller");
		if (repositoty!=null) {
			// Get correct repo name from loaded propeties
			Properties prop = fileLoader.getPoperties(repositoty, this.getClass());
			String targetRepository = prop.getProperty(repositoty.split("/")[1]);
			
			return pullReqReadOps.listPullRequestsFiles(targetRepository, pullReqNo);
		}
		
		else {
			throw new SkipException("ERROR: Cannot Execute, Please specify GitRepo");
		}
	}


}
