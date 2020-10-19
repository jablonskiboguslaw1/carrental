FROM openjdk:11
ADD carrental-v1.0.jar carrental.jar
CMD java -jar carrental.jar
