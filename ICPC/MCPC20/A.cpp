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

string s;
int a, b;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> s;
    for (int i = 0; i < s.length(); i += 2) {
        if (s[i] == 'A') 
            a += s[i + 1] - '0';
        else
            b += s[i + 1] - '0';
    }
    if (a > b)
        cout << "A" << endl;
    else
        cout << "B" << endl;
    return 0;
}