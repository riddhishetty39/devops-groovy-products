FROM anapsix/alpine-java
LABEL maintainer="smvrshetty5@gmail.com"
COPY /target/devops-groovy-products-0.1.1-SNAPSHOT.war /home/devops-groovy-products-0.1.1-SNAPSHOT.war
CMD ["java","-jar","/home/devops-groovy-products-0.1.1-SNAPSHOT.war"]