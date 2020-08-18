var arr = Arrays.asList(
    Arrays.asList(1, 2, 3),
    Arrays.asList(4, 5, 6),
    Arrays.asList(7, 8, 9)
);

System.out.println(arr.stream().flatMap(x -> x.stream()).collect(Collectors.toList()));