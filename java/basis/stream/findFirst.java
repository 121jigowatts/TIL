var arr = Arrays.asList(1, 2, 3, 4, 5);

Optional<Integer> opt = arr.stream().findFirst();
opt.ifPresent(x -> System.out.println(x));
