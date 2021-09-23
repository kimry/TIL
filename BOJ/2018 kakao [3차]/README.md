# 2018 KAKAO BLIND RECRUITMENT [3차] 압축
[문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17684)

이 문제를 리뷰하는 이유는 트라이 자료구조를 처음 써봤기 때문이다.

트라이 자료구조를 사용하면 쉽고 빠르게 구할 수 있다. 보통 n^2의 시간복잡도를 가지는 방식으로 문제를 풀었는데 트라이 자료구조를 사용하면 n의 시간복잡도로 빠르고 쉽게 풀 수 있다.

c/c++

``` c++
#include <string>
#include <vector>

using namespace std;
typedef struct Node{
    int check[26];
    int num;
    Node *next[26];
}Node;
vector<int> solution(string msg) {
    vector<int> answer;
    Node* root = new Node;
    Node* temp;
    temp = root;
    int point = 0;
    int cnt = 27;
    for (int i = 0; i < 26; i++)
    {
        root->check[i] = 1;
        root->next[i] = new Node;
        root->next[i]->num = i + 1;
    }
    while (point != msg.size())
    {
        if (temp->check[msg[point] - 'A'] == 1)
        {
            temp = temp->next[msg[point] - 'A'];
        }
        else
        {
            answer.push_back(temp->num);
            temp->check[msg[point] - 'A']=1;
            temp->next[msg[point] - 'A'] = new Node;
            temp->next[msg[point] - 'A']->num = cnt++;
            temp = root->next[msg[point] - 'A'];
        }
        point++;
    }
    answer.push_back(temp->num);
    return answer;
}
```

