# 1011번: Fly me to the Alpha Centauri
[문제 링크](https://www.acmicpc.net/problem/1011)

처음 시작은 0이며, 이동시에 k-1, k, k+1만큼 이동이 가능하다.

위의 조건을 이용하여 각 작동횟수마다 최대 이동가능 경로를 구해보면

1

1 1

1 2 1

1 2 2 1

1 2 3 2 1

이런식으로 1,1,2,2,3...씩 증가하는것을 볼 수 있다.

그렇기 때문에 이동해야 하는 거리 d를 x-y로 구한뒤에 d값이 작동횟수의 최대값보다 작거나 같을 경우까지 구해 주면 쉽게 결과값을 구해줄 수 있다. 

c/c++

``` c++
#include<iostream>
#include<string>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	long long x, y, n, d, sum;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> x >> y;
		d = y - x;
		sum = 0;
		for (int i = 1;; i++)
		{
			sum += i;
			if (sum >= d)
			{
				cout << i * 2 - 1 << "\n";
				break;
			}
			sum += i;
			if (sum >= d)
			{
				cout << i * 2 << "\n";
				break;
			}
		}
	}
}
