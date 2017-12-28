#!/bin/sh

cp /opt/test-servlet.war $GF_HOME/domains/domain1/autodeploy
asadmin start-domain --verbose
