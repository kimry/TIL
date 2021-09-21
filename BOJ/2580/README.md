# 2580번: 스도쿠
[문제 링크](https://www.acmicpc.net/problem/2580)

2239번 문제랑 입력 방식만 다를뿐 똑같은 문제다.

[2239번 리뷰 링크](https://github.com/kimry/TIL/tree/master/BOJ/2239)

2580을 옛날에 풀고 2239를 최근에 풀었는데 서로 비교를 해보니 확실히 최근에 짠 소스가 간결하고 최적화가 잘되어있다는 느낌을 받았다.

현재 올린 코드는 원래 있던 코드가 아닌 예전에 올렸던 코드를 입력방식만 2580에 맞춰서 다시 체점한 코드인데 역시 잘 돌아간다.

예전에 비해 확실히 깔끔하게 코딩하는 습관이 든 것 같다.

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
		for (int j = 0; j < 9; j++)
		{
			cin>>map[i][j];
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

