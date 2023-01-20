protected JXPathContextReferenceImpl(JXPathContext parentContext, Object contextBean) { [EOL]     this(parentContext, contextBean, null); [EOL] } <line_num>: 121,125
public JXPathContextReferenceImpl(JXPathContext parentContext, Object contextBean, Pointer contextPointer) { [EOL]     super(parentContext, contextBean); [EOL]     synchronized (nodeFactories) { [EOL]         createNodeFactoryArray(); [EOL]     } [EOL]     if (contextPointer != null) { [EOL]         this.contextPointer = contextPointer; [EOL]         this.rootPointer = NodePointer.newNodePointer(new QName(null, "root"), contextPointer.getRootNode(), getLocale()); [EOL]     } else { [EOL]         this.contextPointer = NodePointer.newNodePointer(new QName(null, "root"), contextBean, getLocale()); [EOL]         this.rootPointer = this.contextPointer; [EOL]     } [EOL]     NamespaceResolver parentNR = null; [EOL]     if (parentContext instanceof JXPathContextReferenceImpl) { [EOL]         parentNR = ((JXPathContextReferenceImpl) parentContext).getNamespaceResolver(); [EOL]     } [EOL]     namespaceResolver = new NamespaceResolver(parentNR); [EOL]     namespaceResolver.setNamespaceContextPointer((NodePointer) this.contextPointer); [EOL] } <line_num>: 127,162
public int compare(Object a, Object b) { [EOL]     int orderA = ((NodePointerFactory) a).getOrder(); [EOL]     int orderB = ((NodePointerFactory) b).getOrder(); [EOL]     return orderA - orderB; [EOL] } <line_num>: 170,174
private static void createNodeFactoryArray() { [EOL]     if (nodeFactoryArray == null) { [EOL]         nodeFactoryArray = (NodePointerFactory[]) nodeFactories.toArray(new NodePointerFactory[0]); [EOL]         Arrays.sort(nodeFactoryArray, new Comparator() { [EOL]  [EOL]             public int compare(Object a, Object b) { [EOL]                 int orderA = ((NodePointerFactory) a).getOrder(); [EOL]                 int orderB = ((NodePointerFactory) b).getOrder(); [EOL]                 return orderA - orderB; [EOL]             } [EOL]         }); [EOL]     } [EOL] } <line_num>: 164,177
public static void addNodePointerFactory(NodePointerFactory factory) { [EOL]     synchronized (nodeFactories) { [EOL]         nodeFactories.add(factory); [EOL]         nodeFactoryArray = null; [EOL]     } [EOL] } <line_num>: 184,189
public static NodePointerFactory[] getNodePointerFactories() { [EOL]     return nodeFactoryArray; [EOL] } <line_num>: 191,193
protected Compiler getCompiler() { [EOL]     return COMPILER; [EOL] } <line_num>: 200,202
protected CompiledExpression compilePath(String xpath) { [EOL]     return new JXPathCompiledExpression(xpath, compileExpression(xpath)); [EOL] } <line_num>: 204,206
private Expression compileExpression(String xpath) { [EOL]     Expression expr; [EOL]     synchronized (compiled) { [EOL]         if (USE_SOFT_CACHE) { [EOL]             expr = null; [EOL]             SoftReference ref = (SoftReference) compiled.get(xpath); [EOL]             if (ref != null) { [EOL]                 expr = (Expression) ref.get(); [EOL]             } [EOL]         } else { [EOL]             expr = (Expression) compiled.get(xpath); [EOL]         } [EOL]     } [EOL]     if (expr != null) { [EOL]         return expr; [EOL]     } [EOL]     expr = (Expression) Parser.parseExpression(xpath, getCompiler()); [EOL]     synchronized (compiled) { [EOL]         if (USE_SOFT_CACHE) { [EOL]             if (cleanupCount++ >= CLEANUP_THRESHOLD) { [EOL]                 Iterator it = compiled.entrySet().iterator(); [EOL]                 while (it.hasNext()) { [EOL]                     Entry me = (Entry) it.next(); [EOL]                     if (((SoftReference) me.getValue()).get() == null) { [EOL]                         it.remove(); [EOL]                     } [EOL]                 } [EOL]                 cleanupCount = 0; [EOL]             } [EOL]             compiled.put(xpath, new SoftReference(expr)); [EOL]         } else { [EOL]             compiled.put(xpath, expr); [EOL]         } [EOL]     } [EOL]     return expr; [EOL] } <line_num>: 208,250
public Object getValue(String xpath) { [EOL]     Expression expression = compileExpression(xpath); [EOL]     return getValue(xpath, expression); [EOL] } <line_num>: 256,291
public Object getValue(String xpath, Expression expr) { [EOL]     Object result = expr.computeValue(getEvalContext()); [EOL]     if (result == null) { [EOL]         if (expr instanceof Path) { [EOL]             if (!isLenient()) { [EOL]                 throw new JXPathNotFoundException("No value for xpath: " + xpath); [EOL]             } [EOL]         } [EOL]         return null; [EOL]     } [EOL]     if (result instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) result; [EOL]         result = ctx.getSingleNodePointer(); [EOL]         if (!isLenient() && result == null) { [EOL]             throw new JXPathNotFoundException("No value for xpath: " + xpath); [EOL]         } [EOL]     } [EOL]     if (result instanceof NodePointer) { [EOL]         result = ((NodePointer) result).getValuePointer(); [EOL]         if (!isLenient() && !((NodePointer) result).isActual()) { [EOL]             NodePointer parent = ((NodePointer) result).getImmediateParentPointer(); [EOL]             if (parent == null || !parent.isContainer() || !parent.isActual()) { [EOL]                 throw new JXPathNotFoundException("No value for xpath: " + xpath); [EOL]             } [EOL]         } [EOL]         result = ((NodePointer) result).getValue(); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 323,363
public Object getValue(String xpath, Class requiredType) { [EOL]     Expression expr = compileExpression(xpath); [EOL]     return getValue(xpath, expr, requiredType); [EOL] } <line_num>: 369,372
public Object getValue(String xpath, Expression expr, Class requiredType) { [EOL]     Object value = getValue(xpath, expr); [EOL]     if (value != null && requiredType != null) { [EOL]         if (!TypeUtils.canConvert(value, requiredType)) { [EOL]             throw new JXPathTypeConversionException("Invalid expression type. '" + xpath + "' returns " + value.getClass().getName() + ". It cannot be converted to " + requiredType.getName()); [EOL]         } [EOL]         value = TypeUtils.convert(value, requiredType); [EOL]     } [EOL]     return value; [EOL] } <line_num>: 374,389
public Iterator iterate(String xpath) { [EOL]     return iterate(xpath, compileExpression(xpath)); [EOL] } <line_num>: 396,398
public Iterator iterate(String xpath, Expression expr) { [EOL]     return expr.iterate(getEvalContext()); [EOL] } <line_num>: 400,402
public Pointer getPointer(String xpath) { [EOL]     return getPointer(xpath, compileExpression(xpath)); [EOL] } <line_num>: 404,406
public Pointer getPointer(String xpath, Expression expr) { [EOL]     Object result = expr.computeValue(getEvalContext()); [EOL]     if (result instanceof EvalContext) { [EOL]         result = ((EvalContext) result).getSingleNodePointer(); [EOL]     } [EOL]     if (result instanceof Pointer) { [EOL]         if (!isLenient() && !((NodePointer) result).isActual()) { [EOL]             throw new JXPathNotFoundException("No pointer for xpath: " + xpath); [EOL]         } [EOL]         return (Pointer) result; [EOL]     } else { [EOL]         return NodePointer.newNodePointer(null, result, getLocale()); [EOL]     } [EOL] } <line_num>: 408,423
public void setValue(String xpath, Object value) { [EOL]     setValue(xpath, compileExpression(xpath), value); [EOL] } <line_num>: 425,427
public void setValue(String xpath, Expression expr, Object value) { [EOL]     try { [EOL]         setValue(xpath, expr, value, false); [EOL]     } catch (Throwable ex) { [EOL]         throw new JXPathException("Exception trying to set value with xpath " + xpath, ex); [EOL]     } [EOL] } <line_num>: 430,438
public Pointer createPath(String xpath) { [EOL]     return createPath(xpath, compileExpression(xpath)); [EOL] } <line_num>: 440,442
public Pointer createPath(String xpath, Expression expr) { [EOL]     try { [EOL]         Object result = expr.computeValue(getEvalContext()); [EOL]         Pointer pointer = null; [EOL]         if (result instanceof Pointer) { [EOL]             pointer = (Pointer) result; [EOL]         } else if (result instanceof EvalContext) { [EOL]             EvalContext ctx = (EvalContext) result; [EOL]             pointer = ctx.getSingleNodePointer(); [EOL]         } else { [EOL]             checkSimplePath(expr); [EOL]             throw new JXPathException("Cannot create path:" + xpath); [EOL]         } [EOL]         return ((NodePointer) pointer).createPath(this); [EOL]     } catch (Throwable ex) { [EOL]         throw new JXPathException("Exception trying to create xpath " + xpath, ex); [EOL]     } [EOL] } <line_num>: 444,468
public Pointer createPathAndSetValue(String xpath, Object value) { [EOL]     return createPathAndSetValue(xpath, compileExpression(xpath), value); [EOL] } <line_num>: 470,472
public Pointer createPathAndSetValue(String xpath, Expression expr, Object value) { [EOL]     try { [EOL]         return setValue(xpath, expr, value, true); [EOL]     } catch (Throwable ex) { [EOL]         throw new JXPathException("Exception trying to create xpath " + xpath, ex); [EOL]     } [EOL] } <line_num>: 474,487
private Pointer setValue(String xpath, Expression expr, Object value, boolean create) { [EOL]     Object result = expr.computeValue(getEvalContext()); [EOL]     Pointer pointer = null; [EOL]     if (result instanceof Pointer) { [EOL]         pointer = (Pointer) result; [EOL]     } else if (result instanceof EvalContext) { [EOL]         EvalContext ctx = (EvalContext) result; [EOL]         pointer = ctx.getSingleNodePointer(); [EOL]     } else { [EOL]         if (create) { [EOL]             checkSimplePath(expr); [EOL]         } [EOL]         throw new JXPathException("Cannot set value for xpath: " + xpath); [EOL]     } [EOL]     if (create) { [EOL]         pointer = ((NodePointer) pointer).createPath(this, value); [EOL]     } else { [EOL]         pointer.setValue(value); [EOL]     } [EOL]     return pointer; [EOL] } <line_num>: 489,520
private void checkSimplePath(Expression expr) { [EOL]     if (!(expr instanceof LocationPath) || !((LocationPath) expr).isSimplePath()) { [EOL]         throw new JXPathInvalidSyntaxException("JXPath can only create a path if it uses exclusively " + "the child:: and attribute:: axes and has " + "no context-dependent predicates"); [EOL]     } [EOL] } <line_num>: 526,534
public Iterator iteratePointers(String xpath) { [EOL]     return iteratePointers(xpath, compileExpression(xpath)); [EOL] } <line_num>: 542,544
public Iterator iteratePointers(String xpath, Expression expr) { [EOL]     return expr.iteratePointers(getEvalContext()); [EOL] } <line_num>: 546,548
public void removePath(String xpath) { [EOL]     removePath(xpath, compileExpression(xpath)); [EOL] } <line_num>: 550,552
public void removePath(String xpath, Expression expr) { [EOL]     try { [EOL]         NodePointer pointer = (NodePointer) getPointer(xpath, expr); [EOL]         if (pointer != null) { [EOL]             ((NodePointer) pointer).remove(); [EOL]         } [EOL]     } catch (Throwable ex) { [EOL]         throw new JXPathException("Exception trying to remove xpath " + xpath, ex); [EOL]     } [EOL] } <line_num>: 554,566
public void removeAll(String xpath) { [EOL]     removeAll(xpath, compileExpression(xpath)); [EOL] } <line_num>: 568,570
public void removeAll(String xpath, Expression expr) { [EOL]     try { [EOL]         ArrayList list = new ArrayList(); [EOL]         Iterator it = expr.iteratePointers(getEvalContext()); [EOL]         while (it.hasNext()) { [EOL]             list.add(it.next()); [EOL]         } [EOL]         Collections.sort(list); [EOL]         for (int i = list.size() - 1; i >= 0; i--) { [EOL]             NodePointer pointer = (NodePointer) list.get(i); [EOL]             pointer.remove(); [EOL]         } [EOL]     } catch (Throwable ex) { [EOL]         throw new JXPathException("Exception trying to remove all for xpath " + xpath, ex); [EOL]     } [EOL] } <line_num>: 572,590
public JXPathContext getRelativeContext(Pointer pointer) { [EOL]     Object contextBean = pointer.getNode(); [EOL]     if (contextBean == null) { [EOL]         throw new JXPathException("Cannot create a relative context for a non-existent node: " + pointer); [EOL]     } [EOL]     return new JXPathContextReferenceImpl(this, contextBean, pointer); [EOL] } <line_num>: 592,600
public Pointer getContextPointer() { [EOL]     return contextPointer; [EOL] } <line_num>: 602,604
private NodePointer getAbsoluteRootPointer() { [EOL]     return (NodePointer) rootPointer; [EOL] } <line_num>: 606,608
private EvalContext getEvalContext() { [EOL]     return new InitialContext(new RootContext(this, (NodePointer) getContextPointer())); [EOL] } <line_num>: 610,613
public EvalContext getAbsoluteRootContext() { [EOL]     return new InitialContext(new RootContext(this, getAbsoluteRootPointer())); [EOL] } <line_num>: 615,618
public NodePointer getVariablePointer(QName name) { [EOL]     String varName = name.toString(); [EOL]     JXPathContext varCtx = this; [EOL]     Variables vars = null; [EOL]     while (varCtx != null) { [EOL]         vars = varCtx.getVariables(); [EOL]         if (vars.isDeclaredVariable(varName)) { [EOL]             break; [EOL]         } [EOL]         varCtx = varCtx.getParentContext(); [EOL]         vars = null; [EOL]     } [EOL]     if (vars != null) { [EOL]         return new VariablePointer(vars, name); [EOL]     } else { [EOL]         return new VariablePointer(name); [EOL]     } [EOL] } <line_num>: 620,641
public Function getFunction(QName functionName, Object[] parameters) { [EOL]     String namespace = functionName.getPrefix(); [EOL]     String name = functionName.getName(); [EOL]     JXPathContext funcCtx = this; [EOL]     Function func = null; [EOL]     Functions funcs; [EOL]     while (funcCtx != null) { [EOL]         funcs = funcCtx.getFunctions(); [EOL]         if (funcs != null) { [EOL]             func = funcs.getFunction(namespace, name, parameters); [EOL]             if (func != null) { [EOL]                 return func; [EOL]             } [EOL]         } [EOL]         funcCtx = funcCtx.getParentContext(); [EOL]     } [EOL]     throw new JXPathFunctionNotFoundException("Undefined function: " + functionName.toString()); [EOL] } <line_num>: 643,661
public void registerNamespace(String prefix, String namespaceURI) { [EOL]     if (namespaceResolver.isSealed()) { [EOL]         namespaceResolver = (NamespaceResolver) namespaceResolver.clone(); [EOL]     } [EOL]     namespaceResolver.registerNamespace(prefix, namespaceURI); [EOL] } <line_num>: 663,668
public String getNamespaceURI(String prefix) { [EOL]     return namespaceResolver.getNamespaceURI(prefix); [EOL] } <line_num>: 670,672
public void setNamespaceContextPointer(Pointer pointer) { [EOL]     if (namespaceResolver.isSealed()) { [EOL]         namespaceResolver = (NamespaceResolver) namespaceResolver.clone(); [EOL]     } [EOL]     namespaceResolver.setNamespaceContextPointer((NodePointer) pointer); [EOL] } <line_num>: 674,679
public Pointer getNamespaceContextPointer() { [EOL]     return namespaceResolver.getNamespaceContextPointer(); [EOL] } <line_num>: 681,683
public NamespaceResolver getNamespaceResolver() { [EOL]     namespaceResolver.seal(); [EOL]     namespaceResolver.registerDefaultNamespaceURI(getDefaultNamespaceURI()); [EOL]     return namespaceResolver; [EOL] } <line_num>: 685,689
public String getDefaultNamespaceURI() { [EOL]     if (defaultNamespaceURI != null) { [EOL]         return defaultNamespaceURI; [EOL]     } [EOL]     if (parentContext != null) { [EOL]         return parentContext.getDefaultNamespaceURI(); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 691,700
public void registerDefaultNamespace(String uri) { [EOL]     defaultNamespaceURI = uri; [EOL] } <line_num>: 702,704
public static Object allocateConditionally(String className, String existenceCheckClassName) { [EOL]     try { [EOL]         try { [EOL]             Class.forName(existenceCheckClassName); [EOL]         } catch (ClassNotFoundException ex) { [EOL]             return null; [EOL]         } [EOL]         Class cls = Class.forName(className); [EOL]         return cls.newInstance(); [EOL]     } catch (Exception ex) { [EOL]         throw new JXPathException("Cannot allocate " + className, ex); [EOL]     } [EOL] } <line_num>: 710,728
