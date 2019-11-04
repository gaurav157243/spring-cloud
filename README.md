# spring-cloud
Create spring cloud eureka server, eureka client and communicate with two different services

First, we will start the eureka server, then start two instances of app1 on two different port, then start app2 which will make 10 api calls to app1, out of which half will go to instance 1 and other half to instance2.

The sequence of starting the services are as follows:

(NOTE: if you are using eclipse, then you can use Run As option and pass the port using the -D vm argument)

- first start the eureka server, in a seperate terminal

cd eureka-server/

mvn spring-boot:run


# we will run two instances of app1 microservice on two different ports - 9091 and 9092
- open a seperate terminal and execute the following commands:

cd eureka-client-app1
# run the application on port 9091
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9001

- open a seperate terminal and execute the following commands:

cd eureka-client-app1
# run the application on port 9091
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9002

# Now, start micro server2 which will make calls to the first micro service which we have started

- open a seperate terminal and execute the following commands:

cd eureka-client-app2
mvn spring-boot:run


once you start the application, you will start the following output which will show that the request is going to two different instances of app1

Output
.....
2019-11-03 20:18:39.988  INFO 66400 --- [  restartedMain] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client MicroService1 initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=MicroService1,current list of Servers=[10.0.0.118:9002, 10.0.0.118:9001],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzoneInstance count:2;	Active connections count: 0;	Circuit breaker tripped count: 0;	Active connections per server: 0.0;]
},Server stats: [[Server:10.0.0.118:9002;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Wed Dec 31 16:00:00 PST 1969;	First connection made: Wed Dec 31 16:00:00 PST 1969;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
, [Server:10.0.0.118:9001;	Zone:defaultZone;	Total Requests:0;	Successive connection failure:0;	Total blackout seconds:0;	Last connection made:Wed Dec 31 16:00:00 PST 1969;	First connection made: Wed Dec 31 16:00:00 PST 1969;	Active Connections:0;	total failure count in last (1000) msecs:0;	average resp time:0.0;	90 percentile resp time:0.0;	95 percentile resp time:0.0;	min resp time:0.0;	max resp time:0.0;	stddev resp time:0.0]
]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@1d24b71d
{status=success, host=Gauravs-MacBook-Pro.local, port=9002, appName=MicroService1}
2019-11-03 20:18:40.979  INFO 66400 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: MicroService1.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
iteration 2
{status=success, host=MacBook-Pro.local, port=9001, appName=MicroService1}
iteration 3
{status=success, host=MacBook-Pro.local, port=9002, appName=MicroService1}
iteration 4
{status=success, host=MacBook-Pro.local, port=9001, appName=MicroService1}
iteration 5
{status=success, host=MacBook-Pro.local, port=9002, appName=MicroService1}
iteration 6
{status=success, host=MacBook-Pro.local, port=9001, appName=MicroService1}
iteration 7
{status=success, host=MacBook-Pro.local, port=9002, appName=MicroService1}
iteration 8
{status=success, host=MacBook-Pro.local, port=9001, appName=MicroService1}
iteration 9
{status=success, host=MacBook-Pro.local, port=9002, appName=MicroService1}

