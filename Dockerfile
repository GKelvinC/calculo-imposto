FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/calculo_imposto

COPY /target/calculo-imposto*.jar calculo_imposto.jar

SHELL ["/bin/sh","-c"]

EXPOSE 5005
EXPOSE 8080
EXPOSE 8000

CMD java ${ADDITIONAL_OPTS} -jar calculo_imposto.jar --spring.profiles.active=${PROFILE}