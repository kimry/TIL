# JAVA

JAVA로 개발하기 위해서는 자바에 대해서 알아야 한다.



하지만 나는 JAVA로 서버개발을 한다는 놈이 JAVA를 잘 모르는 병신이다.



고로 JAVA 공부를 시작한다.

# 목차

1. JVM
2. Primitive vs Wrapper
3. synchronized

# JVM

1. Class Loader
2. Runtime Data Area
3. Execution Engine
4. Garbage Collector

# Primitive 자료형 vs Wrapper Class

int 와 integer의 차이는 뭘까?



int, 즉 Primitive 자료형은 사전에 정의되어 있는 일반적인 데이터 타입을 말한다.



그렇기때문에 다음의 특성을 가진다.

1. 산술 연산이 가능하다.
2. null로 초기화 할 수 없다.

 

Integer, 즉 Warpper class는 객체이다.



그렇기 때문에 다음의 특성을 가진다.

1. 객체이기 때문에 unboxing을 하기 전에는 산술연산이 불가능하다.
2. 객체이기 때문에 null값을 넣을 수 있다.
3. DB에서 자료형이 정수형이지만 null값이 필요한 경우 DTO에 integer를 사용하여 null값을 표현할 수 있음.(이렇게 사용 가능하다는 것을 생각도 못해봤다.)

