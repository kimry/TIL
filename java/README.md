# JAVA

JAVA로 개발하기 위해서는 자바에 대해서 알아야 한다.



하지만 나는 JAVA로 서버개발을 한다는 놈이 JAVA를 잘 모르는 병신이다.



고로 JAVA 공부를 시작한다.

# 목차

1. JVM
2. Primitive vs Wrapper
3. Synchronized
4. Class vs Object vs Instance

# 1. JVM

1. Class Loader
2. Runtime Data Area
3. Execution Engine
4. Garbage Collector

# 2. Primitive 자료형 vs Wrapper Class

int 와 integer의 차이는 뭘까?  



공부를 하기 전에는 int는 자료형이고 Wrapper Class는 객체라고만 알고 있었다.



하지만 무슨 이유로 따로 존재하고, 어떠한 작업에 Wrapper Class가 필요한지 정확히 알지 못했다.



int, 즉 Primitive 자료형은 사전에 정의되어 있는 일반적인 데이터 타입을 말한다.  



그렇기때문에 다음의 특성을 가진다.

1. 산술 연산이 가능하다.
2. null로 초기화 할 수 없다.

 

Integer, 즉 Warpper class는 객체이다.  



그렇기 때문에 다음의 특성을 가진다.  

1. 객체이기 때문에 unboxing을 하기 전에는 산술연산이 불가능하다.
2. 객체이기 때문에 null값을 넣을 수 있다.
3. DB에서 자료형이 정수형이지만 null값이 필요한 경우 DTO에 integer를 사용하여 null값을 표현할 수 있음.(이렇게 사용 가능하다는 것을 전혀 생각하지 못했다.)



솔직히 Wrapper Class가 왜 존재하는지에 대해서 이해가 잘 안됐었는데 찾아보니 이유가 있었다.

그냥 내가 몰랐고 궁금해하지 않았을 뿐...  



개발자가 되기 위해서 ''왜?' 라는 고민이 얼마나 중요한지 다시한번 느낄 수 있었다.  



# 3. Synchronized

여러 프로젝트들을 진행 했지만 시연을 위한 기능들을 위주로 구현했기 때문에 여러명이 동시에 요청할 때 생길 수 있는 동기화 문제에 대한 고려를 전혀 하지 않고 프로젝트를 진행했었다.



하지만 동기화 문제는 서버개발에 있어서 필수적으로 해결해야되는 문제이기 때문에 지금이라도 하나하나 채워 나가려고 한다.



그럼 `동기화`란 무엇인가?



동기화란 프로세스 또는 스레드들이 수행되는 시점을 조절하여 서로가 알고 있는 정보가 일치시키는 것을 뜻한다.



그럼 어떤 상황에서 서로간 정보의 불일치가 일어날까?



예를 들어보자.



내가 BTS의 공연 티켓을 예매하려고 한다고 가정 해보자.



분명 수많은 사람들이 동시에 한좌석의 티켓을 예매하기 위한 요청을 서버로 날릴 것이다..



만약 서버가 멀티 쓰레드 환경에서 이 요청들을 받게 된다면 여러명이 한좌석을 동시에 예매하는 상황이 발생할 수 있다.



이렇게 되면 서로가 자신이 표를 예매했다고 인지하기 때문에 서로간 정보의 불일치가 일어나게 된다.



이러한 문제를 해결하기 위해 java에 존재하는 키워드가 바로 `Synchronized`이다.





 

# 4. Class vs Object(객체) vs Instance

면접을 보면서 '객체가 어쩌구 저쩌구' 막 설명을 하던 와중에 면접관님이 질문을 해주셨다.

'보통 그럴때는 인스턴스로 설명하지 않나요?' 같은 맥락의  질문이었던 걸로 기억한다.

설명하다가 그 이야기를 듣고 멈춘 다음에 속으로 '뭐지... 같은거 아닌가...?'라는 멍청한 생각을 했었다.

그런 멍청한 생각을 한 기념으로 java에 국한된 이야기는 아니지만 Object와 Instacne, 거기에 추가로 Class까지 알아보기로 했다.  



1. 클래스란?

   * 객체를 만들어 내기 위한 `설계도` 혹은 `틀`

   * 연관되어 있는 `변수`와 `메서드`의 집합

     ex)

     ``` java
     public class Student { // Class
         String name;
         int kor;
         int eng;
         int math;
     
         public Student(String name, int kor, int eng, int math){
             this.name=name;
             this.kor=kor;
             this.eng=eng;
             this.math=math;
         }
         public int sum(){
             return this.kor+this.eng+this.math;
         }
     }
     
     ```

     

2. 객체(Object)란?

   * 소프트웨어 세계에 구현할 대상
   * 클래스에 선언된 모양 그대로 생성된 실체
   * `클래스의 인스턴스` 라고도 불린다.
   * 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 갖는다.
   * OOP관점에서 클래스의 타입으로 선언되었을 때 `객체`라고 부른다.

3. 인스턴스란?

  * 설계도를 바탕으로 소프트웨어 세계에 구현된 구체적인 실체
  * 즉, 객체를 소프트웨어에 실체화 하면 그것을 `인스턴스`라고 부르고 그 과정을 `인스턴스화`라고 한다.
  * 실체화 된 인스턴스는 메모리에 할당됨.
  * ex)

  ```java
  public class Hello {
      public static void main(String[] args) {
          
          Student student; //객체
          
          student = new Student(); //인스턴스화 
      }
  }
  ```

따로 공부를 하고나서 생각해보니 사실 이 개념에 대해서 이미 알고 있었다.

맨 처음 자바를 배울 당시, 클래스에 getInstance 함수를 만들어 인스턴스를 생성했던 것이 기억이 났다.

그럼에도 최근까지 여러 개념들을 설명할때 객체와 인스턴스를 구별하지 않고 모두 객체로 설명했다는 것이 한심하게 느껴졌다.  



참 쉽지가 않다.







