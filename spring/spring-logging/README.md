# Logging

<br>
<br>

# Log level

**debug**

 - 프로그램 실행과 관련된 상세한 정보

 - 모든 level의 정보를 출력


**info**

 - 프로그램 실행 정보

 - debug를 제외한 나머지를 출력

**warn**

 - 프로그램 실행에 영향을 미치지 않는 오류 정보

 - debug, info를 제외한 나머지를 출력

**error**

 - 프로그램 실행 중 발생한 오류 정보

 - 운영 시에 사용

**fatal**

 - 프로그램 실행 중 발생한 치명적인 오류 정보
        

<br>
<br>

# Logging

> 로그 설정
> 
- **Log4j -> Logback -> Log4j2** 으로 발전
- 프로그램 실행과 관련된 정보를 제공해 주기 위해서 사용
- 로그 레벨을 무엇으로 설정하냐에 따라서 출력 되는 메세지 양이 조절된다.
    - 해당 레벨과 하위 레벨 메세지를 출력
    - Appenders를 여러개 설정해서 출력방향을 여러개 할 수 있다.
    
    **sysout과 차이**
    
    - 로그를 쓰기 전에는 System.our.println를 사용했음
        - 무조건 출력 되기 때문에 메세지 양을 조절할 수 없다.
        - 출력은 무조건 화면에만 가능
- 특정 package, class에 설정 가능

<br>
<br>

## 설정

### pom.xml

- 기존 logging : 사용 X
    
    ```xml
    <!-- 스프링 실행과정에서 출력되는 로그를 commons-logging을 사용하지 않게 한다. -->
    <exclusions>
      <exclusion>
         <groupId>commons-logging</groupId>
         <artifactId>commons-logging</artifactId>
      </exclusion>
    </exclusions>
    ```
    

- 아래를 사용한다.
1. **logback : 로그 출력 라이브러리**
2. **log4jdbc-log4j2 : log의 가독성을 위해 추가하는 라이브러리**

<br>

## 1. logback 추가

참고 사이트
[[Spring] Logback으로 로깅(Logging)하기](https://amaran-th.github.io/Spring/[Spring]%20Logback%EC%9C%BC%EB%A1%9C%20%EB%A1%9C%EA%B9%85(Logging)%ED%95%98%EA%B8%B0/) ,
[Spring Boot logback 설정하기](https://javabom.tistory.com/68) ,
[Log4j 설정법 (log4jdbc-log4j2 라이브러리 이용)](https://rimkongs.tistory.com/312)

> 스프링 부트 환경에서 `spring-boot-starter-web` 안에 `spring-boot-starter-logging`의 logback이 기본적으로 포함
> 

<br>

### in application.properties

```jsx
logging:
  level:
    root: INFO
    com:
      chatting:
        fchat: DEBUG
  config: classpath:logback/logback-${spring.profiles.active}.xml
```

<br>

### logback.xml

[로깅 정책](https://medium.com/dong-gle/로깅-정책-768c658f0f8d)

appender :  어디에 출력할지 설정하는 속성

**class 종류**

1. ch.qos.logback.core.**ConsoleAppender** : 콘솔에 로그를 찍음, 로그를 OutputStream에 작성하여 콘솔에 출력되도록 한다.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="30 seconds">
		<!-- **출력 방향** : 어따가 출력할건지-->
		<!-- Appenders log 메시지가 출력될 대상을 결정 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS}[%-5level] : %msg%n</pattern>
        </encoder>
    </appender>
    **// jdbc.*에 대한 모든 로그를 off 한다음 특정 로그에 대해서 level="info" 를 설정하면
    // 필요한 로그만 보이도록 설정할 수있다.**
    <logger name="jdbc" level="OFF"/>
    <logger name="jdbc.sqlonly" level="DEBUG" additivity="false">>
        <appender-ref ref="STDOUT" />
    </logger>
    **// 쿼리 실행 결과 테이블 표출**
    <logger name="jdbc.resultsettable" level="DEBUG" additivity="false">>
        <appender-ref ref="STDOUT" />
    </logger>
    <!-- **기본 로그 level** -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>
```

1. ch.qos.logback.core.**FileAppender** : 파일에 로그를 찍음, 최대 보관 일 수 등를 지정할 수 있다.
2. ch.qos.logback.core.rolling.**RollingFileAppender** : 여러개의 파일을 롤링, 순회하면서 로그를 찍는다.(FileAppender를 상속 받는다. 지정 용량이 넘어간 Log File을 넘버링 하여 나누어 저장할 수 있다.)
    
    **rollingPolicy** 
    
    1. `TimeBasedRollingPolicy` : 특정 시간마다 롤링
    2. `FixedWindowRollingPolicy` : 특정 용량에 도달하면 롤링
    3. `SizeAndTimeBasedRollingPolicy` : 특정 시간 + 특정 용량에 도달하면 롤링
    
    ```xml
    <property name="LOG_PATH" value="./logs"/>
    <property name="LOG_PATH_NAME" value="${LOG_PATH}/nticDashBoard-prd.log"/>
    
    <appender name="ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>INFO</level>
        </filter>
        <file>${LOG_PATH_NAME}</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH_NAME}.%d{yyyyMMdd}</fileNamePattern>
            <maxHistory>3</maxHistory> <!-- 보관기간(개월) -->
        </rollingPolicy>
        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
            <layout class="ch.qos.logback.contrib.json.classic.JsonLayout">
                <timestampFormat>yyyy-MM-dd HH:mm:ss.SSS</timestampFormat>
                <timestampFormatTimezoneId>Asia/Seoul</timestampFormatTimezoneId>
                <appendLineSeparator>true</appendLineSeparator>
                <jsonFormatter class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter">
                </jsonFormatter>
            </layout>
        </encoder>
    </appender>
    ```
    
3. ch.qos.logback.classic.net.SMTPAppender : 로그를 메일에 찍어 보낸다.
4. ch.qos.logback.classic.db.DBAppender : DB(데이터베이스)에 로그를 찍는다.

Filter

로그의 어떤 레벨을 특정하여 저장할 것인지 설정하는 속성

- `LevelFilter` : 특정 레벨만 저장
- `ThresholdFilter` : 특정 레벨 이상을 저장

File

저장 파일 위치

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration
		xmlns="http://logging.apache.org/log4j/2.0/config">
		
		<!-- **출력 방향** : 어따가 출력할건지-->
		<!-- Appenders를 여러개 설정해서 출력방향을 여러개 할 수 있다. -->
		<Appenders>
															<!-- 화면에 출력  -->
				<Console **name="stdout"** target="SYSTEM_OUT">
					<!-- **출력형식**           날짜형식/5칸 로그 레벨/맨마지막클래스이름/메세지/줄바꿈-->
						<PatternLayout pattern="%d{HH:mm:ss} %5p [%c{1.}] %m%n" />
				</Console>
		</Appenders>
		
		<!-- **로그 레벨 설정** -->
		<Loggers>
				<Logger name="org.springframework" level="debug" />
				<!--  
					mybatis가 실행하는 SQL 구문 정보 및 실행되는 쿼리문, 파라미터값, 조회결과를 로그로 출력하기 위해서
		
					mapper 인터페이스가 정의된 패키지를 지정하고 로그레벨을 trace로 지정한다.
				-->
				<Logger name="com.sample.dao" level="trace" />
				<!-- **기본 로그 level** -->
				<Root level="error">
						<AppenderRef **ref="stdout"** />
				</Root>
		</Loggers>

</Configuration>
```

<br>

## 2. **log4jdbc-log4j2 추가**


### dependency

<br>

**Maven**

```xml
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
    <version>1.16</version>
</dependency>
```

**Gradle**

```sql
implementation 'org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16'
```

를 추가함으로 써 log4j 라이브러리를 사용할 수 있게 된다. 더 편리하고 log4j설정 파일을 개발자가 설정할 수 있다.

`org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4:1.16`


`log4jdbc-log4j2-jdbc4` 버전은 Java 8 이후 JDBC에서는 `ResultSet` 인터페이스에 `getObject(String columnLabel, Class<T> type)` 메서드가 추가되어 에러가 발생

<br>

### **log4jdbc.log4j2.properties 생성**

> resources에 추가
> 

JDBC 드라이버의 동작을 사용자 정의하는 구성 파일

이 파일을 사용하여 드라이버의 로깅 출력, 로그 레벨, 어펜더 및 포맷팅과 같은 것을 제어할 수 있습니다.

```sql
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
log4jdbc.dump.sql.maxlinelength=0
```

<br>

### **application.properties 변경**

:**log4jdbc 추가**

```sql
**spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy // 변경**
spring.datasource.url=jdbc:**log4jdbc**:oracle:thin:@localhost:1521:XE
```

<br>
<br>

# Spring 3 version

**공식문서**
[Logging :: Spring Boot](https://docs.spring.io/spring-boot/how-to/logging.html?utm_source=chatgpt.com#howto.logging.log4j)

<br>

## dependency

의존성 구성을 위해 스타터(starter)를 사용한다면, **Logback을 제외하고 Log4j 2를 포함**해야 한다.

<br>

**maven**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

**gradle**

1. Log4j 2 스타터에 대한 종속성을 선언
2. **Spring Boot 3의 starter에는 Logback이 기본 포함이므로**
    1. 기본 logging가 나타나면 모두 Log4j 2 스타터로 대체하도록 Gradle에 지시 **⭐추천**
        
        ```yaml
        dependencies {
            implementation "org.springframework.boot:spring-boot-starter-log4j2"
            modules {
                module("org.springframework.boot:spring-boot-starter-logging") {
                    replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
                }
            }
        }
        ```
        
    2. Logback 을 exclude 하기
        
        해당 방법은 위험성이 크기 때문에 비추천 ( 전파 범위가 넓어 부작용을 예측하기 어렵다. )
        
        ```yaml
        configurations {
            compileOnly {
                extendsFrom annotationProcessor
            }
            all {
                exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
            }
        }
        
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-log4j2'
        }
        ```
        
<br>

## application.yml


```yaml
logging:
  config: classpath:log4j2-${spring.profiles.active}.xml
```

<br>

## log4j2.xml

공식 문서
[Configuration file :: Apache Log4j](https://logging.apache.org/log4j/2.x/manual/configuration.html)

```xml
<Configuration status="DEBUG">
    <Properties>
        <Property name="logPath">./logs</Property>
        <Property name="logPattern">[%-5level] %d{yyyy-MM-dd HH:mm:ss} [%t] %c{1} - %msg%n</Property>
        <Property name="serviceName">application</Property>
    </Properties>
    <Appenders>
        <Console name="console">
            <PatternLayout pattern="${logPattern}"/>
        </Console>
        <RollingFile
                name="file"
                append="true"
                fileName="${logPath}/${serviceName}.log"
                filePattern="${logPath}/${serviceName}.%d{yyyy-MM-dd}.%i.log.gz">
            <PatternLayout pattern="${logPattern}"/>
            <Policies>
                <SizeBasedTriggeringPolicy size="5MB"/> 
                <TimeBasedTriggeringPolicy/> 
            </Policies>
            <DefaultRolloverStrategy>
		            <Delete basePath="${logPath}" maxDepth="1">
		                <IfFileName glob="${serviceName}.*.log"/>
		                <IfLastModified age="15d"/>
		            </Delete>
		        </DefaultRolloverStrategy>
        </RollingFile>
    </Appenders>
    <Loggers>
        <!-- Hibernate SQL 로그 (실행되는 쿼리 확인) -->
        <Logger name="org.hibernate.SQL" level="debug" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>
        <!-- Hibernate 파라미터 바인딩 값 -->
        <Logger name="org.hibernate.orm.jdbc.bind" level="trace" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>      
        <!-- mybatis 로그 mapper 패키지 작성-->
        <Logger name="com.example.springcache.mapper" level="debug" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>
        <!-- 루트 로거 -->
        <Root level="info">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="FileAppender"/>
        </Root>
    </Loggers>
</Configuration>
```

### **Configuration**

status : **DEPRECATED** 됨 

- **Java 프로세스에 시스템 속성 전달 / 환경 변수로 제어하는 방식**을 권장
    
    tomcat의 bin/setenv.sh 파일 생성 후 아래 추가
    
    ```xml
    #!/bin/sh
    CATALINA_OPTS="$CATALINA_OPTS -Dlog4j2.statusLoggerLevel=INFO"
    export CATALINA_OPTS
    ```
    

### Loggers

- 로그 이벤트가 어느 로거로부터 나오는지, 어떤 레벨 이상인 로그를 허용할지, 어떤 Appender로 보낼지를 정의
    - ***Root*** : ROOT는 더 구체적으로 정의된 로거가 없는 모든 이벤트를 받는 로거
    - ***Logger*** : 가장 일반적인 형태의 로거로, 자기 자신과 명시적으로 설정되지 않은 모든 자식 로거들로부터 로그 이벤트를 수집
    - ***AsyncRoot***
    - ***AsyncLogger***
- **option**
    - name : 클래스나 패키지의 전체 이름을 포함
    - additivity :  `true`라면 자식 로거의 로그가 부모 로거(루트)로도 흘러감 / default = false
    - level : 로그 이벤트가 기록되어야 하는 수준 임계값

### Appenders

- 로그 이벤트가 실제로 기록되는 대상 (콘솔, 파일, 데이터베이스, 네트워크 등)
- `Console`과 `File` Appender를 주로 사용
- ***RollingFile*** : **로그 파일을 아카이브(백업)하고 새 파일로 이어 쓰기** 기능을 지원
    
    [Rolling file appenders :: Apache Log4j](https://logging.apache.org/log4j/2.x/manual/appenders/rolling-file.html#element-TriggeringPolicy)
    
    **option**
    
    - append : true 기존 내용을 덮어쓰지 않고, 항상 파일 끝에 로그를 이어서 기록
        
        동시 접근 환경에서도 로그가 꼬이지 않고 안전하게 추가 기록
        
    - **<*Policies*>** : 로그 파일을 롤오버할 시점을 결정
        - <SizeBasedTriggeringPolicy size="5MB"/> : size가 5MB 초과하면 rollover 가 발생
        - <TimeBasedTriggeringPolicy/> : 최소 시간 단위의 값이 변경되면 롤오버가 발생
    - ***<DefaultRolloverStrategy>*** : `fileName` 구성 속성이 지정되면, 이것이 기본 전략으로 사용.
        
        이 전략은 현재 로그 파일을 `fileName`으로 지정된 위치에 저장하고, 아카이브된 로그 파일은 `filePattern`으로 지정된 위치에 저장
        

### Layouts

- Appender가 로그 이벤트를 어떻게 포맷할지 결정
- 예: `PatternLayout` (텍스트 형식), `JsonTemplateLayout` 등

### Properties

- `${name}` 형태로 속성 치환이 가능
- `Properties` 섹션을 통해 재사용 가능한 값들을 정의할 수 있음
