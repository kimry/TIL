# 1197번: 최소 스패닝 트리
[문제 링크](https://www.acmicpc.net/problem/1197)

최소 스패닝 트리문제로 대표적으로 크루스칼과 프림 두가지 방법을 가지고 있다.

프림의 경우 연결되어져 있는 노드만을 대상으로 다음노드를 선정하기 때문에 다음노드가 이미 방문한 적이 있는 노드라면 싸이클이 형성된다고 확신할 수 있지만 크루스칼의 경우 랜덤으로 가장 작은 노드만을 뽑기 때문에 이미 방문을 한 노드의 경우에도 떨어져있다가 연결이 된건지 아니면 싸이클을 형성하는건지 확인하기 위한 작업을 해줘야 한다.

그래서 간선의 개수가 많을 경우에는 프림, 적을 겨우에는 크루스칼을 이용한다고 알고 있지만 위에서 말했다시피 크루스칼은 싸이클 확인 작업이 귀찮으므로 프림을 이용해서 문제를 풀었다.

c/c++

``` c++
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
vector<pair<int,int>> dir[10001];
int main()
{
	long long answer = 0;
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n, m;
	cin >> n >> m;
	int visit[10001] = { 0, };
	for (int i = 0; i < m; i++)
	{
		int s, e, w;
		cin >> s >> e >> w;
		dir[s].push_back({ w,e });
		dir[e].push_back({ w,s });
	}
	for (int i = 1; i <= n; i++)
	{
		sort(dir[i].begin(), dir[i].end());
	}
	visit[1] = 1;
	for (int z = 0; z < n - 1; z++)
	{
		int min = 1000001, point = 0;
		for (int i = 1; i <= n; i++)
		{
			if (visit[i] == 1)
			{
				while (dir[i].size() != 0 && visit[dir[i][0].second] != 0)
				{
					dir[i].erase(dir[i].begin());
				}
				if (dir[i].size() != 0 && visit[dir[i][0].second] == 0 && min > dir[i][0].first)
				{
					min = dir[i][0].first;
					point = dir[i][0].second;
				}
			}
		}
		visit[point] = 1;
		answer += min;
	}
	cout << answer;
}
