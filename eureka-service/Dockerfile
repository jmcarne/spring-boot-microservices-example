# Pull base image
# ---------------
FROM docker.io/bankmonitor/spring-boot

# Maintainer
# ----------
MAINTAINER Josep Maria Carné <josep.mariacarne@amaris.com>

# Set environment variables and default password for user 'admin'
ENV CATALINA_BASE=/usr/local/tomcat \
    CATALINA_HOME=/usr/local/tomcat \
    PATH=$PATH:/glassfish4/bin \
    PASSWORD=glassfish \
    JAVA_HOME=/usr/lib/jvm/java-openjdk

# Tomcat Configuration
# -------------------------------

# Add files required to build this image
COPY src/main/java/com/example/eurekaservice/* /usr/local/tomcat/webapps/

RUN yum -y install java-1.8.0-openjdk-devel && rm -rf /var/cache/yum/*

ENV JAVA_HOME /usr/lib/jvm/java-openjdk

EXPOSE 80 8761

CMD ["java", "-version"]
