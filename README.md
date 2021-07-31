How to deploy:

#Generate binary
sbt assembly 

# Authenticate Google Cloud (if not)
gcloud auth 

#Build the image to push to Google Cloud Registry
docker build . -t gcr.io/scalable-services/scala-demo-app:latest

#To bind to a port remember to put host: 0.0.0.0 ....

# Run locally to test
docker run --env PORT=8080 -p 8080:8080 gcr.io/scalable-services/scala-demo-app:latest

# Upload to gcr
docker push gcr.io/scalable-services/scala-demo-app:latest

#Dockerfile

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
