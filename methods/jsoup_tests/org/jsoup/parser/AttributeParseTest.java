@Test [EOL] public void parsesRoughAttributeString() { [EOL]     String html = "<a id=\"123\" class=\"baz = 'bar'\" style = 'border: 2px'qux zim foo = 12 mux=18 />"; [EOL]     Element el = Jsoup.parse(html).getElementsByTag("a").get(0); [EOL]     Attributes attr = el.attributes(); [EOL]     assertEquals(7, attr.size()); [EOL]     assertEquals("123", attr.get("id")); [EOL]     assertEquals("baz = 'bar'", attr.get("class")); [EOL]     assertEquals("border: 2px", attr.get("style")); [EOL]     assertEquals("", attr.get("qux")); [EOL]     assertEquals("", attr.get("zim")); [EOL]     assertEquals("12", attr.get("foo")); [EOL]     assertEquals("18", attr.get("mux")); [EOL] } <line_num>: 16,30
@Test [EOL] public void parsesEmptyString() { [EOL]     String html = "<a />"; [EOL]     Element el = Jsoup.parse(html).getElementsByTag("a").get(0); [EOL]     Attributes attr = el.attributes(); [EOL]     assertEquals(0, attr.size()); [EOL] } <line_num>: 32,37
@Test [EOL] public void emptyOnNoKey() { [EOL]     String html = "<a =empty />"; [EOL]     Element el = Jsoup.parse(html).getElementsByTag("a").get(0); [EOL]     Attributes attr = el.attributes(); [EOL]     assertEquals(0, attr.size()); [EOL] } <line_num>: 39,44
