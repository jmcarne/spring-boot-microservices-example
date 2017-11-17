# spring-boot-microservices-example
Microservices deployed with stack Netflix OSS with Docker

# Log in Hub Docker
User: jmcarne
Pwd:

# Create private repository

# Add file Dockerfile in microservice's IDE project

# Download github code in CentOs Virtual Machine
wget <link.zip>

# Build image
cd /root/spring-boot-microservices-example/eureka-service
docker build -t ms-eureka-service .

# Run docker image in CentOS VM
docker run -d <id_image>

# Push docker image to Hub Docker
docker pull <id_image>