# 1005번: ACM Craft
[문제 링크](https://www.acmicpc.net/problem/1005)

선행되어야 하는 노드가 0개인 노드를 찾아서 해당 노드가 선행되어야 하는 노드들의 선행노드 cnt를  지워주는 방식으로 문제를 풀었다.

n이 최대 1000이었기 때문에 해당노드를 찾는데 n^2으로 충분히 커버 가능할 것이라고 생각했고 연결된 간선의 수가 최대 100,000이었기 때문에 추가로 10만번만 더 돌아가면 된다고 예상했다. 그렇기 때문에 시간초과 부분에 대해서는 문제가 없을것이라고 예상했고 예상대로 문제없이 결과값을 얻어낼 수 있었다.

나는 문제를 푼 뒤에 항상 소요시간이 적은 소스랑 문제를 푼 사람들이 올려놓은 질문들을 보는 습관이 있는데 이번 문제에서는 질문에 유독 위상정렬에 관한 내용이 많았다. 당시에 모르는 개념이었고 궁금해서 찾아봤는데 꽤 도움이 됐던것 같다.

확실히 위상정렬의 도움을 받는다면 해당노드를 찾는 n^2부분에 있어서 많은 도움을 받을 수 있었을거라고 생각한다.

c/c++

``` c++
#include<iostream>
#include<vector>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int z;
	cin >> z;
	for (int i = 0; i < z; i++)
	{
		int n, m;
		cin >> n >> m;
		int ready[1001] = { 0, };
		int times[1001] = { 0, };
		int sol[1001] = { 0, };
		vector<int> map[1001];
		for (int j = 1; j <= n; j++)
		{
			cin >> times[j];
		}
		for (int j = 0; j < m; j++)
		{
			int s, e;
			cin >> s >> e;
			map[s].push_back(e);
			ready[e]++;
		}
		for(int j=1;j<=n;j++)
		{
			int point;
			for (int k = 1; k <= n; k++)
			{
				if (ready[k] == 0)
				{
					point = k;
					break;
				}
			}
			for (int k = 0; k < map[point].size(); k++)
			{
				if (sol[map[point][k]] < sol[point] + times[point])
				{
					sol[map[point][k]] = sol[point] + times[point];
				}
				ready[map[point][k]]--;
			}
			ready[point]--;
		}
		int w;
		cin >> w;
		cout << sol[w]+times[w]<<"\n";
	}
}
```

