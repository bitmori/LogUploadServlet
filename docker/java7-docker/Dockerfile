#
# Oracle Java 7 Dockerfile
#
# https://github.com/cogniteev/docker-oracle-java
# https://github.com/cogniteev/docker-oracle-java/tree/master/oracle-java7
#

# Pull base image.
FROM ubuntu

# Install Java.
RUN \
  apt-get install -y software-properties-common && \
  echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java7-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk7-installer

# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-7-oracle

# Add Java encryption jars
ADD ./US_export_policy.jar /usr/lib/jvm/java-7-oracle/jre/lib/security/US_export_policy.jar
ADD ./local_policy.jar /usr/lib/jvm/java-7-oracle/jre/lib/security/local_policy.jar

# Define default command.
CMD ["bash"]
