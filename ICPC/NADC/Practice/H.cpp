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

int a, b, c, d;

double maxArea(double a, double b, double c, double d) {
    // Calculating the semi-perimeter
    // of the given quadilateral
    double semiperimeter = (a + b + c + d) / 2;
 
    // Applying Brahmagupta's formula to
    // get maximum area of quadrilateral
    return sqrt((semiperimeter - a) *
                (semiperimeter - b) *
                (semiperimeter - c) *
                (semiperimeter - d));
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> a >> b >> c >> d;
    cout << setprecision(16) << maxArea(a, b, c, d) << endl;
    return 0;
}