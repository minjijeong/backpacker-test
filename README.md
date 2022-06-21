## Swagger 로그인 정보
접속 URL : http://localhost:8080/swagger-ui/index.html  
ID : user  
Password : 1234  

*SecurityConfig 파일에 로그인 정보 선언* 
>  /src/main/java/com/api/backpackerapi/config/SecurityConfig.java

## H2 DB 접속 정보
접속 URL : http://localhost:8080/h2-console/  
JDBC URL : jdbc:h2:mem:test  
Driver Class : org.h2.Driver  
ID : sa  
Password : 1234  

*application.yml 파일에 DB 접속 정보 선언*
> /Users/minjijeong/backpacker-api/src/main/resources/application.yml