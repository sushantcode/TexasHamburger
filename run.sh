cd THCSpringBootAPI
./mvnw clean install
cd ../THCOrderConsumer
./mvnw clean install
cd ..
docker-compose up --build