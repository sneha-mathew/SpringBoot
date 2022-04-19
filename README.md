# Tracking number of unique request in one min

A spring boot application that allows us to track the number of request arriving at the server per min.

## Run the application

Use any Java IDE tools and import the application. Run the Zookeeper and the Kafka on your local machine and then run the DeduplicationApplication.java

## Overview Architecture

! [Overview Architecture](Overview_Architect.png)

This application is implemented on Spring Boot. There is a REST controller which checks if the api call is correct and the mandatory id query parameter is present. If any of the conditions are not followed then then the ErrorHandleContoller is called and a message "failed" is returned. Where as when the request satisfies all the condition then a call is triggered to UniqueTracker, which has a set that would keep track of the unique request.

There is a job that runs every min which is scheduled using Spring Scheduler and it logs the number of unique request and clears the cache.

##Future Work

A kafka queue can be introduced between the Controller and tracker so that the tracker can handle the  request on a multi-server environment