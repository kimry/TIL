# 1799번: 비숍
[문제 링크](https://www.acmicpc.net/problem/1799)

N-QUEEN과 같은 문제라고 생각했고 그렇기 때문에 쉬운 문제라고 생각했지만 일반적인 백트랙킹을 이용한 풀이로는 시간초과가 나왔다.

N-QUEEN에서는 같은 라인에 말을 둘 수 없지만 비숍의 경우 같은 라인에 여러개가 들어갈 수 있다는게 꽤 크리티컬하고 작용했다고 생각한다.

이번문제의 경우는 꽤 고심을 했던 것 같다. 여러번 시도를 해 보았고 결국 혼자힘으로는 해결하지 못하고 풀이를 보았는데 해결법이 생각보다 간단하여 당황스러웠던 기억이 있다.

해결법은 간단했다. 비숍은 대각선으로만 움직이기 때문에 검은 칸에서는 검은 칸, 흰색칸에서는 흰색칸으로 밖에 움직이지 못한다. 그말은 흰색칸 위에 있는 말과 검은 칸 위에 있는 말은 서로 독립된 개체가 된다는 말과 같다.

그렇기 때문에 흰색칸과 검은색 칸을 따로 계산해 주면 데이터가 하나 늘어날때 마다 기하급수적으로 시간이 늘어나는 백트래킹의 특성상 시간을 획기적으로 줄여줄 수 있는 것이다.

알고리즘 난이도에 비해 골드1을 받은게 그냥 받은 것은 아니구나라는 생각이 들었다. 이런 순간적인 센스가 필요한 문제는 항상 어렵고 더 많은 문제들을 풀어봐야겠다는 생각이 든다.   

c/c++

``` c++
#include<iostream>
#include<vector>
using namespace std;
int map[10][10];
int visit1[20];
int visit2[20];
int m;
int n;
vector<pair<int, int>> point1;
vector<pair<int, int>> point2;
void dfs1(int s, int end, int cnt)
{
	for (int i = s; i < end; i++)
	{
		if (end - i + cnt - 1 < m)
		{
			break;
		}
		int x = point1[i].first;
		int y = point1[i].second;
		if (visit1[n - 1 - x + y] == 0 && visit2[x + y] == 0)
		{
			visit1[n - 1 - x + y] = 1;
			visit2[x + y] = 1;
			dfs1(s + 1, end, cnt + 1);
			visit1[n - 1 - x + y] = 0;
			visit2[x + y] = 0;
		}
	}
	if (m < cnt)
	{
		m = cnt;
	}
}
void dfs2(int s, int end, int cnt)
{
	for (int i = s; i < end; i++)
	{
		if (end - i + cnt - 1 < m)
		{
			break;
		}
		int x = point2[i].first;
		int y = point2[i].second;
		if (visit1[n - 1 - x + y] == 0 && visit2[x + y] == 0)
		{
			visit1[n - 1 - x + y] = 1;
			visit2[x + y] = 1;
			dfs2(s + 1, end, cnt + 1);
			visit1[n - 1 - x + y] = 0;
			visit2[x + y] = 0;
		}
	}
	if (m < cnt)
	{
		m = cnt;
	}
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 1)
			{
				if ((i + j) % 2 == 0)
				{
					point1.push_back({ i,j });
				}
				else
				{
					point2.push_back({ i,j });
				}
			}
		}
	}
	int answer = 0;
	dfs1(0, point1.size(), 0);
	answer = m;
	m = 0;
	dfs2(0, point2.size(), 0);
	cout << answer + m;
}
