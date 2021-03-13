package com.twitter.edu;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterController implements Constants {
	private Twitter twitter;

	public Twitter Conecxion() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMERKEY)
		.setOAuthConsumerSecret(CONSUMERSECRET)
		.setOAuthAccessToken(ACCESSTOKEN)
		.setOAuthAccessTokenSecret(ACCESSSECRET);

		TwitterFactory twitterFactory = new TwitterFactory(cb.build());
		twitter = twitterFactory.getInstance();

		return twitter;
	}

	public QueryResult query(String query) throws TwitterException {
		QueryResult search = twitter.search(new Query(query));
		
		return search;
	}
	
	

}
