FROM openjdk:8-jdk-alpine

LABEL SERVICE_NAME=x-gene
ENV APP_NAME x-gene.jar
ENV USER_NAME service
ENV APP_HOME /opt/xgene/$USER_NAME

ENV LANG pt_BR.UTF-8

RUN mkdir -p $APP_HOME

ADD target/*.jar ${APP_HOME}/${APP_NAME}

RUN sh -c 'touch $APP_HOME/$APP_NAME'

WORKDIR $APP_HOME

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar $APP_NAME" ]
ENV TZ 'America/Sao_Paulo'