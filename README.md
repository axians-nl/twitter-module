# twitter-module
Mendix Twitter module.

## Description
Module with a Twitter connector. Currently the module only implements the Standard Search API to search for tweets which can than be viewed in your Mendix app. It also automatically formats the mentions, hashtags and hyperlinks in the message.

## Typical usage scenario
Search and show tweets in your Mendix application.

## Features and limitations
* Returns unformatted plain text and a formatted version of the text.
* In formatted text mentions are converted to a html anchor to the mentioned user's Twitter profile with css class twitter-mention.
* In formatted text hyperlinks are converted to a html anchor with css class twitter-url.
* In formatted text hyperlinks are converted to a span with css class twitter-hashtag. 

## Dependencies
* Mendix modeler version 7.18.1+
* RichText widget to show the formatted text.
* You need a Twitter developer account. Create an App and generate consumer key and access token for this app. See [here](https://developer.twitter.com/en/account/get-started)
* No other dependencies. Uses Twitter4J which is packaged with the module.

## Installation
Just add it to your project from the App Store.

## Configuration
You need a Twitter developer account. Create an Twitter App and generate consumer key and access token for this app. You need this key and token in the configuration of the action. See [here](https://developer.twitter.com/en/account/get-started).

Drag and drop the Search Tweets action from the toolbox on your microflow and configure its settings.

| Setting             | Description    
|---------------------|------------------
| Consumer key	      | Can be retrieved from your Twitter developer account.
| Consumer key secret |	Can be retrieved from your Twitter developer account.
| Access token	      | Can be retrieved from your Twitter developer account.
| Access token secret	| Can be retrieved from your Twitter developer account.
| Result type	        |
| Count	              | The number of tweets to retrieve (1-100).
| Until	              | Date in yyyy-MM-dd format. Only tweets before this date will be retrieved.
| Since id	          | Only tweets with an id after this id will be retrieved.
| Max id	            | Only tweets with an id befire this id will be retrieved.
| Query	              | The query to apply. See https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets.html

## Known bugs
None.

## Frequently Asked Questions
Q: Are yo going to support more of the Twitter API?

A: Yes, in the future we will. Currently we only need the Standard Search API.

