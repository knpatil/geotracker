
*How to build uber Spring boot jar?*

mvn package spring-boot:repackage

*How to build docker image?*

docker build -t kpatil/geotracker .

How to run the docker container?

docker run -p 8080:8080 kpatil/geotracker

How to tag an image with new name?

docker tag kpatil/geotracker knpatil/geotracker

Kubernetes environment setup

install oracle virtualbox
install minikue
install kubectl

minikube start
minikube status
minikube stop

eval $(minikube docker-env)

docker ps -a

Kubernetes Dashboard

Get address of the VM using 
minikube ip

Default port is 30000

Other command to open dashboard
minikube dashboard

Deploy a pod:
 kubectl create -f deployment.yaml 

Create a service
 kubectl expose deployment/geotracker

Create spring boot jar with all dependencies:
mvn package spring-boot:repackage

Remove docker image
docker rmi knpatil/geotracker

Build new docker image
docker build -t knpatil/geotracker .

Push image to docker repo
docker push knpatil/geotracker

Starting services by linking the network
docker run --net geotracker_default --link zookeeper knpatil/geotracker:5




