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

int t, n;
string s;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> n >> s;
        string res = s;
        int k = 1;
        for (int i = 2; i <= n; i++) {
            string suff = s.substr(0, i - 1);
            if ((n - i) % 2 == 0)  reverse(suff.begin(), suff.end());
            string tmp = s.substr(i - 1, n) + suff;
            if (res > tmp) {
                res = tmp;
                k = i;
            }
        }
        cout << res << endl << k << endl;
    }
    return 0;
}