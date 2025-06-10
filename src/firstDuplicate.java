class firstDuplicate {
  public static int firstDuplicate(int[] a) {
    boolean found = false;
    int index = a.length;
    for (int i = 0; i < a.length; i++) {
      for (int j = i+1; j < a.length; j++) {
        if (a[i] == a[j]) {
          found = true;
          index = Math.min(index, j);
          break;
        }
      }
    }
    return found ? a[index] : -1;
  }
  
  public static void main (String[] args) {
    int[] a = new int[] {2, 1, 3, 5, 3, 2};
    System.out.println(firstDuplicate(a));

    a = new int[] {2, 2};
    System.out.println(firstDuplicate(a));

    a = new int[] {2, 4, 3, 5, 1};
    System.out.println(firstDuplicate(a));
  }   
  
}
