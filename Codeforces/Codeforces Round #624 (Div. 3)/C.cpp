#include <bits/stdc++.h>
using namespace std;

#define maxn 200010

int t, n, m, a[maxn], b[maxn], c[26], res[26];
string s;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        memset(b, 0, sizeof(b));
        memset(c, 0, sizeof(c));
        memset(res, 0, sizeof(res));
        cin >> n >> m >> s;
        for (int i = 0; i < m; i++) {
            int x;
            cin >> x;
            b[x - 1]++;
        }
        sort(a, a + m);
        for (int i = 0; i < n; i++) {
            c[s[i] - 'a']++;
            for (int j = 0; j < 26; j++) {
                res[j] += c[j] * b[i];
            }
        }
        for (int i = 0; i < 26; i++) cout << res[i] + c[i] << " ";
        cout << endl;
    }
    return 0;
}