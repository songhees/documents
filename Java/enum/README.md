# Enum

**공식문서**

[Chapter 8. Classes](https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.9)

<br>

```java
public enum Direction {
		NORTH, SOUTH, EAST, WEST;
}
```

- enum 명은 첫 문자를 대문자로 나머지 소문자자
- 열거 상수는 모두 대문자 혹은 _ 추가 가능

> 상수 집합 타입 ( 예 : 나침반 ( 북쪽, 남쪽, 동쪽, 서쪽 )
> 

Direction은 Enum<E> 을 상속 받으므로, 선언된 각 enum 상수에 대해, E는 **동일한 이름**을 가지는 **타입 E의 암묵적으로 선언된 `public static final` 필드**를 가진다.

static final 참조로 heap 영역에 저장됨

```java
public final class Direction extends Enum<Direction> {
    // 👇 enum 상수와 동일한 이름의 public static final 필드 생성
    public static final Direction NORTH = new Direction("NORTH", 0);
    public static final Direction SOUTH = new Direction("SOUTH", 1);
    public static final Direction EAST  = new Direction("EAST", 2);
    public static final Direction WEST  = new Direction("WEST", 3);
```

상수는 JVM 안에서 **단 하나의 인스턴스**만 유지됨 → **싱글톤 보장**.

각 enum 상수는 유일한 인스턴스이므로, `equals()` 대신 `==` 비교 연산자를 안전하게 사용할 수 있다.

<br>

### 생성자 생성

---

> enum 생성자는 외부에서 직접 호출 불가 → 컴파일러가 자동 호출
> 

spring boot : @AllARgsConstructor

java : private or default (package-private) 생성자 직접 생성

  ```java
  private final String code;
  private final String account;
  
  Dept(double code, double account) {
      this.code = code;
      this.account = account;
  }
  ```

<br>

### method

---

**Enum<E> method**

```java
@AllArgsConstructor
public enum Dept {
    CENTER_1234("1234", "1"),
    CENTER_4567("4567", "2"),
    CENTER_7890("4567", "4"),
    DEFAULT("7890", "6");

    private final String code;
    private final String account;

    public String getCode() {
        return code;
    }

    public String getAccount() {
        return account;
    }

    public static Dept valueOfDefault(String value) {
        try {
            return Dept.valueOf(value);
        } catch (IllegalArgumentException e) {
            return DEFAULT;
        }
    }
}
```

- valueOf**()** : 상수 이름을 넣으면 동일한 문자열의 상수를 반환

  - `public static final Direction CENTER_1234 = new Direction("CENTER_1234", 0, "1234", "1");`

  - 이렇게 선언된 상수를 반환

    ```java
    Direction d = Direction.valueOf("CENTER_1234");
    
    d.getCode(); // == "1234"
    ```

<br>

**사용자 정의**

- getXX() : 
   - 상수 인스턴스안의 필드를 불러오기 위해서는 getter를 직접 정의해야 된다.
