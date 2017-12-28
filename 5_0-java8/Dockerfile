FROM gessnerfl/java:oracle-jdk-8
MAINTAINER Florian Gessner

WORKDIR /opt
RUN wget http://download.oracle.com/glassfish/5.0/release/glassfish-5.0.zip \
    && unzip glassfish-5.0.zip
ENV GF_HOME=/opt/glassfish5/glassfish
ENV PATH=$PATH:$GF_HOME/bin

COPY customizing/test-servlet-j8-jee8.war /opt/test-servlet.war
COPY customizing/deploy.sh /opt
RUN chmod a+r /opt/deploy.sh

COPY customizing/jce_policy-8.zip /opt/jce_policy-8.zip
RUN unzip -jo -d ${JAVA_HOME}/jre/lib/security /opt/jce_policy-8.zip && rm -f /opt/jce_policy-8.zip
RUN apt-get update && apt-get upgrade -y

COPY customizing/gf_admin /gf_admin
RUN cd /opt/glassfish5/glassfish/bin; ./asadmin --user admin --passwordfile /gf_admin/pw1.txt change-admin-password --domain_name domain1
RUN cd /opt/glassfish5/glassfish/bin; ./asadmin start-domain domain1; ./asadmin --user admin --passwordfile /gf_admin/pw2.txt < /gf_admin/customizing.txt; ./asadmin stop-domain domain1
RUN rm -rf /gf_admin

EXPOSE 4848
EXPOSE 8080
EXPOSE 8181
EXPOSE 8443

ENTRYPOINT ["sh", "/opt/deploy.sh"]
