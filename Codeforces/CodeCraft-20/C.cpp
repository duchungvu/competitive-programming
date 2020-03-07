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

#define maxn 1000005

int n, m, p, a[maxn], b[maxn];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m >> p;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    int ak = 0;
    int bk = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] % p != 0) {
            ak = i;
            break;
        }
    }
    for (int i = 0; i < m; i++) {
        if (b[i] % p != 0) {
            bk = i;
            break;
        }
    }
    cout << ak + bk << endl;
    return 0;
}