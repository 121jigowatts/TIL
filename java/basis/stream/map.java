var arr = Arrays.asList(1, 2, 3, 4, 5);

System.out.println(arr.stream().map(x -> x * 10).collect(Collectors.toList()));
