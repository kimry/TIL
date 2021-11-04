# Data Structure
# 목차

* Array & List & ArrayList
* Stack & Queue
* Tree
  * Binary Tree
  * Binary Search Tree
  * Balanced Binary Search Tree
    * AVL Tree
    * Red-Black Tree
* Trie
* Heap
* Hash Table

# Array & List & ArrayList

* Array

  * 물리적 저장순서와 논리적 저장순서가 일치

  * index를 통해 `O(1)`만에 해당 원소로 바로 접근 가능

  * 삭제/삽입 시  `O(n)` 만큼의 후/선 처리가 필요

    > 삭제시 : 해당 원소를 삭제한 뒤에 해당 원소 뒤에 위치한 원소들을 한칸씩 앞으로 당겨준다.
    >
    > 삽입시 : 해당 원소를 삽입하기 위하여 해당 위치에 해당하는 원소들을 포함한 뒤에 위치한 원소들을 한칸씩 뒤로 밀어준 뒤에 해당 원소를 삽입한다.

* List
  * 물리적 저장순서와 논리적 저장순서가 일치하지 않는다.
  * root를 통한 순차접근을 통한 `O(n)`만에 서치 가능하다.
  * 삭제/삽입 시 해당 원소에 대한 작업을 마친 뒤에 앞뒤 원소를 연결만 해주면 되므로 `O(1)`만에 가능
* ArrayList
  * Array와 같은 메커니즘으로 동작하기 때문에 index를 통한 접근이 가능
  * capacity를 넘어갈 경우 capacity를 1.5배 늘린 새로운 ArrayList를 생성한 뒤에 깊은 복사를 통해 가져온다.

# Stack & Queue

* Stack
  * 선형 자료구조의 일종으로 LIFO(Last In, First Out)방식으로 원소를 다룸.
  * 대표적인 알고리즘 : DFS, 오큰수
* Queue
  * 선형 자료구조의 일종으로 FIFO(First In, First Out)방식으로 원소를 다룸.
  * 대표적인 알고리즘 : BFS

# Tree

* 비선형 자료구조

* 계층에 따라서 부모노드와 자식노드로 나뉘어 짐.

* 트리 구성 요소

  * Node : Tree를 구성하고 있는 각각의 원소

  * Edge : Node들 간의 연결

  * Root Node : 최상의 계층의 Node

  * Terminal(Leaf) Node : 자식을 가지지 않는 Node

  * Internal Node : 자식을 가지고 있는 Node

* Tree 종류

  * Binary Tree(이진트리)

    * Node들이 최대 2명의 자식을 가짐. 

    * Binary Tree 종류

      > Perfect Binary Tree(포화 이진트리) : 모든 레벨이 Node들로 꽉찬 상태
      >
      > Complete Binary Tree(완전 이진트리) : Node들이 위에서 아래로 왼쪽에서 오른쪽으로 순서대로 채워진 상태
      >
      > Full Binary Tree(정 이진트리) : 모든 Node들이 자식이 둘다 있거나 아예 없는 상태

  * Binary Search Tree(이진탐색트리)

    * 효율적인 탐색을 위한 Binary Tree의 특징을 가진 Tree구조

    * 규칙

      > 규칙1 : 모든 Node들의 키값은 유일함
      >
      > 규칙2 : 모든 Node들의 왼쪽 자식은 부모 Node 보다 작음
      >
      > 규칙3 : 모든 Node들의 오른쪽 자식은 부모 Node 보다 큼
      >
      > 규칙4 : Binary Search Tree의 Sub Tree도 Binary Search Tree임

    * 탐색의 경우 평균적으로 `O(log n)`의 시간복잡도를 가짐
    * Node들이 한쪽 방향으로 쏠릴 경우 `O(n)`의 시간복잡도를 가지게 됨
    * 위의 단점을 보안하기 위해 Rebalancing 등장

  * Balanced Binary Search Tree

    * Binary Search Tree의 단점을 보안하기 위해 등장

# Trie

* 문자열을 빠르게 탐색하기 위한 자료구조
* 주어진 문자열을 가져온 뒤에 현재 문자로 이루어진 노드가 존재한다면 해당 노드를 이용하여 그 다음 문자열을 탐색하고 존재하지 않을 경우 해당 문자열에 해당하는 노드를 생성 한 뒤에 해당 노드를 통해 다음 문자열을 탐색하는 작업을 문자열의 마지막까지 반복
* [Trie를 이용한 문제](https://github.com/kimry/TIL/tree/master/BOJ/2018%20kakao%20%5B3%EC%B0%A8%5D)

# Heap

* 우선순위 큐를 위하여 만들어진 자료구조

* Complete Binary Tree 구조

* 느슨한 정렬 상태(계층단위로 정렬) => 같은 계층사이에는 정렬이 되어 있지 않음

* Heap의 종류

  >Max Heap : 큰 순서로 계층들이 정렬
  >
  >Min Heap :  작은 순서로 계층들이 정렬

# Hash Table

* hashcode를 인덱스로 이용하여 빠른 검색 가능 / 시간복잡도 : O(1)
* Collision 해결법
  * Open Address
  * Separate Chaining
    * Linked List 사용
    * Tree 사용

