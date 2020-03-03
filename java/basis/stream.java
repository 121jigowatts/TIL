/**
 * Stream API
 */

// 文字列
List<String> strings = Arrays.asList("a","b","c");
// forEach
strings.stream().forEach(x -> System.out.println(x));

// 数値配列
List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
// sum
int sum = integers.stream().mapToInt(x -> x).sum();
System.out.println(sum);
// filter
int filter = integers.stream().mapToInt(x -> x).filter(x -> x % 2 == 0).sum();
System.out.println(filter);
