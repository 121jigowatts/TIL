var arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

var result = arr.stream().collect(Collectors.reducing((accumrator, value) -> accumrator + value));
System.out.println(result.get());
