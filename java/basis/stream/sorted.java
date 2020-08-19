var arr = Arrays.asList(2, -7, 3, 0, -1, -8, 5, 9, -6, 4);

System.out.println(arr.stream().sorted().collect(Collectors.toList()));
System.out.println(arr.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
System.out.println(arr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));