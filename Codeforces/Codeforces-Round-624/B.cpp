#include <bits/stdc++.h>
using namespace std;

#define maxn 110

int t, n, m, a[maxn];
bool p[maxn];

void sort() {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
            if (a[j] > a[j + 1]) {
                if (p[j + 1]) {
                    int tmp = a[j];
                    a[j] =  a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
    for (int i = 0; i < n - 1; i++) {
        if (a[i] > a[i + 1]) {
            // cout << a[i] << " ";
            cout << "NO" << endl;
            return;
        }
    }
    cout << "YES" << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        memset(p, false, sizeof(p));
        cin >> n >> m;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        for (int i = 0; i < m; i++) {
            int x;
            cin >> x;
            p[x] = true;
        }
        sort();
    }
    return 0;
}