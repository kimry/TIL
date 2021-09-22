# 2981번: 검문
[문제 링크](https://www.acmicpc.net/problem/2981)

v[i] = m \* temp[i] + r 라고 가정했을 때 

v[i] - v[i - 1] = m * (temp[i] - temp[i-1]) + (r - r)를 도출해 낼 수 있다.

저걸 조금만 더 변형 시킨다면

v[i] - v[i - 1] = a * b *(temp[i]-temp[i-1])로 만들 수 있다.

저 식을 통해서 a * b = m을 만드는 모든 수를 구하면 원하는 결과값을 얻어낼 수 있다.



c/c++

``` c++
#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	long long num[200];
	vector<long long> answer;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> num[i];
	}
	sort(num, num + n);
	long long sol = num[n - 1] - num[0];
	for (int i = n-1; i >=1; i--)
	{
		for (int j = 0; j < i; j++)
		{
			long long r = num[i] - num[j];
			while (r!=0)
			{
				long long temp=sol;
				sol = r;
				r = temp % r;
			}
		}
	}
	for (int i = 2; i*i<=sol; i++)
	{
		if (sol % i == 0)
		{
			answer.push_back(i);
			if (i != sol / i)
			{
				answer.push_back(sol / i);
			}
		}
	}
	sort(answer.begin(), answer.end());
	for (int i = 0; i < answer.size(); i++)
	{
		cout << answer[i] << " ";
	}
	cout << sol;
}
```

