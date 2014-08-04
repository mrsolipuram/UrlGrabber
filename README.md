UrlGrabber
==========
UrlGrabber in java using JSoup

How to run this example:

Run this maven project in tomcat.
Open UrlGrabber application using Web Browser.
Paste any web URL in input box.
On Paste it submits the ajax call to server.
In Controller it receives the request and makes the request for user given url using JSOUP.
Controller fetches the html elements from targeted URL.(like image, title, keywords,description, url etc,.) 
And it sends the json response to ajax call.
