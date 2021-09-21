# 2638번: 치즈
[문제 링크](https://www.acmicpc.net/problem/2638)

초등학생때 정올을 준비하면서 DFS/BFS의 개념을 배울 때 미로찾기와 함께 풀어봤던 기억이 난다.

풀이는 간단하다. 가장자리가 비어있기 때문에 0,0부터 시작해서 완전탐색을 통해 0일 경우 이동하고, 1일 경우 2로 바꿔서 탐색이 끝난뒤 2를 모두 지워 겉부분을 하나씩 배껴내면서 문제를 풀어주면 된다.

c/c++

``` c++
#include<iostream>
#include<queue>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n, m;
	int map[200][200];
	int map2[200][200] = { 0, };
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			cin >> map[i][j];
		}
	}
	for (int i = 0; i <= n + 1; i++)
	{
		map[i][0] = map[i][m + 1] = -1;
	}
	for (int i = 0; i <= m + 1; i++)
	{
		map[0][i] = map[n + 1][i] = -1;
	}
	int cnt = 0;
	int dir[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
	while (1)
	{
		int check = 0;
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (map[i][j] == 1)
				{
					check = 1;
					break;
				}
			}
			if (check == 1)
			{
				break;
			}
		}
		if (check == 0)
		{
			break;
		}
		cnt++;
		queue<pair<int, int>> que;
		que.push({ 1,1 });
		map[1][1] = -1;
		while (!que.empty())
		{
			int x, y;
			x = que.front().first;
			y = que.front().second;
			que.pop();
			for (int i = 0; i < 4; i++)
			{
				if (map[x + dir[i][0]][y + dir[i][1]] == 0)
				{
					map[x+dir[i][0]][y+dir[i][1]] = -1;
					que.push({ x + dir[i][0], y + dir[i][1] });
				}
				else if (map[x + dir[i][0]][y + dir[i][1]] == 1)
				{
					map2[x + dir[i][0]][y + dir[i][1]]++;
				}
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (map[i][j] == -1 || map2[i][j] >= 2)
				{
					map[i][j] = 0;
				}
				map2[i][j] = 0;
			}
		}
	}
	cout << cnt;
}
```

