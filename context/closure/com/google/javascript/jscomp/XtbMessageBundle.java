public XtbMessageBundle(InputStream xtb, @Nullable String projectId, boolean unused)
public XtbMessageBundle(InputStream xtb, @Nullable String projectId)
private SAXParser createSAXParser() throws ParserConfigurationException, SAXException
public JsMessage getMessage(String id)
public JsMessage.IdGenerator idGenerator()
public Iterable<JsMessage> getAllMessages()
public void setDocumentLocator(Locator locator)
public void startDocument()
public void endDocument()
public void startPrefixMapping(String prefix, String uri)
public void endPrefixMapping(String prefix)
public void startElement(String uri, String localName, String qName, Attributes atts)
public void endElement(String uri, String localName, String qName)
public void characters(char[] ch, int start, int length)
public void ignorableWhitespace(char[] ch, int start, int length)
public void processingInstruction(String target, String data)
public void skippedEntity(String name)
public InputSource resolveEntity(String publicId, String systemId)
SecureEntityResolver NOOP_RESOLVER=Optional[new SecureEntityResolver()]
Map<String, JsMessage> messages
JsMessage.IdGenerator idGenerator
