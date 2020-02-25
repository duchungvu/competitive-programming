#include <bits/stdc++.h>
using namespace std;

int n, p, q, s;
int a[200005], b[200005];
int pre[200005], nxt[200005];

bool check(int d) {
    for (int i = 0; i < q + 2; i++) {
        pre[i] = i - 1;
        nxt[i] = i + 1;
    }
    int cur = 0, lowD = q, highD = q, highS = q;
    while (highS >= 0 && a[p - 1] + b[highS] > s) highS = pre[highS];
    for (int i = p - 1; i >= 0; i--) {
        while (lowD > 0 && a[i] - b[lowD] <= d) lowD = pre[lowD];
        while (highD > 0 && b[highD] - a[i] > d) highD = pre[highD];
        while (highS <= q && a[i] + b[highS] <= s) highS = nxt[highS];
        int l = nxt[lowD], r = min(highD, pre[highS]);
        if (r < l) continue; 
        if (lowD == r) lowD = pre[lowD];
        if (highD == r) highD = pre[highD];
        if (highS == r) highS = nxt[highS];
        nxt[pre[r]] = nxt[r];
        pre[nxt[r]] = pre[r];
        if (++cur >= n) return true;
    }
    return false;
}

int main() {
    cin >> n >> p >> q >> s;
    for (int i = 0; i < p; i++) {
        cin >> a[i];
    }
    for (int i = 1; i < q + 1; i++) {
        cin >> b[i];
    }
    sort(a, a + p);
    sort(b, b + 1 + q);

    int res = -1;
    int left = 0;
    int right = max(a[p - 1] - b[0], b[q] - a[0]);
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