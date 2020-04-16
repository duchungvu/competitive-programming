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

const int maxn = 110;

int t, n, a[maxn][maxn];
bool checkr[maxn], checkc[maxn];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    for (int o = 1; o <= t; o++) {
        cin >> n;
        int k = 0, r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            k += a[i][i];
            memset(checkr, false, sizeof(checkr));
            memset(checkc, false, sizeof(checkc));
            for (int j = 0; j < n; j++) {
                checkr[a[i][j]] = true;
                checkc[a[j][i]] = true;
            }
            for (int j = 1; j <= n; j++) if (!checkr[j]) {r++; break;}
            for (int j = 1; j <= n; j++) if (!checkc[j]) {c++; break;}
        }
        cout << "Case #" << o << ": " << k << " " << r << " " << c << endl;
    }
    return 0;
} 