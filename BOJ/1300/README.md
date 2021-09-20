# 1300번: K번째 수
[문제 링크](https://www.acmicpc.net/problem/1300)

이분탐색을 이용하면 쉽게 구할 수 있다.

mid일때 mid값이 포함할 수 있는 모든 수를 더해서 m값과 비교해 주면 되는데 mid값을 구하는 방법은 i*n<=mid일 경우, i행에 모든값이 mid보다 작으므로 cnt에 n을 더해주고 작을 경우에는 mid를 i로 나눈 갯수만큼 더해주어 총 갯수를 구하면 문제를 해결할 수 있다.

c/c++

``` c++
#include<iostream>
long n, m;
long low, high,mid;
long cnt;
long answer;
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	cin >> n;
	cin >> m;
	low = 1;
	high = n * n;
	while (low <= high)
	{
		cnt = 0;
		mid = (low + high) / 2;
		for (int i = 1; i <= n; i++)
		{
			if (n * i <= mid)
			{
				cnt += n;
			}
			else
			{
				cnt += mid / i;
			}
			if (cnt > m)
			{
				break;
			}
		}
		if (cnt >= m)
		{
			high = mid - 1;
			answer = mid;
		}
		else
		{
			low = mid + 1;
		}
	}
	cout << answer;
}	
