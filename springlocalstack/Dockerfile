
FROM openjdk:21-slim

#RUN apt-get update && \
#    apt-get install -y wget unzip && \
#    wget https://services.gradle.org/distributions/gradle-8.0-bin.zip -P /tmp && \
#    unzip /tmp/gradle-8.0-bin.zip -d /opt && \
#    rm /tmp/gradle-8.0-bin.zip && \
 #   ln -s /opt/gradle-8.0/bin/gradle /usr/local/bin/gradle

WORKDIR /app

COPY build.gradle settings.gradle /app

CMD ["./gradlew", "bootRun"]
