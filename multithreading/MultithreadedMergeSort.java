public class MultithreadedMergeSort extends MergeSort {

  @Override
  void sort(int[] arr, int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = (l + r) / 2;

      Thread t1 = new Thread(() -> sort(arr, l, m));
      Thread t2 = new Thread(() -> sort(arr, m + 1, r));
      t1.start();
      t2.start();
      try {
        t1.join();
        t2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
}
