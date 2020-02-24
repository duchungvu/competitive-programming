#include <bits/stdc++.h>
using namespace std;

int n, p, q, s;
int a[200005], b[200005];

bool check(int x) {
    // cout << "check: " << x << endl;
    bool check[200005];
    memset(check, false, sizeof(check));
    int r = q - 1;
    while (r >= 0 && b[r] - a[p - 1] > x) r--;
    int l = r;
    while (l >= 0 && a[p - 1] - b[l] <= x) l--;
    int k = 0;
    while (k <= q - 1 && a[p - 1] + b[k] <= s) k++;
    int cur = 0;
    for (int i = p - 1; i >= 0; i--) {
        while (r >= 0 && b[r] - a[i] > x) r--;
        while (l >= 0 && a[i] - b[l] <= x) l--;
        while (k <= q - 1 && a[i] + b[k] <= s) k++;
        // cout << a[i] << ' ' << l << ' ' << r << ' ' << k << ' ' << endl;
        for (int j = min(r, k - 1); j > l; j--) {
            if (!check[j]) {
                check[j] = true;
                cur++;
                break;
            }
        }
        if (cur >= n) return true;
    }
    // for (int i = 0; i < q; i++) {
    //     cout << check[i] << " ";
    // }
    // cout << endl;
    return false;
}

int main() {
    cin >> n >> p >> q >> s;
    for (int i = 0; i < p; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < q; i++) {
        cin >> b[i];
    }
    sort(a, a + p);
    sort(b, b + q);

    int res = -1;
    int left = 0;
    int right = max(a[p - 1] - b[0], b[q - 1] - a[0]);
    while (left <= right) {
        int mid = (left + right) / 2;
        if (check(mid)) {
            res = mid;
            right = mid - 1;
        }
        else
            left = mid + 1;
    }
    cout << res;
    return 0;
}