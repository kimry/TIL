# 1753번: 최단경로
[문제 링크](https://www.acmicpc.net/problem/1753)

다액스트라 알고리즘을 사용했다.

다엑스트라 알고리즘은 시작점부터 연결된 노드들 중에 새로운 노드를 연결하는 가장 작은 가중치를 가지는 노드를 연결해주는 방식의 알고리즘으로 최단경로를 구하는데 사용된다.

처음 구현시에는 연결된 모든 노드들과 연결된 노드들의 가중치를 전부 탐색하는 방식을 사용했는데 시간초과가 나왔다. 이 구조 안에서 시간을 줄여보는 방식으로 여러번 시도를 하다가 도저히 해결되지 않아서 질문을 검색해보니 우선순위 큐를 사용하면 쉽게 구할 수 있다는 것을 알았다.

우선순위 큐의 개념은 알고 있었지만 실제로 문제를 풀때 사용해 보는 것은 처음이었는데 생각보다 쉬웠고 편리했다. 이 문제에서는 아무래도 처음 사용해보는 자료구조이다 보니 어떤식으로 저장을 해야 좋을지 고민을 좀 했었는데 어느정도 익숙해 지고 난 뒤에는 다른 문제를 풀때도 무리없이 사용했던 것 같다. 물론 이 문제도 우선순위 큐를 이용한 덕분에 가장 작은 가중치의 노드를 찾는 시간 자체를 없애버렸기 때문에 원하는 결과를 얻을 수 있었다.

c/c++

``` c++
#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int weight[20002];
int visit[20002];

vector<pair<int,int>> map[20002];

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n, m;
	cin >> n >> m;
	int start;
	cin >> start;
	for (int i = 0; i < m; i++)
	{
		int s, e, w;
		cin >> s >> e >> w;
		map[s].push_back({ w, e });
	}
	priority_queue<pair<int,int>> que;
	que.push({ 0,start });
	while (!que.empty())
	{
		int point = que.top().second;
		visit[point] = 1;
		que.pop();
		for (int i = 0; i < map[point].size(); i++)
		{
			if (visit[map[point][i].second] == 0 && (weight[map[point][i].second] > map[point][i].first + weight[point] || weight[map[point][i].second] == 0))
			{
				weight[map[point][i].second] = map[point][i].first + weight[point];
				que.push({ -weight[map[point][i].second],map[point][i].second });
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		if (visit[i] == 0)
		{
			cout << "INF\n";
		}
		else
		{
			cout << weight[i] << "\n";
		}
	}
}
```

