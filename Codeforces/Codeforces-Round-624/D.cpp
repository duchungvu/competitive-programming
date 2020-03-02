#include <bits/stdc++.h>
using namespace std;

int t, a, b ,c;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> t;
    while (t--) {
        cin >> a >> b >> c;
        int res = c * 3;
        int A = 1, B = 1, C = 1;
        for (int i = 1; i <= a * 2; i++) {
            for (int j = 1; j <= 2 * b / i; j++) {
                int lo = c / (i * j) * (i * j);
                int hi = c / (i * j) * (i * j) + (i * j);
                if (lo >= i * j && res > abs(a - i) + abs(b - j * i) + abs(c - lo)) {
                    res = abs(a - i) + abs(b - j * i) + abs(c - lo);
                    A = i;
                    B = j * A;
                    C = lo;
                }
                if (hi >= (i * j) && res > abs(a - i) + abs(b - j * i) + abs(c - hi)) {
                    res = abs(a - i) + abs(b - j * i) + abs(c - hi);
                    A = i;
                    B = j * A;
                    C = hi;
                }
            }
        }
        cout << res << endl;
        cout << A << " " << B << " " << C << endl;
    }
    return 0;
}