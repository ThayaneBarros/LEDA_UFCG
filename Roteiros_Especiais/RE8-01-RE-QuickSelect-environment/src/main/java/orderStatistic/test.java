package orderStatistic;

public class test {

	public static void main(String[] args) {
		QuickSelect<Integer> t = new QuickSelect();
		Integer[] array = {4, 15, 25, 30, 8, 20, 28};
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 0)); // null
		System.out.println(t.quickSelect(array, 1)); // 4
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 2)); // 8
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 3)); // 15
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 4)); // 20
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 5)); // 25
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 6)); // 28
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 7)); // 30
		System.out.println(t.quickSelect(new Integer[] {4, 15, 25, 30, 8, 20, 28}, 8)); // null

	}

}
