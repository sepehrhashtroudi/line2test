public POJOPropertyBuilder(String internalName, AnnotationIntrospector annotationIntrospector, boolean forSerialization) { [EOL]     _internalName = internalName; [EOL]     _name = internalName; [EOL]     _annotationIntrospector = annotationIntrospector; [EOL]     _forSerialization = forSerialization; [EOL] } <line_num>: 43,50
public POJOPropertyBuilder(POJOPropertyBuilder src, String newName) { [EOL]     _internalName = src._internalName; [EOL]     _name = newName; [EOL]     _annotationIntrospector = src._annotationIntrospector; [EOL]     _fields = src._fields; [EOL]     _ctorParameters = src._ctorParameters; [EOL]     _getters = src._getters; [EOL]     _setters = src._setters; [EOL]     _forSerialization = src._forSerialization; [EOL] } <line_num>: 52,62
public Linked(T v, Linked<T> n, String explName, boolean visible, boolean ignored) { [EOL]     value = v; [EOL]     next = n; [EOL]     if (explName == null) { [EOL]         explicitName = null; [EOL]     } else { [EOL]         explicitName = (explName.length() == 0) ? null : explName; [EOL]     } [EOL]     isVisible = visible; [EOL]     isMarkedIgnored = ignored; [EOL] } <line_num>: 705,718
@Override [EOL] public POJOPropertyBuilder withName(String newName) { [EOL]     return new POJOPropertyBuilder(this, newName); [EOL] } <line_num>: 70,73
@Override [EOL] public int compareTo(POJOPropertyBuilder other) { [EOL]     if (_ctorParameters != null) { [EOL]         if (other._ctorParameters == null) { [EOL]             return -1; [EOL]         } [EOL]     } else if (other._ctorParameters != null) { [EOL]         return 1; [EOL]     } [EOL]     return getName().compareTo(other.getName()); [EOL] } <line_num>: 83,98
@Override [EOL] public String getName() { [EOL]     return _name; [EOL] } <line_num>: 106,107
@Override [EOL] public String getInternalName() { [EOL]     return _internalName; [EOL] } <line_num>: 109,110
@Override [EOL] public PropertyName getWrapperName() { [EOL]     AnnotatedMember member = getPrimaryMember(); [EOL]     return (member == null || _annotationIntrospector == null) ? null : _annotationIntrospector.findWrapperName(member); [EOL] } <line_num>: 112,130
@Override [EOL] public boolean isExplicitlyIncluded() { [EOL]     return _anyExplicitNames(_fields) || _anyExplicitNames(_getters) || _anyExplicitNames(_setters) || _anyExplicitNames(_ctorParameters); [EOL] } <line_num>: 132,139
@Override [EOL] public boolean hasGetter() { [EOL]     return _getters != null; [EOL] } <line_num>: 147,148
@Override [EOL] public boolean hasSetter() { [EOL]     return _setters != null; [EOL] } <line_num>: 150,151
@Override [EOL] public boolean hasField() { [EOL]     return _fields != null; [EOL] } <line_num>: 153,154
@Override [EOL] public boolean hasConstructorParameter() { [EOL]     return _ctorParameters != null; [EOL] } <line_num>: 156,157
@Override [EOL] public boolean couldSerialize() { [EOL]     return (_getters != null) || (_fields != null); [EOL] } <line_num>: 159,162
@Override [EOL] public AnnotatedMethod getGetter() { [EOL]     if (_getters == null) { [EOL]         return null; [EOL]     } [EOL]     AnnotatedMethod getter = _getters.value; [EOL]     Linked<AnnotatedMethod> next = _getters.next; [EOL]     for (; next != null; next = next.next) { [EOL]         AnnotatedMethod nextGetter = next.value; [EOL]         Class<?> getterClass = getter.getDeclaringClass(); [EOL]         Class<?> nextClass = nextGetter.getDeclaringClass(); [EOL]         if (getterClass != nextClass) { [EOL]             if (getterClass.isAssignableFrom(nextClass)) { [EOL]                 getter = nextGetter; [EOL]                 continue; [EOL]             } [EOL]             if (nextClass.isAssignableFrom(getterClass)) { [EOL]                 continue; [EOL]             } [EOL]         } [EOL]         throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + getter.getFullName() + " vs " + nextGetter.getFullName()); [EOL]     } [EOL]     return getter; [EOL] } <line_num>: 164,194
@Override [EOL] public AnnotatedMethod getSetter() { [EOL]     if (_setters == null) { [EOL]         return null; [EOL]     } [EOL]     AnnotatedMethod setter = _setters.value; [EOL]     Linked<AnnotatedMethod> next = _setters.next; [EOL]     for (; next != null; next = next.next) { [EOL]         AnnotatedMethod nextSetter = next.value; [EOL]         Class<?> setterClass = setter.getDeclaringClass(); [EOL]         Class<?> nextClass = nextSetter.getDeclaringClass(); [EOL]         if (setterClass != nextClass) { [EOL]             if (setterClass.isAssignableFrom(nextClass)) { [EOL]                 setter = nextSetter; [EOL]                 continue; [EOL]             } [EOL]             if (nextClass.isAssignableFrom(setterClass)) { [EOL]                 continue; [EOL]             } [EOL]         } [EOL]         throw new IllegalArgumentException("Conflicting setter definitions for property \"" + getName() + "\": " + setter.getFullName() + " vs " + nextSetter.getFullName()); [EOL]     } [EOL]     return setter; [EOL] } <line_num>: 196,226
@Override [EOL] public AnnotatedField getField() { [EOL]     if (_fields == null) { [EOL]         return null; [EOL]     } [EOL]     AnnotatedField field = _fields.value; [EOL]     Linked<AnnotatedField> next = _fields.next; [EOL]     for (; next != null; next = next.next) { [EOL]         AnnotatedField nextField = next.value; [EOL]         Class<?> fieldClass = field.getDeclaringClass(); [EOL]         Class<?> nextClass = nextField.getDeclaringClass(); [EOL]         if (fieldClass != nextClass) { [EOL]             if (fieldClass.isAssignableFrom(nextClass)) { [EOL]                 field = nextField; [EOL]                 continue; [EOL]             } [EOL]             if (nextClass.isAssignableFrom(fieldClass)) { [EOL]                 continue; [EOL]             } [EOL]         } [EOL]         throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + field.getFullName() + " vs " + nextField.getFullName()); [EOL]     } [EOL]     return field; [EOL] } <line_num>: 228,254
@Override [EOL] public AnnotatedParameter getConstructorParameter() { [EOL]     if (_ctorParameters == null) { [EOL]         return null; [EOL]     } [EOL]     Linked<AnnotatedParameter> curr = _ctorParameters; [EOL]     do { [EOL]         if (curr.value.getOwner() instanceof AnnotatedConstructor) { [EOL]             return curr.value; [EOL]         } [EOL]         curr = curr.next; [EOL]     } while (curr != null); [EOL]     return _ctorParameters.value; [EOL] } <line_num>: 256,278
@Override [EOL] public AnnotatedMember getAccessor() { [EOL]     AnnotatedMember m = getGetter(); [EOL]     if (m == null) { [EOL]         m = getField(); [EOL]     } [EOL]     return m; [EOL] } <line_num>: 280,288
@Override [EOL] public AnnotatedMember getMutator() { [EOL]     AnnotatedMember m = getConstructorParameter(); [EOL]     if (m == null) { [EOL]         m = getSetter(); [EOL]         if (m == null) { [EOL]             m = getField(); [EOL]         } [EOL]     } [EOL]     return m; [EOL] } <line_num>: 290,301
@Override [EOL] public AnnotatedMember getPrimaryMember() { [EOL]     if (_forSerialization) { [EOL]         return getAccessor(); [EOL]     } [EOL]     return getMutator(); [EOL] } <line_num>: 303,309
@Override [EOL] public Class<?>[] withMember(AnnotatedMember member) { [EOL]     return _annotationIntrospector.findViews(member); [EOL] } <line_num>: 320,323
@Override [EOL] public Class<?>[] findViews() { [EOL]     return fromMemberAnnotations(new WithMember<Class<?>[]>() { [EOL]  [EOL]         @Override [EOL]         public Class<?>[] withMember(AnnotatedMember member) { [EOL]             return _annotationIntrospector.findViews(member); [EOL]         } [EOL]     }); [EOL] } <line_num>: 317,325
@Override [EOL] public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member) { [EOL]     return _annotationIntrospector.findReferenceType(member); [EOL] } <line_num>: 330,333
@Override [EOL] public AnnotationIntrospector.ReferenceProperty findReferenceType() { [EOL]     return fromMemberAnnotations(new WithMember<AnnotationIntrospector.ReferenceProperty>() { [EOL]  [EOL]         @Override [EOL]         public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member) { [EOL]             return _annotationIntrospector.findReferenceType(member); [EOL]         } [EOL]     }); [EOL] } <line_num>: 327,335
@Override [EOL] public Boolean withMember(AnnotatedMember member) { [EOL]     return _annotationIntrospector.isTypeId(member); [EOL] } <line_num>: 340,343
@Override [EOL] public boolean isTypeId() { [EOL]     Boolean b = fromMemberAnnotations(new WithMember<Boolean>() { [EOL]  [EOL]         @Override [EOL]         public Boolean withMember(AnnotatedMember member) { [EOL]             return _annotationIntrospector.isTypeId(member); [EOL]         } [EOL]     }); [EOL]     return (b != null) && b.booleanValue(); [EOL] } <line_num>: 337,346
@Override [EOL] public Boolean withMember(AnnotatedMember member) { [EOL]     return _annotationIntrospector.hasRequiredMarker(member); [EOL] } <line_num>: 351,354
@Override [EOL] public boolean isRequired() { [EOL]     Boolean b = fromMemberAnnotations(new WithMember<Boolean>() { [EOL]  [EOL]         @Override [EOL]         public Boolean withMember(AnnotatedMember member) { [EOL]             return _annotationIntrospector.hasRequiredMarker(member); [EOL]         } [EOL]     }); [EOL]     return (b != null) && b.booleanValue(); [EOL] } <line_num>: 348,357
@Override [EOL] public ObjectIdInfo withMember(AnnotatedMember member) { [EOL]     ObjectIdInfo info = _annotationIntrospector.findObjectIdInfo(member); [EOL]     if (info != null) { [EOL]         info = _annotationIntrospector.findObjectReferenceInfo(member, info); [EOL]     } [EOL]     return info; [EOL] } <line_num>: 362,369
@Override [EOL] public ObjectIdInfo findObjectIdInfo() { [EOL]     return fromMemberAnnotations(new WithMember<ObjectIdInfo>() { [EOL]  [EOL]         @Override [EOL]         public ObjectIdInfo withMember(AnnotatedMember member) { [EOL]             ObjectIdInfo info = _annotationIntrospector.findObjectIdInfo(member); [EOL]             if (info != null) { [EOL]                 info = _annotationIntrospector.findObjectReferenceInfo(member, info); [EOL]             } [EOL]             return info; [EOL]         } [EOL]     }); [EOL] } <line_num>: 359,371
public void addField(AnnotatedField a, String ename, boolean visible, boolean ignored) { [EOL]     _fields = new Linked<AnnotatedField>(a, _fields, ename, visible, ignored); [EOL] } <line_num>: 379,381
public void addCtor(AnnotatedParameter a, String ename, boolean visible, boolean ignored) { [EOL]     _ctorParameters = new Linked<AnnotatedParameter>(a, _ctorParameters, ename, visible, ignored); [EOL] } <line_num>: 383,385
public void addGetter(AnnotatedMethod a, String ename, boolean visible, boolean ignored) { [EOL]     _getters = new Linked<AnnotatedMethod>(a, _getters, ename, visible, ignored); [EOL] } <line_num>: 387,389
public void addSetter(AnnotatedMethod a, String ename, boolean visible, boolean ignored) { [EOL]     _setters = new Linked<AnnotatedMethod>(a, _setters, ename, visible, ignored); [EOL] } <line_num>: 391,393
public void addAll(POJOPropertyBuilder src) { [EOL]     _fields = merge(_fields, src._fields); [EOL]     _ctorParameters = merge(_ctorParameters, src._ctorParameters); [EOL]     _getters = merge(_getters, src._getters); [EOL]     _setters = merge(_setters, src._setters); [EOL] } <line_num>: 399,405
private static <T> Linked<T> merge(Linked<T> chain1, Linked<T> chain2) { [EOL]     if (chain1 == null) { [EOL]         return chain2; [EOL]     } [EOL]     if (chain2 == null) { [EOL]         return chain1; [EOL]     } [EOL]     return chain1.append(chain2); [EOL] } <line_num>: 407,416
public void removeIgnored() { [EOL]     _fields = _removeIgnored(_fields); [EOL]     _getters = _removeIgnored(_getters); [EOL]     _setters = _removeIgnored(_setters); [EOL]     _ctorParameters = _removeIgnored(_ctorParameters); [EOL] } <line_num>: 428,434
@Deprecated [EOL] public void removeNonVisible() { [EOL]     removeNonVisible(false); [EOL] } <line_num>: 439,442
public void removeNonVisible(boolean force) { [EOL]     _getters = _removeNonVisible(_getters); [EOL]     _ctorParameters = _removeNonVisible(_ctorParameters); [EOL]     if (force || (_getters == null)) { [EOL]         _fields = _removeNonVisible(_fields); [EOL]         _setters = _removeNonVisible(_setters); [EOL]     } [EOL] } <line_num>: 445,464
public void trimByVisibility() { [EOL]     _fields = _trimByVisibility(_fields); [EOL]     _getters = _trimByVisibility(_getters); [EOL]     _setters = _trimByVisibility(_setters); [EOL]     _ctorParameters = _trimByVisibility(_ctorParameters); [EOL] } <line_num>: 471,477
@SuppressWarnings("unchecked") [EOL] public void mergeAnnotations(boolean forSerialization) { [EOL]     if (forSerialization) { [EOL]         if (_getters != null) { [EOL]             AnnotationMap ann = _mergeAnnotations(0, _getters, _fields, _ctorParameters, _setters); [EOL]             _getters = _getters.withValue(_getters.value.withAnnotations(ann)); [EOL]         } else if (_fields != null) { [EOL]             AnnotationMap ann = _mergeAnnotations(0, _fields, _ctorParameters, _setters); [EOL]             _fields = _fields.withValue(_fields.value.withAnnotations(ann)); [EOL]         } [EOL]     } else { [EOL]         if (_ctorParameters != null) { [EOL]             AnnotationMap ann = _mergeAnnotations(0, _ctorParameters, _setters, _fields, _getters); [EOL]             _ctorParameters = _ctorParameters.withValue(_ctorParameters.value.withAnnotations(ann)); [EOL]         } else if (_setters != null) { [EOL]             AnnotationMap ann = _mergeAnnotations(0, _setters, _fields, _getters); [EOL]             _setters = _setters.withValue(_setters.value.withAnnotations(ann)); [EOL]         } else if (_fields != null) { [EOL]             AnnotationMap ann = _mergeAnnotations(0, _fields, _getters); [EOL]             _fields = _fields.withValue(_fields.value.withAnnotations(ann)); [EOL]         } [EOL]     } [EOL] } <line_num>: 479,502
private AnnotationMap _mergeAnnotations(int index, Linked<? extends AnnotatedMember>... nodes) { [EOL]     AnnotationMap ann = nodes[index].value.getAllAnnotations(); [EOL]     ++index; [EOL]     for (; index < nodes.length; ++index) { [EOL]         if (nodes[index] != null) { [EOL]             return AnnotationMap.merge(ann, _mergeAnnotations(index, nodes)); [EOL]         } [EOL]     } [EOL]     return ann; [EOL] } <line_num>: 504,514
private <T> Linked<T> _removeIgnored(Linked<T> node) { [EOL]     if (node == null) { [EOL]         return node; [EOL]     } [EOL]     return node.withoutIgnored(); [EOL] } <line_num>: 516,522
private <T> Linked<T> _removeNonVisible(Linked<T> node) { [EOL]     if (node == null) { [EOL]         return node; [EOL]     } [EOL]     return node.withoutNonVisible(); [EOL] } <line_num>: 524,530
private <T> Linked<T> _trimByVisibility(Linked<T> node) { [EOL]     if (node == null) { [EOL]         return node; [EOL]     } [EOL]     return node.trimByVisibility(); [EOL] } <line_num>: 532,538
private <T> boolean _anyExplicitNames(Linked<T> n) { [EOL]     for (; n != null; n = n.next) { [EOL]         if (n.explicitName != null && n.explicitName.length() > 0) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 546,554
public boolean anyVisible() { [EOL]     return _anyVisible(_fields) || _anyVisible(_getters) || _anyVisible(_setters) || _anyVisible(_ctorParameters); [EOL] } <line_num>: 556,562
private <T> boolean _anyVisible(Linked<T> n) { [EOL]     for (; n != null; n = n.next) { [EOL]         if (n.isVisible) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 564,572
public boolean anyIgnorals() { [EOL]     return _anyIgnorals(_fields) || _anyIgnorals(_getters) || _anyIgnorals(_setters) || _anyIgnorals(_ctorParameters); [EOL] } <line_num>: 574,580
private <T> boolean _anyIgnorals(Linked<T> n) { [EOL]     for (; n != null; n = n.next) { [EOL]         if (n.isMarkedIgnored) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 582,590
public String findNewName() { [EOL]     Linked<? extends AnnotatedMember> renamed = null; [EOL]     renamed = findRenamed(_fields, renamed); [EOL]     renamed = findRenamed(_getters, renamed); [EOL]     renamed = findRenamed(_setters, renamed); [EOL]     renamed = findRenamed(_ctorParameters, renamed); [EOL]     return (renamed == null) ? null : renamed.explicitName; [EOL] } <line_num>: 597,605
private Linked<? extends AnnotatedMember> findRenamed(Linked<? extends AnnotatedMember> node, Linked<? extends AnnotatedMember> renamed) { [EOL]     for (; node != null; node = node.next) { [EOL]         String explName = node.explicitName; [EOL]         if (explName == null) { [EOL]             continue; [EOL]         } [EOL]         if (explName.equals(_name)) { [EOL]             continue; [EOL]         } [EOL]         if (renamed == null) { [EOL]             renamed = node; [EOL]         } else { [EOL]             if (!explName.equals(renamed.explicitName)) { [EOL]                 throw new IllegalStateException("Conflicting property name definitions: '" + renamed.explicitName + "' (for " + renamed.value + ") vs '" + node.explicitName + "' (for " + node.value + ")"); [EOL]             } [EOL]         } [EOL]     } [EOL]     return renamed; [EOL] } <line_num>: 607,631
@Override [EOL] public String toString() { [EOL]     StringBuilder sb = new StringBuilder(); [EOL]     sb.append("[Property '").append(_name).append("'; ctors: ").append(_ctorParameters).append(", field(s): ").append(_fields).append(", getter(s): ").append(_getters).append(", setter(s): ").append(_setters); [EOL]     sb.append("]"); [EOL]     return sb.toString(); [EOL] } <line_num>: 634,646
protected <T> T fromMemberAnnotations(WithMember<T> func) { [EOL]     T result = null; [EOL]     if (_annotationIntrospector != null) { [EOL]         if (_forSerialization) { [EOL]             if (_getters != null) { [EOL]                 result = func.withMember(_getters.value); [EOL]             } [EOL]         } else { [EOL]             if (_ctorParameters != null) { [EOL]                 result = func.withMember(_ctorParameters.value); [EOL]             } [EOL]             if (result == null && _setters != null) { [EOL]                 result = func.withMember(_setters.value); [EOL]             } [EOL]         } [EOL]         if (result == null && _fields != null) { [EOL]             result = func.withMember(_fields.value); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 658,679
public T withMember(AnnotatedMember member); <line_num>: 689,689
public Linked<T> withValue(T newValue) { [EOL]     if (newValue == value) { [EOL]         return this; [EOL]     } [EOL]     return new Linked<T>(newValue, next, explicitName, isVisible, isMarkedIgnored); [EOL] } <line_num>: 720,726
public Linked<T> withNext(Linked<T> newNext) { [EOL]     if (newNext == next) { [EOL]         return this; [EOL]     } [EOL]     return new Linked<T>(value, newNext, explicitName, isVisible, isMarkedIgnored); [EOL] } <line_num>: 728,733
public Linked<T> withoutIgnored() { [EOL]     if (isMarkedIgnored) { [EOL]         return (next == null) ? null : next.withoutIgnored(); [EOL]     } [EOL]     if (next != null) { [EOL]         Linked<T> newNext = next.withoutIgnored(); [EOL]         if (newNext != next) { [EOL]             return withNext(newNext); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 735,747
public Linked<T> withoutNonVisible() { [EOL]     Linked<T> newNext = (next == null) ? null : next.withoutNonVisible(); [EOL]     return isVisible ? withNext(newNext) : newNext; [EOL] } <line_num>: 749,753
private Linked<T> append(Linked<T> appendable) { [EOL]     if (next == null) { [EOL]         return withNext(appendable); [EOL]     } [EOL]     return withNext(next.append(appendable)); [EOL] } <line_num>: 759,765
public Linked<T> trimByVisibility() { [EOL]     if (next == null) { [EOL]         return this; [EOL]     } [EOL]     Linked<T> newNext = next.trimByVisibility(); [EOL]     if (explicitName != null) { [EOL]         if (newNext.explicitName == null) { [EOL]             return withNext(null); [EOL]         } [EOL]         return withNext(newNext); [EOL]     } [EOL]     if (newNext.explicitName != null) { [EOL]         return newNext; [EOL]     } [EOL]     if (isVisible == newNext.isVisible) { [EOL]         return withNext(newNext); [EOL]     } [EOL]     return isVisible ? withNext(null) : newNext; [EOL] } <line_num>: 767,788
@Override [EOL] public String toString() { [EOL]     String msg = value.toString() + "[visible=" + isVisible + "]"; [EOL]     if (next != null) { [EOL]         msg = msg + ", " + next.toString(); [EOL]     } [EOL]     return msg; [EOL] } <line_num>: 790,797