public ProperFractionFormat()
public ProperFractionFormat(NumberFormat format)
public ProperFractionFormat(NumberFormat wholeFormat, NumberFormat numeratorFormat, NumberFormat denominatorFormat)
public StringBuffer format(Fraction fraction, StringBuffer toAppendTo, FieldPosition pos)
public NumberFormat getWholeFormat()
public Fraction parse(String source, ParsePosition pos)
public void setWholeFormat(NumberFormat format)