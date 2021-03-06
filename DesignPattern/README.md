# Design Pattern

나는 스스로 내가 사용하는 디자인 패턴에 대해서 잘 알고 사용한다고 생각했다.



하지만 막상 생각해보니 해당 디자인 패턴이 어떤 역할을 하고 무슨 장단점이 있는지 잘 설명하지 못한다는 것을 깨달았다.



고로 내가 지금까지 사용했던 Design Pattern들을 정리해보려고 한다.

# 목차

1. Singleton Pattern

2. Factory Method Pattern
3. Template Method Pattern

# 1. Singleton Pattern

싱글톤 패턴은 java를 배우면서 가장 먼저 배운 디자인 패턴이었다.

자바를 처음 배우던 당시에 싱글톤 패턴의 구조를 공부하고 그 공부를 바탕으로 코드작성도 해봤었기 때문에 스스로 싱글톤 패턴에 대해 잘 안다고 생각했었지만 막상 싱글톤 패턴이 왜 좋은지 문제점은 무엇인지에 대해 알아보고 고민해본적은 없었다.

그렇기 때문에 디자인 패턴중 가장 먼저 싱글톤 패턴에 대해서 공부해 보기로 했다.

Singleton Pattern이란?  

* 전역변수를 사용하지 않고 객체를 하나만 생성하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴
* 하나의 인스턴스만을 생성하여 getInstance 메서드를 통해 모든 클라이언트에게 동일한 인스턴스를 반환
* 장점
  1. 한번의 인스턴스 생성을 통해 고정된 메모리 영역을 가지게 되어 메모리 낭비를 방지
  2. 싱글톤 패턴을 이용하여 만들어진 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들과 데이터를 공유하는데 용이
  3. DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성하여 사용하는 환경에 용이
  4. 인스턴스가 절대적으로 하나만 존재하는 것을 보장하고 싶을 경우 용이
  5. 첫 인스턴스 생성 이후, 객체 로딩시간 감소
* 문재점
  1. 싱글톤 인스턴스가 너무 많은 일을 하거나 다른 클래스들과 너무 많은 데이터를 공유할 경우, 인스턴스들 간의 결합도가 높아져 객체지향적 프로그래밍을 위한 SOLID의 OCP, 개방 폐쇄 원칙에 어긋남.
  
  2. 다중 스레드에서 인스턴스가 2개 이상 생성될 가능성이 있음(동기화 처리 필요)
  
     ```java
     public class Hello {
         public static void main(String[] args)
         {
             MySingletonClass singleton1 = MySingletonClass.getInstance();
             MySingletonClass singleton2 = MySingletonClass.getInstance();
             MySingletonClass singleton3 = MySingletonClass.getInstance();
     
             System.out.println(singleton1.s);
             System.out.println(singleton2.s);
             System.out.println(singleton3.s);
     
             singleton1.s = "Change String"; // singleton1만 바뀔 것 같지만 모두 같은 인스턴스를 가지고 있으므로 모두 변환된 값을 출력함.
     
             System.out.println(singleton1.s);
             System.out.println(singleton2.s);
             System.out.println(singleton3.s);
         }
     }
     class MySingletonClass {
         private static MySingletonClass single_instance = null;
     
         public String s;
     
         private MySingletonClass() {
             s = "MySingletonClass"; // 인스턴스 생성시 들어가는 문자열
         }
     
         public static MySingletonClass getInstance() { 
             if(single_instance == null) { // null일 경우 인스턴스 생성
                 single_instance = new MySingletonClass(); // 멀티쓰래드 환경의 경우 인스턴스가 두개 이상 만들어 질 수 있음. 고로 Synchronized 필요.
             }
     
             return single_instance; // 인스턴스 생성 이후부터는 생성 없이 같은 인스턴스 리턴
         }
     }
     ```

공부를 하고 나서 느낀점은, 사실 프로젝트를 진행하면서 모든 구조를 싱글톤 패턴을 이용해서 구현 하였지만 동기화 처리에 대해 신경을 쓴적이 없었다.

동기화에 대해서 공부했었고, 실제로 개념에 대해서도 알고 있었지만 실제 프로그램에서 어떤식으로 적용시켜야 할지에 대한 경험이 부족했다고 생각한다.

그렇기 때문에 이번 기회를 통해 Java에서 Synchronized 키워드를 이용한 동기화 처리를 통해 실제 프로그램에 적용시켜 보도록 하겠다.

# 2. Factory Method Pattern

# 3. Template Method Pattern

