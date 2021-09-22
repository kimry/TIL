# 5430번: AC
[문제 링크](https://www.acmicpc.net/problem/5430)

사실 이번 문제를 풀면서 deque라는 자료구조가 존재하는지 처음 알았다. 사실 deque를 굳이 사용하지 않아도 풀 수 있는 문제지만 굳이 deque문제를 풀면서 deque를 사용하지 않을 이유가 없기 때문에 공부할 겸 deque를 이용해서 풀었다.

문제는 상당히 쉽다.

R로 뒤집힐 때마다 모드를 바꿔줘서 MOD=0이면 앞을 빼주고 MOD=1이면 뒤를 빼주는 식으로 풀었다.



c/c++

``` c++
#include<iostream>
#include<deque>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int m;
		string code;
		string temp;
		cin >> code;
		cin >> m;
		cin >> temp;

		deque<int> deq;
		int num=0;
		for (int j = 0; j < temp.size(); j++)
		{
			if (temp[j] >= '0' && temp[j] <= '9')
			{
				num *= 10;
				num += temp[j] - '0';
			}
			else if (temp[j] != '[')
			{
				deq.push_back(num);
				num = 0;
			}
		}
		int mode = 0;
		for (int j = 0; j < code.size(); j++)
		{
			if (code[j] == 'R')
			{
				if (mode == 0)
				{
					mode = 1;
				}
				else
				{
					mode = 0;
				}
			}
			else
			{
				if (m == 0)
				{
					m--;
					break;
				}
				if (mode == 0)
				{
					deq.pop_front();
				}
				else
				{
					deq.pop_back();
				}
				m--;
			}
		}
		if (m >= 0)
		{
			cout << "[";
			if (mode == 0)
			{
				for (int j = 0; j < m-1; j++)
				{
					cout << deq.front() << ",";
					deq.pop_front();
				}
				if (m != 0)
				{
					cout << deq.front();
				}
			}
			else
			{
				for (int j = m-1; j > 0; j--)
				{
					cout << deq.back() << ",";
					deq.pop_back();
				}
				if (m != 0)
				{
					cout << deq.back();
				}
			}
			cout << "]\n";
		}
		else
		{
			cout << "error\n";
		}
	}
}
```

