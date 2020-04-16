#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef long double ld;

typedef pair<int,int> pi;
typedef pair<ll,ll> pll;
typedef pair<ld,ld> pd;

typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<ld> vd;
typedef vector<pi> vpi;
typedef vector<pll> vpll;
typedef vector<pd> vpd;

const int maxn = 110, lim = 10e4;
string a[maxn];

int t, n;

void solve(int o) {
    bool found = true;
    cin >> n;
    string res = "*";
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int l = 0; l < n; l++) {
        string s = a[l];
        int u = 0, v = 0;
        while (u < s.length() && v < res.length()) {
            if (s[u] != '*' && res[v] != '*') {
                if (s[u] == res[v]) {
                    u++;
                    v++;
                } else {
                    found = false;
                    break;
                }
            } else {
                if (s[u] == res[v]) break;
                if (s[u] != '*') u++;
                if (res[v] != '*') v++;
            }
        }
        int j = s.length() - 1;
        int k = res.length() - 1;
        while (j >= u && k >= v) {
            if (s[j] != '*' && res[k] != '*') {
                if (s[j] == res[k]) {
                    j--;
                    k--;
                } else {
                    found = false;
                    break;
                }
            } else {
                if (s[j] == res[k]) break;
                if (s[j] != '*') j--;
                if (res[k] != '*') k--;
            }
        }
        if (!found) {
            cout << "Case #" << o << ": " << "*" << endl;
            return;
        }
        string pre = u > v ? s.substr(0, u) : res.substr(0, v);
        string suf = s.length() - j > res.length() - k ? s.substr(j + 1, s.length()) : res.substr(k + 1, res.length());
        string mid = s.substr(u, j);
        string mid2 = res.substr(v, k);
        mid.erase(remove(mid.begin(), mid.end(), '*'), mid.end());
        mid2.erase(remove(mid2.begin(), mid2.end(), '*'), mid2.end());
        res = pre + "*" + mid + mid2 + "*" + suf;
    }
    res.erase(remove(res.begin(), res.end(), '*'), res.end());
    cout << "Case #" << o << ": " << res << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    int cnt = 1;
    while (t--) {
        solve(cnt);
        cnt++;
    }
    return 0;
}