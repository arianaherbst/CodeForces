#include <iostream>
#include <algorithm>
using namespace std;
#include <stdio.h>
/*
 * Codeforces Round #415 Problem C: Do you want a date?
 * http://codeforces.com/contest/810/problem/C
 * Math, Prefix Sums
 * 5/21/17
 */
int main()
{
	long long MOD = 1e9+7;
	long long N;
	cin >> N;
	long long nums[N];
	
	for (int n = 0; n < N; n++) {
		scanf("%Ld", &nums[n]);
	}
	sort(nums, nums+N);
	
	long long prefix[N+1];
	prefix[0] = 0;
	for (int n = 1; n <= N; n++) {
		prefix[n] = prefix[n-1] + nums[n-1];
	}
	long long sum = 0;
	long long two = 1;
	long long bigSum, smallSum;
	for (int diff = 1; diff <=N-1; diff++) {
		bigSum = prefix[N]-prefix[diff];
		smallSum = prefix[N-diff];
		sum += (two * ((bigSum - smallSum)%MOD))%MOD;
		sum %=MOD;
		
		two <<= 1;
		two %= MOD;
	}
	cout << sum;
}
