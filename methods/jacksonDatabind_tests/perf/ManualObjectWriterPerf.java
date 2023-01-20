private <T1, T2> void test(ObjectMapper mapper, T1 inputValue1, Class<T1> inputClass1, T2 inputValue2, Class<T2> inputClass2) throws Exception { [EOL]     final int REPS; [EOL]     { [EOL]         final byte[] input1 = mapper.writeValueAsBytes(inputValue1); [EOL]         final byte[] input2 = mapper.writeValueAsBytes(inputValue2); [EOL]         REPS = (int) ((double) (9 * 1000 * 1000) / (double) input1.length); [EOL]         System.out.printf("Read %d bytes to bind (%d as array); will do %d repetitions\n", input1.length, input2.length, REPS); [EOL]     } [EOL]     final ObjectWriter writer0 = mapper.writer().with(SerializationFeature.EAGER_SERIALIZER_FETCH); [EOL]     final ObjectWriter jsonWriter = writer0.withType(inputClass1); [EOL]     final ObjectWriter arrayWriter = writer0.withType(inputClass2); [EOL]     int i = 0; [EOL]     int roundsDone = 0; [EOL]     final int TYPES = 2; [EOL]     final int WARMUP_ROUNDS = 5; [EOL]     final long[] times = new long[TYPES]; [EOL]     while (true) { [EOL]         final NopOutputStream out = new NopOutputStream(); [EOL]         try { [EOL]             Thread.sleep(100L); [EOL]         } catch (InterruptedException ie) { [EOL]         } [EOL]         int round = (i++ % TYPES); [EOL]         String msg; [EOL]         boolean lf = (round == 0); [EOL]         long msecs; [EOL]         ObjectWriter writer; [EOL]         Object value; [EOL]         switch(round) { [EOL]             case 0: [EOL]                 msg = "JSON-as-Object"; [EOL]                 writer = jsonWriter; [EOL]                 value = inputValue1; [EOL]                 break; [EOL]             case 1: [EOL]                 msg = "JSON-as-Array"; [EOL]                 writer = arrayWriter; [EOL]                 value = inputValue2; [EOL]                 break; [EOL]             default: [EOL]                 out.close(); [EOL]                 throw new Error(); [EOL]         } [EOL]         msecs = testSer(REPS, value, writer, out); [EOL]         if (roundsDone >= WARMUP_ROUNDS) { [EOL]             times[round] += msecs; [EOL]         } [EOL]         System.out.printf("Test '%s' [hash: 0x%s] -> %d msecs\n", msg, this.hash, msecs); [EOL]         if (lf) { [EOL]             ++roundsDone; [EOL]             if ((roundsDone % 3) == 0 && roundsDone > WARMUP_ROUNDS) { [EOL]                 double den = (double) (roundsDone - WARMUP_ROUNDS); [EOL]                 System.out.printf("Averages after %d rounds (pre / no): %.1f / %.1f msecs\n", (int) den, times[0] / den, times[1] / den); [EOL]             } [EOL]             System.out.println(); [EOL]         } [EOL]         if ((i % 17) == 0) { [EOL]             System.out.println("[GC]"); [EOL]             Thread.sleep(100L); [EOL]             System.gc(); [EOL]             Thread.sleep(100L); [EOL]         } [EOL]     } [EOL] } <line_num>: 9,89
private final long testSer(int REPS, Object value, ObjectWriter writer, NopOutputStream out) throws Exception { [EOL]     long start = System.currentTimeMillis(); [EOL]     while (--REPS >= 0) { [EOL]         writer.writeValue(out, value); [EOL]     } [EOL]     hash = out.size(); [EOL]     return System.currentTimeMillis() - start; [EOL] } <line_num>: 91,99
public static void main(String[] args) throws Exception { [EOL]     if (args.length != 0) { [EOL]         System.err.println("Usage: java ..."); [EOL]         System.exit(1); [EOL]     } [EOL]     Record input1 = new Record(44, "BillyBob", "Bumbler", 'm', true); [EOL]     RecordAsArray input2 = new RecordAsArray(44, "BillyBob", "Bumbler", 'm', true); [EOL]     ObjectMapper m = new ObjectMapper(); [EOL]     new ManualObjectWriterPerf().test(m, input1, Record.class, input2, RecordAsArray.class); [EOL] } <line_num>: 101,112
