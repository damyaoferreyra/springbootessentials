package br.com.devdojo.springbootessentials.createdframework.javaclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 * 
 * @author ferreira
 * @since 08/04/2020
 * 
 */
public class JavaClientTest {

	/**
	 * 
	 * Connection endPoint java used
	 */
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		String username = "juciaria.oliveira";
		String password = "1234";
		String encode = encodeUsernamePassword(username, password);
		
		System.out.println(encode);
		try {
			URL url = new URL("http://localhost:8080/v1/default/students");
			connection =  (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("Authorization","Basic " +encode);
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSB = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				jsonSB.append(line);
			}
			System.out.println(jsonSB.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(reader);
			if(connection != null)
				connection.disconnect();
		}

	}
	
	private static String encodeUsernamePassword(String username, String password) {
		String userPassword = username+":"+password;
		return new String(Base64.encodeBase64String(userPassword.getBytes()));
		
	}

}
