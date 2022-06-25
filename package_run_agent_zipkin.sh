docker run -d -p 9411:9411 openzipkin/zipkin

mvn clean package -DskipTests
java -javaagent:opentelemetry-javaagent.jar -Dotel.exporter.zipkin.endpoint="http://localhost:9411/api/v2/spans" 
-Dotel.javaagent.debug=false -Dotel.service.name=otel -Dotel.traces.exporter=zipkin -jar target/*.jar