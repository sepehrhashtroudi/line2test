public static Test suite() { [EOL]     return new TestSuite(AbstractCategoryItemRendererTests.class); [EOL] } <line_num>: 81,83
public void testEquals() { [EOL]     BarRenderer r1 = new BarRenderer(); [EOL]     BarRenderer r2 = new BarRenderer(); [EOL]     assertEquals(r1, r2); [EOL]     r1.setSeriesToolTipGenerator(1, new StandardCategoryToolTipGenerator()); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setSeriesToolTipGenerator(1, new StandardCategoryToolTipGenerator()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{2}", NumberFormat.getInstance())); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{2}", NumberFormat.getInstance())); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator()); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setSeriesItemLabelGenerator(1, new StandardCategoryItemLabelGenerator()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance())); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance())); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setSeriesURLGenerator(1, new StandardCategoryURLGenerator()); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setSeriesURLGenerator(1, new StandardCategoryURLGenerator()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setBaseURLGenerator(new StandardCategoryURLGenerator("abc.html")); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBaseURLGenerator(new StandardCategoryURLGenerator("abc.html")); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("XYZ")); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setLegendItemLabelGenerator(new StandardCategorySeriesLabelGenerator("XYZ")); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("ToolTip")); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator("ToolTip")); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setLegendItemURLGenerator(new StandardCategorySeriesLabelGenerator("URL")); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setLegendItemURLGenerator(new StandardCategorySeriesLabelGenerator("URL")); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.addAnnotation(new CategoryTextAnnotation("ABC", "A", 2.0), Layer.BACKGROUND); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.addAnnotation(new CategoryTextAnnotation("ABC", "A", 2.0), Layer.BACKGROUND); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.addAnnotation(new CategoryTextAnnotation("DEF", "B", 4.0), Layer.FOREGROUND); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.addAnnotation(new CategoryTextAnnotation("DEF", "B", 4.0), Layer.FOREGROUND); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 88,178
public void testCloning1() { [EOL]     AbstractCategoryItemRenderer r1 = new BarRenderer(); [EOL]     r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); [EOL]     AbstractCategoryItemRenderer r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1 = new BarRenderer(); [EOL]     r1.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator()); [EOL]     r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1 = new BarRenderer(); [EOL]     r1.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); [EOL]     r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 183,223
public void testCloning2() { [EOL]     BarRenderer r1 = new BarRenderer(); [EOL]     r1.setBaseItemLabelGenerator(new IntervalCategoryItemLabelGenerator()); [EOL]     BarRenderer r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1 = new BarRenderer(); [EOL]     r1.setSeriesItemLabelGenerator(0, new IntervalCategoryItemLabelGenerator()); [EOL]     r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1 = new BarRenderer(); [EOL]     r1.setBaseItemLabelGenerator(new IntervalCategoryItemLabelGenerator()); [EOL]     r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 228,268
public void testCloning_LegendItemLabelGenerator() { [EOL]     StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}"); [EOL]     BarRenderer r1 = new BarRenderer(); [EOL]     r1.setLegendItemLabelGenerator(generator); [EOL]     BarRenderer r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     assertTrue(r1.getLegendItemLabelGenerator() != r2.getLegendItemLabelGenerator()); [EOL] } <line_num>: 273,292
public void testCloning_LegendItemToolTipGenerator() { [EOL]     StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}"); [EOL]     BarRenderer r1 = new BarRenderer(); [EOL]     r1.setLegendItemToolTipGenerator(generator); [EOL]     BarRenderer r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     assertTrue(r1.getLegendItemToolTipGenerator() != r2.getLegendItemToolTipGenerator()); [EOL] } <line_num>: 297,316
public void testCloning_LegendItemURLGenerator() { [EOL]     StandardCategorySeriesLabelGenerator generator = new StandardCategorySeriesLabelGenerator("Series {0}"); [EOL]     BarRenderer r1 = new BarRenderer(); [EOL]     r1.setLegendItemURLGenerator(generator); [EOL]     BarRenderer r2 = null; [EOL]     try { [EOL]         r2 = (BarRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     assertTrue(r1.getLegendItemURLGenerator() != r2.getLegendItemURLGenerator()); [EOL] } <line_num>: 321,340
public void testGetSeriesItemLabelGenerator() { [EOL]     CategoryItemRenderer r = new BarRenderer(); [EOL]     assertNull(r.getSeriesItemLabelGenerator(2)); [EOL]     r.setSeriesItemLabelGenerator(2, new StandardCategoryItemLabelGenerator()); [EOL]     assertNotNull(r.getSeriesItemLabelGenerator(2)); [EOL]     r.setSeriesItemLabelGenerator(2, null); [EOL]     assertNull(r.getSeriesItemLabelGenerator(2)); [EOL]     r.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); [EOL]     assertNull(r.getSeriesItemLabelGenerator(2)); [EOL] } <line_num>: 346,356
public void testGetSeriesURLGenerator() { [EOL]     CategoryItemRenderer r = new BarRenderer(); [EOL]     assertNull(r.getSeriesURLGenerator(2)); [EOL]     r.setSeriesURLGenerator(2, new StandardCategoryURLGenerator()); [EOL]     assertNotNull(r.getSeriesURLGenerator(2)); [EOL]     r.setSeriesURLGenerator(2, null); [EOL]     assertNull(r.getSeriesURLGenerator(2)); [EOL]     r.setBaseURLGenerator(new StandardCategoryURLGenerator()); [EOL]     assertNull(r.getSeriesURLGenerator(2)); [EOL] } <line_num>: 361,370
public void testFindRangeBounds() { [EOL]     AbstractCategoryItemRenderer r = new LineAndShapeRenderer(); [EOL]     assertNull(r.findRangeBounds(null)); [EOL]     DefaultCategoryDataset dataset = new DefaultCategoryDataset(); [EOL]     assertNull(r.findRangeBounds(dataset)); [EOL]     dataset.addValue(1.0, "R1", "C1"); [EOL]     assertEquals(new Range(1.0, 1.0), r.findRangeBounds(dataset)); [EOL]     dataset.addValue(-2.0, "R1", "C2"); [EOL]     assertEquals(new Range(-2.0, 1.0), r.findRangeBounds(dataset)); [EOL]     dataset.addValue(null, "R1", "C3"); [EOL]     assertEquals(new Range(-2.0, 1.0), r.findRangeBounds(dataset)); [EOL] } <line_num>: 375,391
public void test2947660() { [EOL]     AbstractCategoryItemRenderer r = new LineAndShapeRenderer(); [EOL]     assertNotNull(r.getLegendItems()); [EOL]     assertEquals(0, r.getLegendItems().getItemCount()); [EOL]     DefaultCategoryDataset dataset = new DefaultCategoryDataset(); [EOL]     CategoryPlot plot = new CategoryPlot(); [EOL]     plot.setDataset(dataset); [EOL]     plot.setRenderer(r); [EOL]     assertEquals(0, r.getLegendItems().getItemCount()); [EOL]     dataset.addValue(1.0, "S1", "C1"); [EOL]     LegendItemCollection lic = r.getLegendItems(); [EOL]     assertEquals(1, lic.getItemCount()); [EOL]     assertEquals("S1", lic.get(0).getLabel()); [EOL] } <line_num>: 396,411
