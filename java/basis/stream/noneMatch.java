List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> arr2 = Arrays.asList();

System.out.println(arr1.stream().noneMatch(x -> x < 2));
System.out.println(arr2.stream().noneMatch(x -> x < 1));
