var arr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

var result = arr.stream().skip(5).collect(Collectors.toList())
System.out.println(result);