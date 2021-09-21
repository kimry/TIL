# 17298번: 오큰수
[문제 링크](https://www.acmicpc.net/problem/17298)

이 문제를 처음 봤을 때는 이중 반복문을 통한 해결책 말고는 생각해 내지 못했었다.

그러다가 우연히 이 문제를 다시보고 유형을 살펴보니 '어? 스택이라고...?' 생각하자마자 바로 풀었던 기억이 있다.

유형을 안다는것 만으로도 엄청난 도움이 된다는걸 새삼 느낀 문제였다.

해결 방법은 간단하다.

숫자를 받아서 스택에 넣어놨다가 자기보다 큰 수가 나오면 해당 위치에 큰 숫자를 넣어준다.

그리고 마지막에 스택에 여전히 남아있는 숫자에 해당하는 위치에 -1을 넣어주면 된다.



현재 과거에 짰던 소스들을 리뷰하는 형식으로 github에 저장하고 있는데 가끔 ''왜 이렇게 짰지?' 하는 의미를 모르겠는 부분들을 많이 찾을 수 있어서 리뷰하는 겸 수정작업 역시 거치고 있다.

이 문제가 특히 그런 부분이 심했는데 정말로 의미를 알 수 없는 부분들이 많아서 다 지워주고 나니 속도가 1.5배는 빨라졌다.

도데체 무슨생각을 하고 짠건지 모르겠다;; 



c/c++

``` c++
#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;
int stack[1000002][2];
int sol[1000001];
int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0), cout.tie(0);
	int n;
	int tail = 0;
	cin>>n;
	for (int i = 0; i < n; i++)
	{
		int temp;
		cin>>temp;
		while (tail != 0)
		{
			if (stack[tail - 1][1] < temp)
			{
				sol[stack[tail - 1][0]] = temp;
				tail--;
			}
			else
			{
				break;
			}
		}
		stack[tail][0] = i;
		stack[tail][1] = temp;
		tail++;
	}
	while (tail != 0)
	{
		sol[stack[tail - 1][0]] = -1;
		tail--;
	}
	for (int i = 0; i < n; i++)
	{
		cout<<sol[i]<<" ";
	}
}
```

