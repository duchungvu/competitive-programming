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

int t;
string s;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    for (int o = 1; o <= t; o++) {
        cin >> s;
        string res = "";
        int cur = 0;
        int n = s.size();
        for (int i = n - 1; i >= 0; i--) {
            while (cur < s[i] - '0') {
                cur++;
                res += ')';
            } 
            while (cur > s[i] - '0') {
                cur--;
                res += '(';
            }
            res += s[i];
        }
        while (cur > 0) {
            cur--;
            res += '(';
        }
        reverse(res.begin(), res.end());
        cout << "Case #" << o << ": " << res << endl;
    }
    return 0;
} 