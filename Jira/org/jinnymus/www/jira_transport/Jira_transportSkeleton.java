
/**
 * Jira_transportSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
    package org.jinnymus.www.jira_transport;

import javax.activation.DataHandler;

import com.atlassian.jira.rest.client.NullProgressMonitor;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.jersey.JerseyJiraRestClientFactory;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import org.apache.commons.httpclient.auth.AuthenticationException;
//import org.json.simple.JSONObject;
import com.atlassian.jira.rest.client.api.*;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;







//import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
//import com.atlassian.util.concurrent.Promise;
//import com.google.common.base.Function;
//import com.google.common.base.Joiner;
//import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

//import static com.google.common.collect.Iterables.transform;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.security.ntlm.Client;
/**
     *  Jira_transportSkeleton java skeleton for the axisService
     */
    public class Jira_transportSkeleton implements Jira_transportSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param uploadRequestToJira0
         */
        
                 public org.jinnymus.www.jira_transport.UploadResponseToJira uploadToJira
                  (
                  org.jinnymus.www.jira_transport.UploadRequestToJira uploadRequestToJira0
                  )
            {
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#uploadToJira");
                 
                 System.out.println("[UploadResponseToJira] Start");
                 String desc = uploadRequestToJira0.localDescription;
                 Integer reqid = uploadRequestToJira0.localReqId;
                 Integer jiraid = uploadRequestToJira0.localJiraId;
                 String ServerName = uploadRequestToJira0.localServerName;
                 String DomainName = uploadRequestToJira0.localDomainName;
                 String ProjectName = uploadRequestToJira0.localProjectName;
                 DataHandler file = uploadRequestToJira0.localFile;
                 String fileType = file.getContentType();
                 System.out.println("[UploadResponseToJira] ServerName = " + ServerName);
                 System.out.println("[UploadResponseToJira] DomainName = " + DomainName);
                 System.out.println("[UploadResponseToJira] ProjectName = " + ProjectName);
                 System.out.println("[UploadResponseToJira] JiraId = " + jiraid);
                 System.out.println("[UploadResponseToJira] ReqId = " + reqid);
                 System.out.println("[UploadResponseToJira] Desc = " + desc);
                 System.out.println("[UploadResponseToJira] fileType = " + fileType);
                 
                 //URI jiraServerUri;
				//try {
                /*
                 String url = "http://localhost:9080/rest/api/2/issue";
					URI server = URI.create(url);
	                 JerseyJiraRestClientFactory factory = new JerseyJiraRestClientFactory();
	                 //JerseyJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
	                 final com.atlassian.jira.rest.client.JiraRestClient restClient = factory.createWithBasicHttpAuthentication(server, "jinnymus", "avr999avr9999");
	                 com.atlassian.jira.rest.client.IssueRestClient issueClient = restClient.getIssueClient();
	                 //final NullProgressMonitor pm = new NullProgressMonitor();
	          		 //final Iterable<CimProject> metadataProjects = issueClient.getCreateIssueMetadata(
	                 //new GetCreateIssueMetadataOptionsBuilder().withProjectKeys(projectId).withExpandedIssueTypesFields().build(), pm);
	                 System.out.println("Sending issue creation requests...");
	       			final String summary = "NewIssue#0"; 
	       			final IssueInput newIssue = new IssueInputBuilder("TST", 1L, summary).build();
	      			System.out.println("\tCreating: " + summary);
	     			System.out.println("Collecting responses...");
	     			*/
	       			//issueClient.createIssue(newIssue);       
	                 					
				//} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				//}

                 
	     			Client client = Client.create();  	     			
	     			client.addFilter(new HTTPBasicAuthFilter("jinnymus", "*******"));
	     			WebResource webResource = client.resource("http://localhost:9080/rest/api/2/issue");         
	     			String input="{\"fields\":{\"project\":{\"key\":\"JIRA\"},\"summary\":\"Test Ticket\",\"description\":\"This is a test CR\", \"reporter\": {\"name\": \"prasad\"},\"issuetype\":{\"name\":\"Defect\"},\"versions\":[{\"name\":\"13.9.0\"}],\"customfield_10692\":{\"value\":\"Stability\"},\"customfield_10430\":{\"value\":\"Stability\"},\"customfield_10005\":{\"value\":\"Blocker\"},\"components\":[{\"name\":\"Modem\"}]}}";     
	                ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
	         
	                String output = response.getEntity(String.class);
	     
	                System.out.println("Output from Server .... \n");
	                System.out.println(output);
	           				

     			
                 //try {
         			//final List<Promise<BasicIssue>> promises = Lists.newArrayList();
         			

         			
         			//for (int i = 0; i < 100; i++) {

         			
         				//promises.add(issueClient.createIssue(newIssue));
         			//}


         			//final Iterable<BasicIssue> createdIssues = transform(promises, new Function<Promise<BasicIssue>, BasicIssue>() {
         			//	@Override
         				//public BasicIssue apply(Promise<BasicIssue> promise) {
         					//return promise.claim();
         				//}
         			//});

         			//System.out.println("Created issues:\n" + Joiner.on("\n").join(createdIssues));
         		//} finally {
         			//try {
						//restClient.close();
					//} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					//}
         		//}                 
                 
                 /*
                 Client js_client = Client.create();
                 com.sun.jersey.api.client.WebResource webResource = js_client.resource("http://localhost:8080/rest/api/2/issue");
                 String auth = new String(com.sun.jersey.core.util.Base64.encode("jinnymus:******"));
                 
                 JSONObject json = new JSONObject();	
                 JSONObject objProject = new JSONObject();
                 JSONObject objTemp = new JSONObject();
                 objTemp.put("key", "TES");
                 
                 objProject.put("project", objTemp.toString());
                 objProject.put("summary", "Testing Rest ");
                 objProject.put("description", "Descibing what REst can do ");	
                 objTemp =new JSONObject();
                 objTemp.put("name", "Task");	
                 objProject.put("issuetype", objTemp.toString());	
                 json.put("fields", objProject.toString());
                 String data =json.toString(); 
                 ClientResponse response = webResource.header("Authorization", "Basic " + auth).type("application/json").accept("application/json").post(ClientResponse.class, data);
	             int statusCode = response.getStatus();
	             if (statusCode == 401) {
	                 try {
						throw new AuthenticationException("Invalid Username or Password");
					} catch (AuthenticationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	             }
                 */

             
                 org.jinnymus.www.jira_transport.UploadResponseToJira UploadResponseToJira = new UploadResponseToJira();
                 UploadResponseToJira.localCode=1;
                 UploadResponseToJira.localError="error text";
                 UploadResponseToJira.localErrorTracker=true;

                 System.out.println("[UploadResponseToJira] End");                
 				 return UploadResponseToJira;                	 
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param uploadRequestToALM2
         */
                 private static void Msj(String texto){
                     System.out.println(texto);
                 }                 
                              
        
                 public org.jinnymus.www.jira_transport.UploadResponseToALM uploadToALM
                  (
                  org.jinnymus.www.jira_transport.UploadRequestToALM uploadRequestToALM2
                  )
            {
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#uploadToALM");
                	 
                 System.out.println("[UploadResponseToALM] Start");
                 String desc = uploadRequestToALM2.localDescription;
                 Integer reqid = uploadRequestToALM2.localReqId;
                 Integer jiraid = uploadRequestToALM2.localJiraId;
                 String ServerName = uploadRequestToALM2.localServerName;
                 String DomainName = uploadRequestToALM2.localDomainName;
                 String ProjectName = uploadRequestToALM2.localProjectName;
                 DataHandler file = uploadRequestToALM2.localFile;
                 String fileType = file.getContentType();
                 System.out.println("[UploadResponseToALM] ServerName = " + ServerName);
                 System.out.println("[UploadResponseToALM] DomainName = " + DomainName);
                 System.out.println("[UploadResponseToALM] ProjectName = " + ProjectName);
                 System.out.println("[UploadResponseToALM] JiraId = " + jiraid);
                 System.out.println("[UploadResponseToALM] ReqId = " + reqid);
                 System.out.println("[UploadResponseToALM] Desc = " + desc);
                 System.out.println("[UploadResponseToALM] fileType = " + fileType);
                 
                 org.jinnymus.www.jira_transport.UploadResponseToALM UploadResponseToALM = new UploadResponseToALM();
                 UploadResponseToALM.localCode=1;
                 UploadResponseToALM.localError="error text";
                 UploadResponseToALM.localErrorTracker=true;
                 System.out.println("[UploadResponseToALM] End");                
 				 return UploadResponseToALM; 
     				 
        }
     
    }
    