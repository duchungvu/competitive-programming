#include <bits/stdc++.h>
using namespace std;

int n, p, q, s;
int a[200005], b[200005];

bool check(int x) {
    return
}

int main() {
    cin >> n >> p >> q >> s;
    for (int i = 0; i < p; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < q; i++) {
        cin >> b[i];
    }
    int left = 0;
    int right = max(a[p - 1] - b[0], b[q - 1] - a[0]);
    while (left < right) {
        int mid = (left + right) / 2;
        if (check(mid))
            right = mid;
        else
            left = mid + 1;
    }
    if (check(left))
        cout << left;
    else
        cout << -1;
    
}