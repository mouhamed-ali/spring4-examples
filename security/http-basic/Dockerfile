# we are extending everything from tomcat:7.0 image ...
FROM tomcat:7.0

# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY ./target/http-basic.war /usr/local/tomcat/webapps/http-basic.war

# add a tomcat user
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml