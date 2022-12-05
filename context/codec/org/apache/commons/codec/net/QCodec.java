public QCodec()
public QCodec(final String charset)
protected String getEncoding()
protected byte[] doEncoding(byte[] bytes)
protected byte[] doDecoding(byte[] bytes) throws DecoderException
public String encode(final String pString, final String charset) throws EncoderException
public String encode(String pString) throws EncoderException
public String decode(String pString) throws DecoderException
public Object encode(Object pObject) throws EncoderException
public Object decode(Object pObject) throws DecoderException
public String getDefaultCharset()
public boolean isEncodeBlanks()
public void setEncodeBlanks(boolean b)
String charset=Optional[CharacterEncodingNames.UTF8]
BitSet PRINTABLE_CHARS=Optional[new BitSet(256)]
byte BLANK=Optional[32]
byte UNDERSCORE=Optional[95]
boolean encodeBlanks=Optional[false]
