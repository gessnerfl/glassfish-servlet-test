FROM gessnerfl/java:oracle-jdk-7
MAINTAINER Florian Gessner

WORKDIR /opt
RUN wget http://download.java.net/glassfish/4.1.2/release/glassfish-4.1.2.zip \
    && unzip glassfish-4.1.2.zip
ENV GF_HOME=/opt/glassfish4/glassfish
ENV PATH=$PATH:$GF_HOME/bin

COPY customizing/test-servlet-j7-jee7.war /opt/test-servlet.war
COPY customizing/deploy.sh /opt
RUN chmod a+r /opt/deploy.sh

COPY customizing/gf_admin /gf_admin
RUN cd /opt/glassfish4/glassfish/bin; ./asadmin --user admin --passwordfile /gf_admin/pw1.txt change-admin-password --domain_name domain1
RUN cd /opt/glassfish4/glassfish/bin; ./asadmin start-domain domain1; ./asadmin --user admin --passwordfile /gf_admin/pw2.txt < /gf_admin/customizing.txt; ./asadmin stop-domain domain1
RUN rm -rf /gf_admin

EXPOSE 4848
EXPOSE 8080
EXPOSE 8181
EXPOSE 8443

ENTRYPOINT ["sh", "/opt/deploy.sh"]
