public void testInsertInListNoDup() { [EOL]     String[] arr = new String[] { "me", "you", "him" }; [EOL]     String[] newarr; [EOL]     newarr = ArrayBuilders.insertInListNoDup(arr, "you"); [EOL]     Assert.assertArrayEquals(new String[] { "you", "me", "him" }, newarr); [EOL]     newarr = ArrayBuilders.insertInListNoDup(arr, "me"); [EOL]     Assert.assertArrayEquals(new String[] { "me", "you", "him" }, newarr); [EOL]     newarr = ArrayBuilders.insertInListNoDup(arr, "him"); [EOL]     Assert.assertArrayEquals(new String[] { "him", "me", "you" }, newarr); [EOL]     newarr = ArrayBuilders.insertInListNoDup(arr, "foobar"); [EOL]     Assert.assertArrayEquals(new String[] { "foobar", "me", "you", "him" }, newarr); [EOL] } <line_num>: 10,26