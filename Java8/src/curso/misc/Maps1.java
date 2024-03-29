package curso.misc;

import java.util.HashMap;
import java.util.Map;

public class Maps1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}

		map.forEach((id, val) -> System.out.println(id + ": " + val));

		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3)); // val33

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9)); // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23)); // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3)); // val33

		System.out.println(map.getOrDefault(42, "not found")); // not found

		System.out.println(map.getOrDefault(1, "not found")); // val1

		map.remove(3, "val3");
		System.out.println(map.get(3)); // val33

		map.remove(3, "val33");
		System.out.println(map.get(3)); // null

		map.merge(10, "val10", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(10)); // val10

		map.merge(10, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(10)); // val10concat

	}

}