# Spring Cache

정의 : 메소드 결과를 캐시에 저장하여 같은 입력으로 반복 실행을 피해 성능을 높이는 추상화 기능 

> 메소드에 캐시를 적용하여 캐시에 있는 정보를 기반으로 메소드 실행 횟수를 줄인다.
> 
> 
> [공지사항, 조회수, 랭킹에 많이 사용됨]
> 

### **공식문서**

Spring Framework

[Cache Abstraction :: Spring Framework](https://docs.spring.io/spring-framework/reference/integration/cache.html)

Spring boot

[Caching :: Spring Boot](https://docs.spring.io/spring-boot/reference/io/caching.html)

[Caching](https://godekdls.github.io/Spring%20Boot/caching/)

[Spring Cacheable의 동작 원리](https://oliviarla.tistory.com/148)

<br>

## **@EnableCaching**

> Spring의 어노테이션 기반 캐시 관리 기능을 활성화
> 

### option

mode = AdviceMode.PROXY ( default )

- Cache는 프록시가 메소드 호출을 가로채서 캐시 로직을 붙이는 방식
    
    <aside>
    
    프록시를 거쳐 들어오는 외부 호출만 캐시가 적용
    
    같은 빈 안에서 호출하면 캐시 미 적용
    
    </aside>
    
    대상 객체 내부에서 자기 자신의 다른 메소드를 호출하는 **자기 호출(self-invocation)** 은, 호출된 메소드에 `@Cacheable`이 붙어 있어도 런타임에 실제 캐싱이 일어나지 않는다.
    
- public 메소드만 캐싱된다.
- interface에는 어노테이션을 붙이지 않기
- @PostConstruct 에서 캐시 메소드 호출하지 않기

mode = AdviceMode.ASPECTJ

<br>

### Spring Cache interface

> Spring Cache는 실제 저장소를 제공하지 않고(추상화) 실제 제공자가 이 인터페이스들을 구현하여 수행한다.
> 

- **CacheManager** : 캐시를 찾아주는 역할

- **Cache** : 공통 캐시 작업을 정의하는 인터페이스 (가져오고, 저장하고, 삭제, 비우기) 등의 표준을 추상화

	⇒ 구현 : 캐시를 실제 저장소로부터 어떻게 저장,조회,삭제할지 구체화함

	⇒ 주로 캐시 저장소에서 구현체를 제공

- **@Cacheable** : 무엇을, 언제 캐싱 할지 선언

<br>
<br>

# Cache annotation


> **캐시 연산 우선 순위**
> 
> 1. **메소드**
> 2. **클래스 수준** — `@CacheConfig`
> 3. **전역 설정** — `CachingConfigurer`

<br>

## **@Cacheable**

> 캐시 가능(cheachable)한 메소드를 구분
> 

결과가 캐시에 저장되어 이후 동일한 key로 다시 호출될 때 메소드를 실제로 실행하지 않고 캐시에 있는 값을 반환하는 메소드

⇒ 캐시에 있는 내용이 반환되고 **메소드는 호출되지 않는다.**

⇒ 메소드가 return 하는 값을 캐시에 저장

⇒ `@Cacheable`은 `Optional<T>`를 지원

<br>

### **option**

- **value** : cache 이름, 속성없이 값이 할당되어 있다면 value 값이다. @Cacheable(”name”)’

	books, isbns 이름의 두 캐시에 값을 저장 → 호출 시 `books` 확인 → 없으면 `isbns` 확인

	```java
	@Cacheable({"books", "isbns"})
	public Book findBook(ISBN isbn) { ... }
	```

- **key** : 

	> 캐시는 본질적으로 키-값 저장소
	> 
	- key 를 지정하지 않으면 **메소드 호출 시점의 인수(매개변수에 들어온 실제 값)** 로 기본 키를 만든다.
	
	- 모든 매개변수가 key값으로 적합하지 않다.
	    
	    따라서 key 속성을 통해 키가 생성되는 방식을 지정 ⇒ SpEL을 사용
	    
	    ```java
	    @Cacheable(cacheNames="books", key="#isbn")
	    public Book findBook(ISBN isbn, boolean checkWarehouse, boolean includeUsed)
	    
	    @Cacheable(cacheNames="books", key="#isbn.rawNumber")
	    public Book findBook(ISBN isbn, boolean checkWarehouse, boolean includeUsed)
	    
	    @Cacheable(cacheNames="books", key="T(java.lang.String).format('%s:%s', #userId, #sku)")
	    // String 타입의 객체의 메소드를 사용해서 userId, sku 값으로 key값을 만든다.
	    public Book findBook(ISBN isbn, String userId, String sku)
	    ```
     
- **keyGenerator** : 

	- CustomKey 를 사용하고 싶을 경우 ⇒ KeyGenerator 를 구현한 빈의 이름을 지정
    
    

- **sync** 

	= true
	
	여러 사용자가 요청시 첫번째 요청만 메소드를 실행하고 나머지 사용자는 계산이 끝날 때 까지 대기했다가 캐시 값을 받는다.
	
	스레드 1 실행 2, 3 대기 → 1이 캐시에 저장 → 2, 3은 캐시에서 즉시 반환 ✅
	
	이 기능은 **캐시 구현체가 지원**해야 한다.
	
	스프링이 제공하는 기본 `CacheManager`들은 지원하지만, 사용 중인 외부/서드파티 캐시가 다 지원하는 것은 아니다.
	
	 = false ( default 값 ) : 스레드 1,2,3 → 전부 메소드 실행 → DB 3번 호출
	
	- **sync 로직**
	    
	    SpringCacheAnnotationParser 에서 `parseCacheableAnnotation` 메소드가 실행
	    
	    → CacheableOperation가 생성되고 Cacheable 플래그가 setting된다.
	    
	    sync은 CacheableOperation 에서 아래와 같이 정의되어 있다.
	    
	    ```java
	    public boolean isSync() {    return this.sync;}
	    ```
	    
	    CacheAspectSupport 안의 내부 클래스 CacheOperationContexts
	    
	    ```java
	    	@Nullable
	    	private Object execute(CacheOperationInvoker invoker, Method method, CacheOperationContexts contexts) {
	    		**if (contexts.isSynchronized()) {**
	    			// Special handling of synchronized invocation
	    			return executeSynchronized(invoker, method, contexts);
	    		}
	    
	    		// Process any early evictions
	    		processCacheEvicts(contexts.get(CacheEvictOperation.class), true,
	    				CacheOperationExpressionEvaluator.NO_RESULT);
	    
	    		// Check if we have a cached value matching the conditions
	    		Object cacheHit = findCachedValue(invoker, method, contexts);
	    		if (cacheHit == null || cacheHit instanceof Cache.ValueWrapper) {
	    			return evaluate(cacheHit, invoker, method, contexts);
	    		}
	    		return cacheHit;
	    	}
	    ```
	    
	    에서 sync 여부 판단하여
	    
	    executeSynchronized 를 실행하고 내부에서는
	    
	    `Cache cache = context.getCaches().iterator().next();` 
	    
	    cache값은 CacheOperationContext 에서 getCaches 메소드를 실행하고 
	    
	    `this.caches = CacheAspectSupport.this.getCaches(this, metadata.cacheResolver);` 
	    
	    getCaches ⇒ `Collection<? extends Cache> caches = cacheResolver.resolveCaches(context);` 
	    
	    CacheResolver 의 구현체인 SimpleCacheResolver (AbstractCacheResolver) 의 `resolveCaches`
	    
	    를 통해 CacheManager로 부터 getCache → Cache값 (`Collection<? extends Cache> caches`)을 가져온다.
    

- **condition :** 조건부 캐싱하기 위한 옵션
	
	`true` 또는 `false`로 평가되는 SpEL 표현식을 받는다.
	
	- `true` → 캐시 저장
	- `false` → 캐시에 저장 금지, 메소드가 호출된다.
	
	ex) name의 길이가 32 미만이면 캐시됨
	
	```java
	@Cacheable(cacheNames="book", condition="#name.length() < 32") 
	public Book findBook(String name)
	```

- **unless** : 캐시에 추가하는 것을 거부하는 조건
	
	메소드가 호출된 후에 캐시를 넣을지 말지 결정
	
	- `true` → 캐시에 저장 금지, 결과만 반환
	    
	    서비스 메소드가 아무것도 캐시하지 않고 단순히 캐시를 확인하도록 하려면 **unless ="true"를 사용**
	    
	- `false` → 캐시 저장하고 결과 반환
	
	ex ) #result.hardback ⇒ Book.hardback 값이 true 면 캐시되지 않음
	
	```java
	@Cacheable(cacheNames="book", condition="#name.length() < 32", unless="#result?.hardback") 
	public Book findBook(String name)
	```
	
	#result 는 메소드 호출 결과를 뜻 함
	
	Optional일 때 #result 는 내부 값
	
	null Exception을 방지하기 위해서 **?.** 사용

<br>

## **@CachePut**

> **캐시 update 어노테이션**
> 
- 메소드는 항상 호출되며 그 결과가 캐시에 저장
- `@Cacheable`과 동일한 옵션

두 annotation을 통해 database에 접근을 줄인다. ⇒ 효율 ⬆️

<br>

## **@CacheEvict**

> **캐시 삭제 어노테이션**
> 
> 
> 따라서 메소드에 반환값이 없어도됨 (void)
> 

[[입 개발] Spring 의 CacheEvict 에서 allEntries=true 는 Redis에서 어떻게 동작하게 될까?](https://charsyam.wordpress.com/2022/04/18/%EC%9E%85-%EA%B0%9C%EB%B0%9C-spring-%EC%9D%98-cacheevict-%EC%97%90%EC%84%9C-allentriestrue-%EB%8A%94-redis%EC%97%90%EC%84%9C-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EA%B2%8C/)

- allEntries=true

	key값 상관없이 해당 value로 들어간 모든 캐시 데이터를 지운다.

- beforeInvocation

	- true → 메소드 호출 전에 발생
	- false (default) → 메소드 완료 후에 동작

<br>

## @Caching

> 하나의 메소드에 중첩된 여러 `@Cacheable`, `@CachePut`, `@CacheEvict` 애노테이션을 사용할 수 있다.
> 

```java
@Caching(evict = { @CacheEvict("primary"), @CacheEvict(cacheNames="secondary", key="#p0") })
public Book importBooks(String deposit, Date date)
```

<br>

## @CacheConfig

> 클래스 레벨 어노테이션으로 클래스내 캐시 이름, KeyGenerator, CacheManager, … 을 공유하도록 한다.
> 

```java
@CacheConfig("books") 
public class BookRepositoryImpl implements BookRepository {

	@Cacheable
	public Book findBook(ISBN isbn) { ... }
}
```

<br>
<br>

# Cache + Transactional


`@CachePut`도 `@CacheEvict`도 DB 커밋보다 먼저 실행될 수 있다.

`@EnableTransactionManagement` 와 `@EnableCaching` 설정 순서에 따라 다르다.

⇒ 기본 order 값이 동일하므로 순서가 보장되지 않는다.

<br>

CacheInterceptor

└─ TransactionInterceptor

└─ 실제 메소드

```java
@EnableTransactionManagement(order = 2) 
@EnableCaching(order = 1)
// 캐시로직 실행 -> 트랜잭션 시작 -> 커밋 -> 캐시 returning
```

TransactionalInterceptor

└─ CacheInterceptor

└─ 실제 메소드

```java
@EnableTransactionManagement(order = 1) 
@EnableCaching(order = 2) 
// 트랜잭션을 시작 -> 캐시로직 실행 -> 캐시 returning -> 커밋
```

order 번호가 높은 순으로 먼저 종료됨

<br>

## Cache → Transaction

TransactionInterceptor 가 더 안쪽에 있다면 커밋 후에 CacheEvict 가 실행된다.

```java
[DEBUG] 2025-10-08 15:15:43 [Test worker] JdbcTransactionManager - Initiating transaction commit
[DEBUG] 2025-10-08 15:15:43 [Test worker] JdbcTransactionManager - Committing JDBC transaction on Connection [HikariProxyConnection@1735552465 wrapping org.postgresql.jdbc.PgConnection@6b78cbee]
[DEBUG] 2025-10-08 15:15:43 [Test worker] PgConnection -   setAutoCommit = true
[DEBUG] 2025-10-08 15:15:43 [Test worker] JdbcTransactionManager - Releasing JDBC Connection [HikariProxyConnection@1735552465 wrapping org.postgresql.jdbc.PgConnection@6b78cbee] after transaction
[TRACE] 2025-10-08 15:15:43 [Test worker] CacheInterceptor - Invalidating entire cache for operation Builder[public void com.example.springcache.service.CacheService.removeSimpleVO(com.example.springcache.domain.SimpleVO,java.util.concurrent.CountDownLatch,java.util.concurrent.CountDownLatch)] caches=[test] | key='' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='',true,false on method public void com.example.springcache.service.CacheService.removeSimpleVO(com.example.springcache.domain.SimpleVO,java.util.concurrent.CountDownLatch,java.util.concurrent.CountDownLatch)
[TRACE] 2025-10-08 15:15:43 [Test worker] CacheInterceptor - Computed cache key 'test' for operation Builder[public java.util.List com.example.springcache.service.CacheService.getAllSimpleVO()] caches=[test] | key=''test'' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='' | unless='' | sync='true'
```

딱히 설정하지 않았지만 커밋 후에 Evict가 실행되는 것으로 동작한다. 

<br>

## Transaction → Cache

CacheInterceptor 가 더 안쪽에 위치 캐시 returning 후에 커밋 실행

**log** 

```java
[DEBUG] 2025-10-08 16:11:25 [Thread-4] modifySimpleVO - ==>  Preparing: UPDATE sample SET validation = ? WHERE id = ? RETURNING *
[DEBUG] 2025-10-08 16:11:25 [Thread-4] modifySimpleVO - ==> Parameters: N(String), 1(Integer)
[DEBUG] 2025-10-08 16:11:25 [Thread-4] modifySimpleVO - <==      Total: 1
// mybatis 로그
[DEBUG] 2025-10-08 16:11:25 [Thread-4] SqlSessionUtils - Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f472b23]
[TRACE] 2025-10-08 16:11:25 [Thread-4] CacheInterceptor - Invalidating entire cache for operation Builder[public void com.example.springcache.service.CacheService.removeSimpleVO(com.example.springcache.domain.SimpleVO,java.util.concurrent.CountDownLatch,java.util.concurrent.CountDownLatch)] caches=[test] | key='' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='',true,false on method public void com.example.springcache.service.CacheService.removeSimpleVO(com.example.springcache.domain.SimpleVO,java.util.concurrent.CountDownLatch,java.util.concurrent.CountDownLatch)
// evict 실행
[DEBUG] 2025-10-08 16:11:25 [Thread-4] SqlSessionUtils - Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f472b23]
[TRACE] 2025-10-08 16:11:25 [Test worker] CacheInterceptor - Computed cache key 'test' for operation Builder[public java.util.List com.example.springcache.service.CacheService.getAllSimpleVO()] caches=[test] | key=''test'' | keyGenerator='' | cacheManager='' | cacheResolver='' | condition='' | unless='' | sync='true'
// 키 계산 후 cache 찾기
...
[DEBUG] 2025-10-08 16:11:25 [Test worker] SqlSessionUtils - Creating a new SqlSession
[DEBUG] 2025-10-08 16:11:25 [Test worker] SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5896899d] was not registered for synchronization because synchronization is not active
[DEBUG] 2025-10-08 16:11:25 [Test worker] DataSourceUtils - Fetching JDBC Connection from DataSource
[DEBUG] 2025-10-08 16:11:25 [HikariPool-1:connection-adder] PgConnection -   setSchema = cache
[DEBUG] 2025-10-08 16:11:25 [HikariPool-1:connection-adder] PoolBase - HikariPool-1 - Established new connection
[DEBUG] 2025-10-08 16:11:25 [HikariPool-1:connection-adder] HikariPool - HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@4fa4d11f
/// select 위한 connection 추가
[DEBUG] 2025-10-08 16:11:25 [Test worker] SpringManagedTransaction - JDBC Connection [HikariProxyConnection@1832936189 wrapping org.postgresql.jdbc.PgConnection@4fa4d11f] will not be managed by Spring
[DEBUG] 2025-10-08 16:11:25 [Test worker] getAllSimpleVO - ==>  Preparing: SELECT * FROM sample
[DEBUG] 2025-10-08 16:11:25 [Test worker] getAllSimpleVO - ==> Parameters: 
[DEBUG] 2025-10-08 16:11:25 [Test worker] getAllSimpleVO - <==      Total: 1
[DEBUG] 2025-10-08 16:11:25 [Test worker] SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5896899d]
...
[DEBUG] 2025-10-08 16:11:25 [Thread-4] SqlSessionUtils - Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f472b23]
[DEBUG] 2025-10-08 16:11:25 [Thread-4] SqlSessionUtils - Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f472b23]
[DEBUG] 2025-10-08 16:11:25 [Thread-4] JdbcTransactionManager - Initiating transaction commit
// 트랜잭션 커밋 시작
[DEBUG] 2025-10-08 16:11:25 [Thread-4] JdbcTransactionManager - Committing JDBC transaction on Connection [HikariProxyConnection@1051656116 wrapping org.postgresql.jdbc.PgConnection@2fe7f3b2]
// update 에 사용된 커넥션으로 수행
[DEBUG] 2025-10-08 16:11:25 [Thread-4] PgConnection -   setAutoCommit = true
```

- `@Transactional` 메소드(쓰기)가 **커밋되기 전에** 다른 트랜잭션(또는 비트랜잭션)에서
- `@Cacheable`로 조회하면, 캐시에 값이 없으니 DB로 요청이 되고
- 대부분의 기본 격리수준(READ_COMMITTED)에서는 커밋 전 값(이전 값)을 보게 된다.
- 그 조회 결과가 곧바로 캐시에 **채워지면**(put)
- 쓰기 트랜잭션이 아직 커밋 전이라면 오래된 값이 캐시에 올라갈 수 있다.

- 트랜잭션은 메소드가 정상 반환 된 뒤에 커밋되는데
- put/evict는 보통 메소드 반환 직후 실행되기 때문

<aside>

update 메소드  — 메소드 종료 — **evict 실행 — update 커밋**

- evict 실행과 update 커밋 사이에 다른 스레드에서 요청이 오면 오래된 값이 캐시에 올라갈 수 있다. **← 오류발생**

</aside>

<br>

### rollback

- `@CacheEvict(beforeInvocation=true)`
    - 캐시 삭제 시점 : 메소드 실행 전
    - 롤백 시 : DB는 되돌아가지만 캐시는 이미 지워진 상태 → 성능 저하
- `@CacheEvict(beforeInvocation=false)`(default)
    - 캐시 삭제 시점 : 메소드 정상 종료 직후
    - 롤백 시 : DB는 원복되지만 캐시는 지워진 상태 → 성능 저하
- `@CachePut`
    - 캐시 갱신 시점 : 메소드 정상 종료 직후
    - 롤백 시 : DB는 원복되지만 캐시는 업데이트 된 상태 → 불일치 문제

**해결하는 방법**

1. order 설정
    
    ```java
    @EnableTransactionManagement(order = 2) 
    @EnableCaching(order = 1)
    // 캐시로직 실행 -> 트랜잭션 시작 -> 커밋 -> 캐시 returning
    ```
    
2. TransactionAwareCacheManagerProxy 설정
    
    클래스 내에서 cache를 가져올때 아래 로직을 사용
    
    TransactionAwareCacheDecorator : Cache 구현을 감싸고 put, evict 또는 clear 작업이 현재 트랜잭션이 성공적으로 커밋된 후에 실행되도록 한다.
    
    ```java
    	@Override
    	@Nullable
    	public Cache getCache(String name) {
    		Assert.state(this.targetCacheManager != null, "No target CacheManager set");
    		Cache targetCache = this.targetCacheManager.getCache(name);
    		return (targetCache != null ? new TransactionAwareCacheDecorator(targetCache) : null);
    	}
    ```
    
    Custom CacheManager 생성
    
    ```java
    @Configuration
    @EnableCaching(order = 2)
    public class CacheConfig {
    
        @Bean(name = "delegateCacheManager")
        public CacheManager delegateCacheManager(HazelcastInstance hz) {
            return new HazelcastCacheManager(hz);
        }
    
        @Bean
        @Primary
        public CacheManager transactionAwareCacheManager(
                @Qualifier("delegateCacheManager") CacheManager target) {
            return new TransactionAwareCacheManagerProxy(target);
        }
    }
    ```
    
    Hazelcast 에도 되는 건가…..?

<br>

Test Case

- caching → transaction
    
    update mybatis → select → 커밋 → evict → select : Y → N 으로 select
    

- transaction → caching
    
    update mybatis → evict → select → 커밋 → select : Y → Y 으로 select (이슈 발생)
    

- trasaction → caching // TransactionAwareCacheManagerProxy 설정
    
    udpate mybatis → select → 커밋 → evict → sellect : Y → N 으로 select


<br>
<br>


# Setting


### **dependency**

```java
implementation 'org.springframework.boot:spring-boot-starter-cache
```

<br>

### in Application

**@EnableCaching**를 통해 활성화 → Spring Boot는 캐싱 지원이 활성화되어 있는 캐시인프라를 자동 구성

<br>
<br>

# 캐시 저장소


[[Spring] 캐시란? + Spring Boot 내장 캐시 사용하기](https://hogwart-scholars.tistory.com/entry/Spring-%EC%BA%90%EC%8B%9C%EB%9E%80-Spring-Boot-%EB%82%B4%EC%9E%A5-%EC%BA%90%EC%8B%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)

- 따로 캐시 라이브러리를 설정해주지 않는다면
- Spring Boot 내장 캐시를 사용하게 된다. ⇒ 어플리케이션 서버 내의 메모리를 사용
- 저장소를 사용하지 않음에 따라 분산 서버에 대한 오류가 발생하게 된다. 캐시 값이 변경되는 경우
- 해당 변경 로직이 발생한 인스턴스에만 CachePut 이 실행되기 때문에 다른 서버에서는 캐시 값이 변경되지 않아 불일치 문제가 발생

<br>

## Hazelcast

자바 언어로 되어 있는 오픈 소스

- 서버 메인 메모리에 데이터를 저장한다.
- 데이터는 자동으로 다른 서버에 동시에 저장한다.
- HazelcastInstance가 자동 구성되어 있고 com.hazelcast:hazelcast-spring이 클래스패스에 있으면, 이것은 자동으로 CacheManager로 래핑됩니다.

[Add caching to Spring | Hazelcast Documentation](https://docs.hazelcast.com/hazelcast/5.5/spring/add-caching)

[Configure Hazelcast in Spring | Hazelcast Documentation](https://docs.hazelcast.com/hazelcast/5.5/spring/configuration)

<br>

### dependency

```java
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>hazelcast-spring</artifactId>
    <version>5.5.0</version>
</dependency>
<dependency>
    <groupId>com.hazelcast</groupId>
    <artifactId>hazelcast</artifactId>
    <version>5.4.0</version>
</dependency>
```

```java
implementation 'com.hazelcast:hazelcast-spring'
```

<br>

### application.yml

Spring boot에서 hazelcast.yml을 읽어서 `HazelcastInstance`을 만들어 주고, 캐시를 켠 경우 `CacheManager`도 `HazelcastCacheManager`로 자동 연결

```java
spring:
  cache:
    type: hazelcast                # Spring Cache 저장소로 Hazelcast 사용
  hazelcast:
    config: classpath:hazelcast.yml  # 아래 파일 로드
```

<br>

### 1. hazelcast.yml

> 파일로 구성
> 

```java
hazelcast:
  cluster-name: app-cluster        # 모든 WAS에서 동일해야 클러스터가 형성됨

  network:
    port:
      port: 5701
      auto-increment: true
      port-count: 20
    join:
      multicast:
        enabled: true              # 로컬/개발 환경은 간단히 멀티캐스트
      tcp-ip:
        enabled: false             # 운영은 여기 true, 멀티캐스트 false 권장
        member-list:
          - 10.0.0.11              # 운영 WAS A IP
          - 10.0.0.12              # 운영 WAS B IP

  map:
    authz:                         # Spring Cache 이름과 매핑
      time-to-live-seconds: 120    # 권한 캐시: TTL 2분
      backup-count: 1              # 복제본 1개 (노드 1대 장애 대비)
      eviction:
        size: 100000
        max-size-policy: PER_NODE
        eviction-policy: LRU

```

```java
hazelcast:
  cluster-name: app-cluster
  network:
    join:
      multicast: { enabled: false }        # 운영은 TCP-IP 권장
      tcp-ip:
        enabled: true
        member-list: [10.0.0.11, 10.0.0.12]
  map:
    policy:                                 # 전역 테이블 캐시 맵
      time-to-live-seconds: 1800            # 예) 30분 (안전망; 너무 길게는 X)
      backup-count: 1
      eviction:
        eviction-policy: LRU
        max-size-policy: PER_NODE
        size: 10                            # 엔트리 1개만 쓰니 작게 잡아도 OK

```

- **eviction-policy** : 맵이 꽉 찼을 때 어떤 엔트리를 버릴지 결정하는 규칙
    
    **LRU (Least Recently Used)** → 가장 오랫동안 안 쓰인 엔트리를 지움
    
- **max-size-policy :** 용량 제한을 어떤 단위로 적용할 것인가
    - `PER_PARTITION` : 파티션마다 제한
    - `USED_HEAP_SIZE` : 노드별 JVM heap 메모리 사용량(MB 단위)
    - `USED_HEAP_PERCENTAGE` : 노드별 JVM heap 사용률(%)
    - `FREE_HEAP_SIZE` / `FREE_HEAP_PERCENTAGE` : 남은 heap 공간 기준
    - `ENTRY_COUNT` : 클러스터 전체 엔트리 개수 기준
- **size**
    - `max-size-policy`와 **짝꿍**처럼 동작하는 수치 값
    - 여기서는 `PER_NODE`니까 → “노드당 엔트리 10개까지만 저장 가능”이라는 의미.
    - 즉,
        - 노드에 11번째 엔트리가 들어오면 Hazelcast가 LRU 정책에 따라 가장 덜 사용된 엔트리를 제거합니다.
        - 클러스터에 3노드 있으면 → 총 30개까지 저장 가능 (노드당 10개).

<br>

### 2. HazelcastConfig

> bean으로 제공
> 

**Hazelcast는 sync = true 가 적용된다.**
