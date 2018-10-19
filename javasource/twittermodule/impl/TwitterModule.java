package twittermodule.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mendix.logging.ILogNode;

import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterModule {

	private ILogNode logger;
	
	/**
	 * Get the {@link Twitter} client for the provided credentials.
	 * 
	 * @param credentials The credentials used to access the Twitter API.
	 * 
	 * @return The [@Twitter} client for the specified credentials.
	 */
	private Twitter getTwitterClient(Credentials credentials) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		
		builder.setDebugEnabled(true)
			.setOAuthConsumerKey(credentials.getConsumerKey())
			.setOAuthConsumerSecret(credentials.getConsumerKeySecret())
			.setOAuthAccessToken(credentials.getAccessToken())
			.setOAuthAccessTokenSecret(credentials.getAccessTokeSecret())
			.setTweetModeExtended(true);
		
		TwitterFactory factory = new TwitterFactory(builder.build());
		
		return factory.getInstance();
	}
	
	public QueryResult searchTweets(Credentials credentials, Long count, Date until, 
			Long sinceId, Long maxId, twittermodule.proxies.ResultType resultType, 
			String query) throws TwitterException {
		info("searchTweets");
		
		Twitter twitter = getTwitterClient(credentials);
		Query request = new Query()
				.query(query)
				.count(count == null ? 100 : Math.toIntExact(count));
		
		// Set sinceId parameter if specified.
		if (sinceId != null) {
			request.sinceId(sinceId);
		}
		
		// Set maxId parameter if specified.
		if (maxId != null) {
			request.maxId(maxId);
		}
		
		// Set until parameter if specified.
		if (until != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			request.until(sdf.format(until));
		}
		
		// Set result type if specified.
		if (resultType != null) {
			request.resultType(ResultType.valueOf(resultType.name()));
		}
		
		return twitter.search(request);
	}

	public void setLogger(ILogNode logger) {
		this.logger = logger;
	}
	
	private void info(String message, Object... args) {
		if (logger != null) {
			logger.info(String.format(message, args));
		} else {
			System.out.println(String.format(message, args));
		}
	}
	
}
