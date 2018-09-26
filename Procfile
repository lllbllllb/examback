web: java -Dserver.port=$PORT $JAVA_OPTS -jar target/*.jar
release: ./mvnw liquibase:update
web: java -Dserver.port=$PORT -jar target/spring-boot-sample-liquibase-1.0.0.jar --spring.datasource.url=${JDBC_DATABASE_URL}