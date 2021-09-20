# 1655번: 가운데를 말해요.
[문제 링크](https://www.acmicpc.net/problem/1655)

문제 유형을 알았기 때문에 쉽게 풀 수 있었던 것 같다. 문제유형을 몰랐다면 과연 빠르게 풀어낼 수 있었을지 고민하게 되는 문제였다.

풀이 자체는 간단하다. 최소힙과 최대힙을 이용하여 최대힙에는 작은값들을 몰고 최소힙에는 큰값들을 몰아넣는다. 그렇게 되면 최대힙과 최소힙의 top값은 작은 값들 중에 가장 높은 값이고 높은 값들 중에 가장 낮은 값이기 때문에 중간값으로 형성된다.

그렇기 때문에 마지막에  항상 작거나 가운데 수인 최대힙의 top을 출력해주면 문제를 해결 할 수 있다.

c/c++

``` c++
#include<iostream>
#include<queue>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	priority_queue<int> max_que;
	priority_queue<int> min_que;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int m;
		cin >> m;
		if (max_que.size()==min_que.size())
		{
			max_que.push(m);
		}
		else
		{
			min_que.push(-m);
		}
		if (min_que.size()>=1)
		{
			if (max_que.top() > (-min_que.top()))
			{
				int temp;
				temp = max_que.top();
				max_que.pop();
				max_que.push(-min_que.top());
				min_que.pop();
				min_que.push(-temp);
			}
		}
		cout << max_que.top() << "\n";
	}
}
