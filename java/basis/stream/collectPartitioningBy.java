var arr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

System.out.println(arr.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));
