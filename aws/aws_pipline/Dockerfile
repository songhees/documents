FROM tomcat:10.1-jdk21-temurin

LABEL maintainer="osh4880@gmail.com"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY build/docker/app.war /usr/local/tomcat/webapps/ROOT.war

ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG SPRING_PROFILES_ACTIVE=local
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -Duser.timezone=Asia/Seoul -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}"

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
  CMD curl -fsS http://localhost:8080/actuator/health || exit 1