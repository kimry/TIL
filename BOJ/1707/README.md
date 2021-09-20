# 1707번: 이분 그래프
[문제 링크](https://www.acmicpc.net/problem/1707)

맨 처음 글로만 문제를 읽었을때 이분 그래프가 잘 이해가 안되서 고민을 했던 기억이 난다.

쉽게 설명하자면 노드들을 두가지 색깔만을 이용해서 색칠한다고 했을 때 노드들이 자신과 연결된 노드와 다른색깔을 가지도록 만들수 있는지를 묻는 문제였다.

문제를 이해한 뒤에는 쉽게 풀었던것 같다. bfs를 통한 완전탐색을 이용하였고 탐색과정에서 방문하지 않았다면 자신의 색깔과 반대대는 색깔을 넣고 방문처리를 해줬다. 만약 방문했었다면 현재 색깔과 비교하여 같을 경우 탐색을 종료하였고 다를 경우 계속해서 탐색을 이어가게 하는 방식으로 문제를 해결하였다. 

c/c++

``` c++
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int visit[20002];
int z, n, m, s, e;
int point;
int check;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	cin >> z;
	for (int i = 0; i < z; i++)
	{
		
		cin >> n >> m;
		vector<vector<int>> map(n+1);
		check = 0;
		queue<int> que;
		for (int j = 0; j < m; j++)
		{
			cin >> s >> e;
			map[s].push_back(e);
			map[e].push_back(s);
		}
		for (int k = 1; k <= n; k++)
		{
			if (visit[k] == 0)
			{
				que.push(k);
				visit[k] = 1;
				while (!que.empty())
				{
					point = que.front();
					que.pop();
					int color = visit[point];
					for (int j = 0; j < map[point].size(); j++)
					{
						if (visit[map[point][j]] == 0)
						{
							if (color == 1)
							{
								visit[map[point][j]] = 2;
							}
							else
							{
								visit[map[point][j]] = 1;
							}
							que.push(map[point][j]);
						}
						else if (visit[map[point][j]] == color)
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
				if (check == 1)
				{
					break;
				}
			}
		}
		if (check == 1)
		{
			cout << "NO\n";
		}
		else
		{
			cout << "YES\n";
		}
		for (int j = 1; j <= n; j++)
		{
			visit[j] = 0;
		}
	}
}
