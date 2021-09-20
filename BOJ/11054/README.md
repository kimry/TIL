# 11054번: 가장 긴 바이토닉 부분 수열
[문제 링크](https://www.acmicpc.net/problem/11054)

이런류의 문제를 푸는 방법 중 가장 쉬운 방법인 DP를 이용하여 풀었다.

N의 최댓값이 1000이기 때문에 N^2의 시간복잡도를 가지고도 충분히 풀 수 있다고 생각 했고 정방향과 역방향의 최댓값을 동시에 구해서 해당위치에서의 두 방향의 최댓값을 더하고 해당위치가 겹치므로 1을 빼준 값을 max와 비교하여 최댓값을 구하였다.

c/c++

``` c++
#include<iostream>
#include<cmath>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	long long su[1001], ans[2][1001], n, max = -1;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> su[i];
	}
	ans[0][0] = 1;
	ans[1][n - 1] = 1;
	for (int i = 1; i < n; i++)
	{
		ans[0][i] = 1;
		ans[1][n - 1 - i] = 1;
		for (int j = 0; j < i; j++)
		{
			if (su[j]<su[i] && ans[0][j] + 1>ans[0][i])
			{
				ans[0][i] = ans[0][j] + 1;
			}
			if (su[n - 1 - j]<su[n - 1 - i] && ans[1][n - 1 - j] + 1>ans[1][n - 1 - i])
			{
				ans[1][n - 1 - i] = ans[1][n - 1 - j] + 1;
			}
		}
	}
	for (int i = 0; i < n; i++)
	{
		if (max < ans[0][i] + ans[1][i] - 1)
		{
			max = ans[0][i] + ans[1][i] - 1;
		}
	}
	cout << max;
}
