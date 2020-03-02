/**
 * Fenwick Tree
 * Author: Hung Vu
 * Description: Computes partial sums a[0] + a[1] + ... + a[pos - 1], and updates single elements a[i],
 * taking the difference between the old and new value.
 * Time: Both operations are O(log N).
 */
#include <bits/stdc++.h>
using namespace std;

#define maxn 100005

int n, a[maxn];

struct FenwickTree {
    vector<int> f;
    FenwickTree(int n) : f(n) {}

    int query(int x) {
        int ret = 0;
        for (; x < f.size() ; x = (x & (x + 1)) - 1) {
            ret += f[x];
        }
        return ret;
    }

    void update(int x, int val) {
        for (; x < f.size(); x |= (x + 1)) {
            f[x] += val;
        }
    }
};


int main() {
    cin >> n;
    FenwickTree sum(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        sum.update(i, a[i]);
    }
    for (int i = 0; i < n; i++) {
        cout << sum.query(i) << " ";
    }
    cout << endl;
    return 0;
}