var arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

var result = arr.stream().mapToInt(x -> x).average()
System.out.println(result.getAsDouble());
