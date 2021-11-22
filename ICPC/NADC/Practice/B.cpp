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

int d, r, t;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> d >> r >> t;
    for (int i = 50; i >= 4; i--) {
        int true_r = (i + 4) * (i - 3) / 2;
        int true_t = (i - d + 3) * (i - d - 2) / 2;
        if (true_r + true_t == r + t) {
            cout << r - true_r << endl;
            return 0;
        }
    }
    return 0;
}