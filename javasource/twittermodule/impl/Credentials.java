package twittermodule.impl;

public class Credentials {

	private java.lang.String consumerKey;
	private java.lang.String consumerKeySecret;
	private java.lang.String accessToken;
	private java.lang.String accessTokeSecret;
	
	public Credentials(String consumerKey, String consumerKeySecret, String accessToken, String accessTokeSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerKeySecret = consumerKeySecret;
		this.accessToken = accessToken;
		this.accessTokeSecret = accessTokeSecret;
	}

	public java.lang.String getConsumerKey() {
		return consumerKey;
	}

	public java.lang.String getConsumerKeySecret() {
		return consumerKeySecret;
	}

	public java.lang.String getAccessToken() {
		return accessToken;
	}

	public java.lang.String getAccessTokeSecret() {
		return accessTokeSecret;
	}
	
}
