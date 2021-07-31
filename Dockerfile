# The line below states we will base our new image on the Latest Official Ubuntu 
FROM adoptopenjdk/openjdk8

#
# Update the image to the latest packages
#RUN apt-get update && apt-get upgrade -y

#WORKDIR /app

COPY target/scala-2.13/cloud-run-demo-assembly-0.1.jar scala-app-demo.jar

EXPOSE 8080

# Run the web service on container startup.
CMD ["java", "-jar", "./scala-app-demo.jar"]
