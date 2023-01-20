private Selector(String query, Element root)
public SelectorParseException(String s)
public static Elements select(String query, Element root)
public static Elements select(String query, Iterable<Element> roots)
private Elements select()
private void combinator(String combinator)
private Elements findElements()
private void addElements(Collection<Element> add)
private void intersectElements(Collection<Element> intersect)
private Elements byId()
private Elements byClass()
private Elements byTag()
private Elements byAttribute()
private Elements allElements()
private Elements indexLessThan()
private Elements indexGreaterThan()
private Elements indexEquals()
private int consumeIndex()
private static Elements filterForChildren(Collection<Element> parents, Collection<Element> candidates)
private static Elements filterForDescendants(Collection<Element> parents, Collection<Element> candidates)
private static Elements filterForAdjacentSiblings(Collection<Element> elements, Collection<Element> candidates)
private static Elements filterForGeneralSiblings(Collection<Element> elements, Collection<Element> candidates)
private static Elements filterForSelf(Collection<Element> parents, Collection<Element> candidates)
String[] combinators=Optional[{ ",", ">", "+", "~", " " }]
Element root
LinkedHashSet<Element> elements
String query
TokenQueue tq
