public class BetterMultithreadedMergeSort extends MergeSort{


  void sort(int arr[], int l, int r, int threadCount) {
    if (l < r) {
      // Find the middle point
      int m = (l + r) / 2;

      if(threadCount > 1) {
        final int newThreadCount = threadCount/2;
        Thread t1 = new Thread(() -> sort(arr, l, m, newThreadCount));
        Thread t2 = new Thread(() -> sort(arr, m + 1, r, newThreadCount));
        t1.start();
        t2.start();
        try {
          t1.join();
          t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        sort(arr, l, m);
        sort(arr, m + 1, r, threadCount++);
      }
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
}
