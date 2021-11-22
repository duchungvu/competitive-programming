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

int n;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    cout << max(1, n - 2);
    return 0;
}