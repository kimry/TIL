# 1012번: 유기농 배추
[문제 링크](https://www.acmicpc.net/problem/1012)

전형적인 dfs/bfs를 이용한 길찾기 문제라고 생각한다.

문제 풀이는 간단하다.

전체 밭을 0,0부터 탐색하여 배추가 있을 경우 완전탐색(아래 코드에는 dfs 사용)을 통해 배추를 모두 지워준 뒤에 cnt를 증가시켜 주면 된다.

이럴 경우 덩어리를 발견할때마다 해당 덩어리의 배추들을 모두 삭제해 주기 때문에 중복되지 않게 결과값을 찾아낼 수 있다.

c/c++

``` c++
#include<iostream>
using namespace std;
int map[60][60];
void dfs(int x,int y)
{
	int dir[4][2] = { {0,1},{1,0}, {-1,0}, {0,-1} };
	map[x][y] = 0;
	for (int i = 0; i < 4; i++)
	{
		if (map[x + dir[i][0]][y + dir[i][1]] == 1)
		{
			dfs(x + dir[i][0], y + dir[i][1]);
		}
	}
}
int main()
{
	int t;
	cin >> t;
	for (int k = 0; k < t; k++)
	{
		int n,m,c;
		cin >> m>>n>>c;
		for (int i = 0; i <= m + 1; i++)
		{
			map[0][i] = map[n + 1][i] = (-1);
		}
		for (int i = 0; i <= n + 1; i++)
		{
			map[i][0] = map[i][m+1] = (-1);
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1;j<=m;j++)
			{
				map[i][j] = 0;
			}
		}
		for (int i = 0; i < c; i++)
		{
			int x, y;
			cin >> y >> x;
			map[x+1][y+1] = 1;
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (map[i][j] == 1)
				{
					dfs(i, j);
					cnt++;
				}
			}
		}
		cout << cnt << "\n";
	}
}
