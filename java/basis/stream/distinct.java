var arr = Arrays.asList(1, 2, 1, 2, 2, 3, 1, 3);

System.out.println(arr.stream().distinct().collect(Collectors.toList()));
