# 1107번: 리모콘
[문제 링크](https://www.acmicpc.net/problem/1107)

dfs를 이용한 완전탐색으로 문제를 풀었다.

몇자리 수인지 확인하고 해당 자리수 만큼 입력 가능한 모든 수를 대입했다. 그 뒤에 원하는 값에서 만들어진 수를 빼서 최솟값을 가지는 값을 출력해줬다.

c/c++

``` c++
#include<iostream>
#include<string>
using namespace std;
int btn[11];
int answer;
int goal;
int n;
void dfs(int cnt, int value,int bc)
{
	if (cnt >= 0)
	{
		for (int i = 0; i <= 9; i++)
		{
			if (btn[i] == 0)
			{
				if (abs(value * 10 + i - goal) + bc < answer)
				{
					answer = abs(value * 10 + i - goal) + bc;
				}
				dfs(cnt - 1, value * 10 + i, bc+1);
			}
		}
	}
}
int main()
{
	int cnt=0;
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	cin >> goal;
	cin >> n;
	answer = abs(goal - 100);
	for (int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		btn[temp] = 1;
	}
	int temp = goal;
	if (goal != 0)
	{
		while (temp != 0)
		{
			cnt++;
			temp /= 10;
		}
	}
	else
	{
		cnt = 1;
	}
	dfs(cnt,0,1);
	cout << answer;
}
```

