package Algorytmy;

public class CountingSort {

    private int zamiany;
    private int porownania;

    public void countingSort(int arr[], int k) {
        k++;
        int n = arr.length;
        int pos[] = new int[k];
        int result[] = new int[n];
        int i, j;
        for (i = 0; i < k; i++)
            pos[i] = 0;
        for (j = 0; j < n; j++)
            pos[arr[j]]++;
        pos[0]--;
        for (i = 1; i < k; i++) {
            pos[i] += pos[i - 1];
            porownania++;
        }
        for (j = n - 1; j >= 0; j--) {
            zamiany++;
            porownania++;
            result[pos[arr[j]]] = arr[j];
            pos[arr[j]]--;
        }
        for (j = 0; j < n; j++) {
            arr[j] = result[j];
            zamiany++;
            porownania++;
        }
    }

    public int getZamiany() {
        return zamiany;
    }

    public int getPorownania() {
        return porownania;
    }
}
