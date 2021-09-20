# 12015번: 가장 긴 증가하는 부분 수열2
[문제 링크](https://www.acmicpc.net/problem/12015)

LIS알고리즘을 공부한 뒤에는 쉽게 풀어냈던 것 같다.

LIS알고리즘을 간단하게 정리하자면 solution배열(sol)에 가장 마지막과 비교하여 클 경우에는 해당값을 추가해주고 작을 경우에는 이분탐색을 이용해 적당한 위치에 값과 바꿔넣어준다.

이럴 경우 sol배열에 해당위치에서의 최적의 값들이 저장되기 때문에 마지막에 sol배열의 사이즈값을 출력해 주면 문제를 해결 할 수 있다.

c/c++

``` c++
#include<iostream>
long n, m;
long low, high,mid;
long cnt;
long a[1000001];
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	cin >> n;
	cin >> m;
	a[0] = m;
	cnt++;
	for (int i = 1; i < n; i++)
	{
		cin >> m;
		if (a[cnt - 1] < m)
		{
			a[cnt] = m;
			cnt++;
		}
		else
		{
			int point = 0;
			low = 0;
			high = cnt - 1;
			while (low <= high)
			{
				mid = (low + high) / 2;
				if (a[mid] >= m)
				{
					high = mid - 1;
					point = mid;
				}
				else
				{
					low = mid + 1;
				}
			}
			a[point] = m;
		}
	}
	cout << cnt;
}	
