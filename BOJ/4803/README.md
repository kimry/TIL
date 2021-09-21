# 4803번: 트리
[문제 링크](https://www.acmicpc.net/problem/4803)

트리는 싸이클이 생기면 안된다. 그렇기 때문에 이 부분에 유의해서 문제를 풀어주면 된다.

방문하지 않았던 노드를 시작으로 탐색을 해서 해당 노드와 연결된 모든 노드들이 싸이클을 생성하는지 확인해 준다. 그리고 방문처리를 해준 뒤 마지막에 싸이클의 생성 여부를 통해 cnt를 증가 시켜주면된다.

탐색을 통해 방문처리된 노드들은 시작점을 찾을 때 걸러지므로 중복되지 않게 모든 트리의 개수를 구할 수 있다. 

c/c++

``` c++
#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int z = 1;
	while (1)
	{
		int n, m;
		vector<int> map[600];
		int visit[600] = { 0, };
		cin >> n >> m;
		if (n == 0 && m == 0)
		{
			break;
		}
		for (int i = 0; i < m; i++)
		{
			int u, v;
			cin >> u>> v;
			map[u].push_back(v);
			map[v].push_back(u);
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++)
		{
			if (visit[i] == 0)
			{
				queue<pair<int,int>> que;
				int check = 0;
				que.push({ i,-1 });
				visit[i] = 1;
				while (!que.empty())
				{
					int point = que.front().first;
					int parent = que.front().second;
					que.pop();
					for (int j = 0; j < map[point].size(); j++)
					{
						if (visit[map[point][j]] == 0)
						{
							visit[map[point][j]] = 1;
							que.push({ map[point][j],point });
						}
						else if (parent != map[point][j])
						{
							check = 1;
						}
					}
				}
				if (check == 0)
				{
					cnt++;
				}
			}
		}
		if (cnt == 0)
		{
			cout << "Case "<<z<<": No trees.\n";
		}
		else if (cnt == 1)
		{
			cout << "Case "<<z<<": There is one tree.\n";
		}
		else
		{
			cout << "Case "<<z<<": A forest of " << cnt << " trees.\n";
		}
		z++;
	}
}
```

