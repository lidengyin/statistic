FROM java:8
MAINTAINER lidengyin
ARG JAR_FILE
ADD ${JAR_FILE} statistics.jar
ADD ./simsun.ttc /usr/share/fonts
ADD ./haichuang.png /usr/local
EXPOSE 8251
ENTRYPOINT ["java","-jar","statistics.jar"]