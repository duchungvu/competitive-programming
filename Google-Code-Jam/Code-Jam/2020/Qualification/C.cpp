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

const int maxn = 1000+10;
int t, n, idx[maxn];
char res[maxn];
pi a[maxn];

bool cmp1(const pi& x, const pi& y) {
    return x.first < y.first;
}
bool cmp2(int x, int y) {
    return a[x].first < a[y].first;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    for (int o = 1; o <= t; o++) {
        cin >> n;
        for (int i = 0; i < n; i++) {
            int x, y;
            cin >> x >> y;
            a[i].first = x;
            a[i].second = y;
            idx[i] = i;
        }
        sort(idx, idx + n, cmp2);
        sort(a, a + n, cmp1);
        int c = 0, j = 0;
        bool found = true;
        for (int i = 0; i < n; i++) {
            if (c <= a[i].first) {
                c = a[i].second;
                res[idx[i]] = 'C';
            } else if (j <= a[i].first) {
                j = a[i].second;
                res[idx[i]] = 'J';
            } else {
                found = false;
                break;
            }
        }
        cout << "Case #" << o << ": ";
        if (found) {
            for (int i = 0; i < n; i++) cout << res[i];
        } else
            cout << "IMPOSSIBLE";
        cout << endl;
    }
    return 0;
}