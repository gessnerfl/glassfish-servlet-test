# glassfish-servlet-test

The project demonstrates changes with parameters from HttpServletRequest between Glassfish 3.1.2.2 (Java 7) and Glassfish 4.1.2 (Java 7 and Java 8) vs. Glassfish 5.0 (Java 8).

Before Glassfish 5.0 HttpServletRequest#getServerName(), HttpServletRequest#getServerPort() and HttpServletRequest#getRequestURL() returned the values from the request as it was sent from the client.

With Glassfish 5.0 the behaviour changed and in case of this dockerized deployments the result is the same as for getLocalName() and getLocalPort() (getRequestURL is reconstructed from server name and port so that the hostname and port also changes there accordingly).

This has significant impact e.g. on redirects as the do now behave differently.

## Usage
To test the behaviour simply start the docker containers with `docker-compose up`. As soon as all containers are up and running you can access the different services with:

* Glassfish 3.1.2.2 - Java 7: https://localhost:38181/test-servlet/test
* Glassfish 4.1.2 - Java 7: https://localhost:48181/test-servlet/test
* Glassfish 4.1.2 - Java 8: https://localhost:48281/test-servlet/test
* Glassfish 5.0 - Java 8: https://localhost:58181/test-servlet/test

The sources can be found under ./test-servlet. For the different deployments the artifact was compiled with JDK7 or JDK8 and JavaEE 6 to JavaEE 8 depending on the target platform. The changes were made manually so there is no automated build to recompile all the target artefacts.

