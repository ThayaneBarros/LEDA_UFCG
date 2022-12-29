package orderStatistic;

public class test2 {

	public static void main(String[] args) {
		OrderStatisticsSelectionImpl<Integer> t = new OrderStatisticsSelectionImpl();
		Integer[] array = {4, 15, 25, 30, 8, 20, 28};
		System.out.println(t.getOrderStatistics(array, 0)); // null
		System.out.println(t.getOrderStatistics(array, 1)); // 4
		System.out.println(t.getOrderStatistics(array, 2)); // 8
		System.out.println(t.getOrderStatistics(array, 3)); // 15
		System.out.println(t.getOrderStatistics(array, 4)); // 20
		System.out.println(t.getOrderStatistics(array, 5)); // 25
		System.out.println(t.getOrderStatistics(array, 6)); // 28
		System.out.println(t.getOrderStatistics(array, 7)); // 30
		System.out.println(t.getOrderStatistics(array, 8)); // null
		

	}

}
