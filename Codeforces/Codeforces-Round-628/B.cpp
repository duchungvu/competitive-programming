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

const int maxn = 10e5 + 5;

int t, n, a[maxn];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; i++) cin >> a[i];
        sort(a, a + n);
        int cnt = 1;
        for (int i = 1; i < n; i++)  if (a[i] != a[i - 1]) cnt++;
        cout << cnt << endl;
    }
    return 0;
}