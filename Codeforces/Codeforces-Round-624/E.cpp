#include <bits/stdc++.h>
using namespace std;

#define maxn 5005

int t, n, d, dep[maxn], p[maxn], cnt[maxn];
bool highest[maxn];

bool solve() {
    // find the limits
    int l = 0;
    int r = n * (n - 1) / 2;
    int c = 0;
    for (int i = 1; i <= n; i++) {
        if (!(i & (i - 1))) c++;
        l += c - 1;
    }
    if (!(l <= d && d <= r)) return false;
    
    for (int i = 1; i <= n; i++) {
        p[i] = i - 1;
        dep[i] = i - 1;
        highest[i] = false;
        cnt[i] = 1;
    }

    cnt[n] = 0;
    int need = n * (n - 1) / 2 - d;
    while (need > 0) {
        int mind = n;
        int cur = -1;
        int par = -1;
        bool is_highest = true;
        for (int i = 1; i <= n; i++) {
            // find possible leaf
            if (!highest[i] && cnt[i] == 0 && dep[i] < mind) {
                cur = i;
                mind = dep[i];
            }
        }
        if (cur == -1) return false;
        // find posssible parent
        for (int i = 1; i <= n; i++) {
            if (cnt[i] < 2 && dep[i] == dep[cur] - 2) {
                par = i;
                break;
            }
        }
        // no parent = highest possible
        if (par == -1) {
            highest[cur] = true;
            continue;
        }
        need--;
        cnt[p[cur]]--;
        cnt[par]++;
        dep[cur]--;
        p[cur] = par;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> n >> d;
        if (solve()) {
            cout << "YES" << endl;
            for (int i = 2; i <= n; i++) {
                cout << p[i] << " ";
            }
            cout << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}