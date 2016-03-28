FROM symphony/tomcat8java7

# get rid of unneeded default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Define working directory.
WORKDIR /usr/local/tomcat

# Define default command.
CMD ["catalina.sh", "run"]