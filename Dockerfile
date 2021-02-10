FROM vertx/vertx4-exec
ENV VERTICLE_NAME com.example.shell.MainVerticle
ENV VERTICLE_FILE target/shell-1.0.0-SNAPSHOT.jar
# Set the location of the verticles
ENV VERTICLE_HOME /usr/verticles
EXPOSE 8888
# Copy your verticle to the container
COPY $VERTICLE_FILE $VERTICLE_HOME/
# Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
