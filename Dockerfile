FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17
ADD target/lab3.2.war /opt/jboss/wildfly/standalone/deployments/
