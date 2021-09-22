# 9663번: N-Queen
[문제 링크](https://www.acmicpc.net/problem/9663)

전형적인 백트랙킹 문제다.

Queen의 특성상 말의 위치를 기준으로 십자가와 대각선 방향으로 말을 놓을 수 없기 때문에 한줄에 하나를 채우게 되면 바로 다음 줄로 넘어가서 탐색을 해주면 된다.

그런식으로 완전탐색을 해주면 한줄에 한개는 무조건 채워야 되므로 n개를 채웠을때 ans을 증가시켜주면 쉽게 결과값을 구해낼 수 있다.

c/c++

``` c++
#include<iostream>
using namespace std;
int ans;
int chess[16][16];
void dfs(int cnt, int n)
{
	if (cnt == n)
	{
		ans++;
	}
	else
	{
		for (int i = 0; i < n; i++)
		{
			int check = 0;
			for (int j = 1; j <=cnt; j++)
			{
				if (chess[cnt - j][i - j] != 0 && (cnt - j >= 0 && i - j >= 0))
				{
					check = 1;
					break;
				}
				if (chess[cnt - j][i] != 0 && cnt - j >= 0)
				{
					check = 1;
					break;
				}
				if (chess[cnt - j][i + j] != 0 && (cnt - j >= 0 && i + j < n))
				{
					check = 1;
					break;
				}
			}
			if (check == 0)
			{
				chess[cnt][i] = 1;
				dfs(cnt + 1, n);
				chess[cnt][i] = 0;
			}
		}
	}
}
int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n;
	cin>>n;
	dfs(0,n);
    cout<<ans;
}
```

