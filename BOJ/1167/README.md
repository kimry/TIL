# 1167번: 트리의 지름
[문제 링크](https://www.acmicpc.net/problem/1167)

가장 먼저 생각해낸 방식은 루트노드나 자식이 없는 노드에서 출발하여 최소값을 모두 찾아내는 방식이었는데 시간초과가 나왔다. 

확실히 노드가 10만개였고 트리의 특성상 최악의 경우 10만/2개의 노드를 탐색하여야 했고 탐색하는 과정에서 다시 10만번의 탐색이 필요하므로 n^2의 시간복잡도를 가지게 되서 무리가 있었다고 생각한다.

결국 생각해낸 해결법은 꽤 간단했는데 트리의 특성상 어느 지점에서 시작하더라도 최댓값을 가지는 노드가 가장 긴 지름을 가지는 트리의 노드 중 하나라는 사실이었다.(어느 한쪽으로 기울면 기운쪽의 반대편이 자동으로 최댓값을 가진다.)

그렇기 때문에 일단 임의의 시작점을 시작으로 최대값을 가지는 노드를 구한 뒤에 그 노드에서 다시한번 최댓값을 구하여 문제를 해결하였다.

c/c++

``` c++
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
typedef struct Node_{
	int p;
	int w;
}Node;
vector<Node> tree[100001];
int visit[100001];
long long m;
int pp;
void dfs(int point,int weight)
{
	if (tree[point].size() == 1)
	{
		if (m < weight)
		{
			m = weight;
			pp = point;
		}
	}
	else
	{
		for (int i = 0; i < tree[point].size(); i++)
		{
			if (visit[tree[point][i].p] == 0)
			{
				visit[tree[point][i].p] = 1;
				dfs(tree[point][i].p, weight + tree[point][i].w);
				visit[tree[point][i].p] = 0;
			}
		}
	}
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int a, b, c;
		cin >> a;
		while (1)
		{
			cin >> b;
			if (b == -1)
			{
				break;
			}
			cin >> c;
			tree[a].push_back({ b,c });
		}
	}
	visit[1] = 1;
	for (int i = 0; i < tree[1].size(); i++)
	{
		visit[tree[1][i].p] = 1;
		dfs(tree[1][i].p, tree[1][i].w);
		visit[tree[1][i].p] = 0;
	}
	visit[1] = 0;
	visit[pp] = 1;
	visit[tree[pp][0].p] = 1;
	dfs(tree[pp][0].p, tree[pp][0].w);
	cout << m;
}	
