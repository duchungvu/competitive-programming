#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef long double ld;
 
typedef pair<int,int> pi;
typedef pair<ll,ll> pl; 
typedef pair<ld,ld> pd; 
 
typedef vector<int> vi; 
typedef vector<ll> vll; 
typedef vector<ld> vd; 
typedef vector<pi> vpi;
typedef vector<pl> vpll; 
typedef vector<pd> vpd;

void update(vector<ll> &t, int x, int val) {
    for (; x < t.size(); x |= (x + 1)) {
        t[x] += val;
    }
}

ll sum(vector<ll> &t, int x) {
    ll ret = 0;
    for (; x < t.size(); x = (x & (x + 1)) - 1) {
        ret += t[x];
    }
    return ret;
}

int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    // cout << endl;
    cin >> n;
    vpi a(n);
    vi vs(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i].first;
    }
    for (int i = 0; i < n; i++) {
        cin >> a[i].second;
        vs[i] = a[i].second;
    }

    sort(a.begin(), a.end());
    sort(vs.begin(), vs.end());

    // coordinate decompression
    vs.resize(unique(vs.begin(), vs.end()) - vs.begin());

    // Fenwick tree, cnt to count vj < vi, xs for sum(xj) that vj < vi
    vll cnt(vs.size()), xs(vs.size());

    // only count xj < xi, and vi < vj
    // add cnt(xj) * xi - sum(xj) to res
    ll res = 0;
    for (int i = 0; i < n; i++) {
        int pos = lower_bound(vs.begin(), vs.end(), a[i].second) - vs.begin();
        res += sum(cnt, pos) * a[i].first - sum(xs, pos);
        update(cnt, pos, 1);
        update(xs, pos, a[i].first);
    }
    cout << res << endl;
    return 0;
}       