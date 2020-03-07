#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

#define maxn 100005

int n, p, k, a[maxn], s[maxn][8], idx[maxn];
ll dp[maxn][129];

bool cmp(int x, int y) {
    return a[x] > a[y];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> p >> k;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++)
    for (int j = 0; j < p; j++) cin >> s[i][j];
    for (int i = 1; i <= n; i++) idx[i] = i;
    sort(idx + 1, idx + n + 1, cmp);
    int res = 0;
    memset(dp, -1, sizeof(dp));
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
        int pos = idx[i];
        for (int mask = 0; mask < (1 << p); mask++) {
            int cnt = 0;
            for (int j = 0; j < p; j++)
                if (mask & (1 << j))
                    cnt++;
                    
            // choose i as audience
            if (dp[i - 1][mask] != -1)
            dp[i][mask] = i - 1 - cnt >= k ? dp[i - 1][mask] : dp[i - 1][mask] + a[pos];

            // choose i as player on position j
            for (int j = 0; j < p; j++) {
                if (mask & (1 << j) && dp[i - 1][mask ^ (1 << j)] != -1) {
                    dp[i][mask] = max(dp[i][mask], dp[i - 1][mask ^ (1 << j)] + s[pos][j]);
                }
            }
        }
    }
    cout << dp[n][(1 << p) - 1] << endl;
    return 0;
}