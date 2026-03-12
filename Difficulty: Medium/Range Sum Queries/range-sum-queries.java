class Sol {

    // update value in array and segment tree
    static void updateValue(int arr[], long st[], int n, int index, int val) {

        int diff = val - arr[index];
        arr[index] = val;

        update(index, diff, 0, 0, n - 1, st);
    }

    static void update(int index, int diff, int i, int left, int right, long st[]) {

        if (index < left || index > right)
            return;

        st[i] += diff;

        if (left != right) {

            int mid = left + (right - left) / 2;

            update(index, diff, 2 * i + 1, left, mid, st);
            update(index, diff, 2 * i + 2, mid + 1, right, st);
        }
    }

    // range sum query
    public static long getSum(long st[], int n, int ql, int qr) {

        return getsum(st, 0, n - 1, ql, qr, 0);
    }

    static long getsum(long st[], int left, int right, int ql, int qr, int i) {

        // total overlap
        if (ql <= left && qr >= right)
            return st[i];

        // no overlap
        if (right < ql || left > qr)
            return 0;

        int mid = left + (right - left) / 2;

        return getsum(st, left, mid, ql, qr, 2 * i + 1) +
               getsum(st, mid + 1, right, ql, qr, 2 * i + 2);
    }
}