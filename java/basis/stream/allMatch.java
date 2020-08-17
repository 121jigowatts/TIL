var arr = Arrays.asList(1, 2, 3);

System.out.println(arr.stream().allMatch(x -> x < 4));
System.out.println(arr.stream().allMatch(x -> x < 3));