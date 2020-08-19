var arr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

var result = arr.stream().filter(x -> x < 3).peek(t -> System.out.println("[debug]:" + t)).collect(Collectors.toList())
System.out.println(result);
