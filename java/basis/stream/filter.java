var arr = Arrays.asList(1, 2, 3);

System.out.println(arr.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
