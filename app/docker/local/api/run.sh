#!/bin/bash
dos2unix mvnw
echo "LA VARIABLE DE ENTORNO ES $SAMPLE_SIZE"
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -Dsample.size=$SAMPLE_SIZE" &
while true; do
  inotifywait -e modify,create,delete,move -r ./src/ && ./mvnw compile
done