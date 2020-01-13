package com.fetnet.portal.aem.ebu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;



/**
 * @author Anirudh Sharma
 * 
 * This class has all the Network related calls
 */
public final class Network {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String LOGIN_NAME = "admin";
	private static final String PASSWORD = "admin";
	
	public static String readJson(String url) {
		
		try {
			/**
			 * Get the URL object from the passed url string
			 */
			URL requestURL = new URL(url);
			
			/**
			 * Creating an object of HttpURLConnection
			 */
			HttpsURLConnection connection = (HttpsURLConnection) requestURL.openConnection();
			
			/**
			 * Setting the request method
			 */
			connection.setRequestMethod("GET");
			
			/**
			 * Setting the request property
			 */
			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			/**
			 * Get the response code
			 */
			int responseCode = connection.getResponseCode();
			
			if(responseCode == HttpsURLConnection.HTTP_OK) {
				
				/**
				 * Getting an instance of BufferedReader to read the response returned
				 */
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				/**
				 * String which will read the response line by line
				 */
				String inputLine;
				
				/**
				 * StringBuffer object to append the string as a whole
				 */
				StringBuffer response = new StringBuffer();

				/**
				 * Read until empty line is encountered
				 */
				while ((inputLine = in.readLine()) != null) {
					
					/**
					 * Append each line to make the response as a whole
					 */
					response.append(inputLine);
				}
				
				/**
				 * Closing the BufferedReader to avoid memory leaks
				 */
				in.close();

				/**
				 * Return the response
				 */
				return response.toString();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
public static String readJsonByhttp(String url) {
		
		try {
			/**
			 * Get the URL object from the passed url string
			 */
			URL requestURL = new URL(url);
			
			/**
			 * Creating an object of HttpURLConnection
			 */
			HttpURLConnection connection = (HttpURLConnection) requestURL.openConnection();
			
			/**
			 * Setting the request method
			 */
			connection.setRequestMethod("GET");
			
			/**
			 * Setting the request property
			 */
			connection.setRequestProperty("User-Agent", USER_AGENT);
			
			
			/**
			 * Setting Login info
			 */			
			
		      String userpassword = LOGIN_NAME + ":" + PASSWORD;
			  byte[] authEncBytes = Base64.encodeBase64(userpassword.getBytes());
			  String authStringEnc = new String(authEncBytes);
		      connection.setRequestProperty("Authorization", "Basic "+
			  authStringEnc);			
			/**
			 * Get the response code
			 */
			int responseCode = connection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				/**
				 * Getting an instance of BufferedReader to read the response returned
				 */
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				/**
				 * String which will read the response line by line
				 */
				String inputLine;
				
				/**
				 * StringBuffer object to append the string as a whole
				 */
				StringBuffer response = new StringBuffer();

				/**
				 * Read until empty line is encountered
				 */
				while ((inputLine = in.readLine()) != null) {
					
					/**
					 * Append each line to make the response as a whole
					 */
					response.append(inputLine);
				}
				
				/**
				 * Closing the BufferedReader to avoid memory leaks
				 */
				in.close();

				/**
				 * Return the response
				 */
				return response.toString();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}