# 2239번: 스도쿠
[문제 링크](https://www.acmicpc.net/problem/2239)

전형적인 백트래킹 문제 중 하나라고 생각한다.

빈칸마다 현재상황에서 넣을 수 있는 모든 수를 넣어주면서 채워나간다. 출력에 사전식 우선이라는 조건이 있으니 작은 수인 1~9순서로 채워나가야 한다.

c/c++

``` c++
#include<iostream>
#include<unordered_map>
#include<string>
using namespace std;
int map[9][9];
int check = 0;
void dfs(int x, int y)
{
	if (x == 9)
	{
		check = 1;
		return;
	}
	else
	{
		if (map[x][y] == 0)
		{
			for (int i = 1; i <= 9; i++)
			{
				int c = 0;
				for (int j = 0; j < 9; j++)
				{
					if (map[x][j] == i || map[j][y] == i||map[(x/3)*3+(j/3)][(y / 3) * 3 + (j % 3)]==i)
					{
						c = 1;
						break;
					}
				}
				if (c == 0)
				{
					map[x][y] = i;
					dfs(x + (y + 1) / 9, (y + 1) % 9);
					if (check == 1)
					{
						return;
					}
					map[x][y] = 0;
				}
			}
		}
		else
		{
			dfs(x + (y + 1) / 9, (y + 1) % 9);
		}
	}
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	for (int i = 0; i < 9; i++)
	{
		string temp;
		cin >> temp;
		for (int j = 0; j < 9; j++)
		{
			map[i][j] = temp[j] - '0';
		}
	}
	dfs(0, 0);
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cout << map[i][j];
		}
		cout << "\n";
	}
}
```

