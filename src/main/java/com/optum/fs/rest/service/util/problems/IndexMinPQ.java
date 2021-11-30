package com.optum.fs.rest.service.util.problems;

public class IndexMinPQ<Key extends Comparable<Key>> {
	private int N; // number of elements on PQ
	private int[] pq; // binary heap using 1-based indexing
	private int[] qp; // inverse: qp[pq[i]] = pq[qp[i]] = i
	private Key[] keys; // items with priorities

	public IndexMinPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public void insert(int k, Key key) {
		N++;
		qp[k] = N;
		pq[N] = k;
		keys[k] = key;
		swim(N);
	}

	private void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			exch(k, k / 2);
			k = k / 2;
		}

	}

	private boolean less(int k, int i) {
		return pq[k] > pq[i];

	}

	public Item min() {
		return (Item) keys[pq[1]];
	}

	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N + 1]] = null;
		qp[pq[N + 1]] = -1;
		return indexOfMin;
	}
	public int minIndex()
	{ return pq[1]; }
	public void change(int k, Key item)
	{
		keys[k] =  item;
	swim(qp[k]);
	sink(qp[k]);
	}
	public void delete(int k)
	{
	exch(k, N--);
	swim(qp[k]);
	sink(qp[k]);
	keys[pq[N+1]] = null;
	qp[pq[N+1]] = -1;
	}

	private void sink(int k) {
		while (2 * k < N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j = j + 1;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;

	}
}