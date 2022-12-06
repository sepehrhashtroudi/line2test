@Test [EOL] public void testCrossoverExample() { [EOL]     final Integer[] p1 = new Integer[] { 8, 4, 7, 3, 6, 2, 5, 1, 9, 0 }; [EOL]     final Integer[] p2 = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; [EOL]     final DummyListChromosome p1c = new DummyListChromosome(p1); [EOL]     final DummyListChromosome p2c = new DummyListChromosome(p2); [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(); [EOL]     final ChromosomePair pair = cp.crossover(p1c, p2c); [EOL]     final Integer[] c1 = ((DummyListChromosome) pair.getFirst()).getRepresentation().toArray(new Integer[p1.length]); [EOL]     final Integer[] c2 = ((DummyListChromosome) pair.getSecond()).getRepresentation().toArray(new Integer[p2.length]); [EOL]     final Integer[] c1e = new Integer[] { 8, 1, 2, 3, 4, 5, 6, 7, 9, 0 }; [EOL]     final Integer[] c2e = new Integer[] { 0, 4, 7, 3, 6, 2, 5, 1, 8, 9 }; [EOL]     Assert.assertArrayEquals(c1e, c1); [EOL]     Assert.assertArrayEquals(c2e, c2); [EOL] } <line_num>: 26,45
@Test [EOL] public void testCrossoverExample2() { [EOL]     final Integer[] p1 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; [EOL]     final Integer[] p2 = new Integer[] { 9, 3, 7, 8, 2, 6, 5, 1, 4 }; [EOL]     final DummyListChromosome p1c = new DummyListChromosome(p1); [EOL]     final DummyListChromosome p2c = new DummyListChromosome(p2); [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(); [EOL]     final ChromosomePair pair = cp.crossover(p1c, p2c); [EOL]     final Integer[] c1 = ((DummyListChromosome) pair.getFirst()).getRepresentation().toArray(new Integer[p1.length]); [EOL]     final Integer[] c2 = ((DummyListChromosome) pair.getSecond()).getRepresentation().toArray(new Integer[p2.length]); [EOL]     final Integer[] c1e = new Integer[] { 1, 3, 7, 4, 2, 6, 5, 8, 9 }; [EOL]     final Integer[] c2e = new Integer[] { 9, 2, 3, 8, 5, 6, 7, 1, 4 }; [EOL]     Assert.assertArrayEquals(c1e, c1); [EOL]     Assert.assertArrayEquals(c2e, c2); [EOL] } <line_num>: 47,66
@Test [EOL] public void testCrossover() { [EOL]     final Integer[] p1 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; [EOL]     final Integer[] p2 = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }; [EOL]     final DummyListChromosome p1c = new DummyListChromosome(p1); [EOL]     final DummyListChromosome p2c = new DummyListChromosome(p2); [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(true); [EOL]     for (int i = 0; i < 20; i++) { [EOL]         final ChromosomePair pair = cp.crossover(p1c, p2c); [EOL]         final Integer[] c1 = ((DummyListChromosome) pair.getFirst()).getRepresentation().toArray(new Integer[p1.length]); [EOL]         final Integer[] c2 = ((DummyListChromosome) pair.getSecond()).getRepresentation().toArray(new Integer[p2.length]); [EOL]         int index = 0; [EOL]         for (final Integer j : c1) { [EOL]             if (!p1[index].equals(j)) { [EOL]                 Assert.assertEquals(j, p2[index]); [EOL]             } else { [EOL]                 Assert.assertEquals(j, p1[index]); [EOL]             } [EOL]             index++; [EOL]         } [EOL]         index = 0; [EOL]         for (final Integer k : c2) { [EOL]             if (p2[index] != k) { [EOL]                 Assert.assertEquals(k, p1[index]); [EOL]             } else { [EOL]                 Assert.assertEquals(k, p2[index]); [EOL]             } [EOL]             index++; [EOL]         } [EOL]     } [EOL] } <line_num>: 68,106
@Test(expected = DimensionMismatchException.class) [EOL] public void testCrossoverDimensionMismatchException() { [EOL]     final Integer[] p1 = new Integer[] { 1, 0, 1, 0, 0, 1, 0, 1, 1 }; [EOL]     final Integer[] p2 = new Integer[] { 0, 1, 1, 0, 1 }; [EOL]     final BinaryChromosome p1c = new DummyBinaryChromosome(p1); [EOL]     final BinaryChromosome p2c = new DummyBinaryChromosome(p2); [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(); [EOL]     cp.crossover(p1c, p2c); [EOL] } <line_num>: 108,118
public double fitness() { [EOL]     return 0; [EOL] } <line_num>: 125,128
@Test(expected = MathIllegalArgumentException.class) [EOL] public void testCrossoverInvalidFixedLengthChromosomeFirst() { [EOL]     final Integer[] p1 = new Integer[] { 1, 0, 1, 0, 0, 1, 0, 1, 1 }; [EOL]     final BinaryChromosome p1c = new DummyBinaryChromosome(p1); [EOL]     final Chromosome p2c = new Chromosome() { [EOL]  [EOL]         public double fitness() { [EOL]             return 0; [EOL]         } [EOL]     }; [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(); [EOL]     cp.crossover(p1c, p2c); [EOL] } <line_num>: 120,133
public double fitness() { [EOL]     return 0; [EOL] } <line_num>: 140,143
@Test(expected = MathIllegalArgumentException.class) [EOL] public void testCrossoverInvalidFixedLengthChromosomeSecond() { [EOL]     final Integer[] p1 = new Integer[] { 1, 0, 1, 0, 0, 1, 0, 1, 1 }; [EOL]     final BinaryChromosome p2c = new DummyBinaryChromosome(p1); [EOL]     final Chromosome p1c = new Chromosome() { [EOL]  [EOL]         public double fitness() { [EOL]             return 0; [EOL]         } [EOL]     }; [EOL]     final CrossoverPolicy cp = new CycleCrossover<Integer>(); [EOL]     cp.crossover(p1c, p2c); [EOL] } <line_num>: 135,148