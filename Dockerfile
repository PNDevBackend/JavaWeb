FROM tomcat:9.0.80-jdk17-openjdk-slim

RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -rf /usr/local/tomcat/webapps/examples
ADD com.src.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]