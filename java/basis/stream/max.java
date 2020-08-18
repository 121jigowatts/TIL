var arr = Arrays.asList(1, 2, 3, 4, 5);

System.out.println(arr.stream().max(Comparator.naturalOrder()).get());
