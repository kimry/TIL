# 1967번: 트리의 지름
[문제 링크](https://www.acmicpc.net/problem/1967)

루트노드와 자식노드가 없는 모든 노드들의 위치를 찾아서 해당 노드에서 시작하여 DFS를 이용한 완전탐색을 이용하여 풀었다.

N의 최댓값이 10,000으로 N^2을 돌리기에 충분히 작았다고 생각했고 예상한대로 결과값을 찾을 수 있었다. 

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
vector<Node> tree[10001];
int visit[10001];
int m;
void dfs(int point,int weight)
{
	if (tree[point].size() == 1)
	{
		if (m < weight)
		{
			m = weight;
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
	for (int i = 0; i < n-1; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		tree[a].push_back({ b,c });
		tree[b].push_back({ a,c });
	}
	for (int i = 1; i <= n; i++)
	{
		if (tree[i].size() == 1)
		{
			visit[i] = 1;
			visit[tree[i][0].p] = 1;
			dfs(tree[i][0].p, tree[i][0].w);
			visit[tree[i][0].p] = 0;
			visit[i] = 0;
		}
	}
	cout << m;
}	
