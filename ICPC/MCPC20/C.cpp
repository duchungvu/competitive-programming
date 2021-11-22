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

int n, k;
int t[20005];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> t[i];
    }
    sort(t, t + n);
    int left = n;
    
    return 0;
}