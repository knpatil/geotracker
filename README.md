
How to build uber Spring boot jar?

mvn package spring-boot:repackage


How to build docker image?

docker build -t kpatil/geotracker .

How to run the docker container?

docker run -p 8080:8080 kpatil/geotracker