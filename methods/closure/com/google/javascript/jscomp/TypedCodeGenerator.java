TypedCodeGenerator(CodeConsumer consumer, CompilerOptions options) { [EOL]     super(consumer, options); [EOL] } <line_num>: 34,36
@Override [EOL] void add(Node n, Context context) { [EOL]     Node parent = n.getParent(); [EOL]     if (parent != null && (parent.isBlock() || parent.isScript())) { [EOL]         if (n.isFunction()) { [EOL]             add(getFunctionAnnotation(n)); [EOL]         } else if (n.isExprResult() && n.getFirstChild().isAssign()) { [EOL]             Node rhs = n.getFirstChild().getLastChild(); [EOL]             add(getTypeAnnotation(rhs)); [EOL]         } else if (n.isVar() && n.getFirstChild().getFirstChild() != null) { [EOL]             add(getTypeAnnotation(n.getFirstChild().getFirstChild())); [EOL]         } [EOL]     } [EOL]     super.add(n, context); [EOL] } <line_num>: 38,57
private String getTypeAnnotation(Node node) { [EOL]     JSDocInfo jsdoc = NodeUtil.getBestJSDocInfo(node); [EOL]     if (jsdoc == null && !node.isFunction()) { [EOL]         return ""; [EOL]     } [EOL]     JSType type = node.getJSType(); [EOL]     if (type == null) { [EOL]         return ""; [EOL]     } else if (type.isFunctionType()) { [EOL]         return getFunctionAnnotation(node); [EOL]     } else if (type.isEnumType()) { [EOL]         return "/** @enum {" + type.toMaybeEnumType().getElementsType().toAnnotationString() + "} */\n"; [EOL]     } else if (!type.isUnknownType() && !type.isEmptyType() && !type.isVoidType() && !type.isFunctionPrototypeType()) { [EOL]         return "/** @type {" + node.getJSType().toAnnotationString() + "} */\n"; [EOL]     } else { [EOL]         return ""; [EOL]     } [EOL] } <line_num>: 59,83
private String getFunctionAnnotation(Node fnNode) { [EOL]     Preconditions.checkState(fnNode.isFunction()); [EOL]     StringBuilder sb = new StringBuilder("/**\n"); [EOL]     JSType type = fnNode.getJSType(); [EOL]     if (type == null || type.isUnknownType()) { [EOL]         return ""; [EOL]     } [EOL]     FunctionType funType = type.toMaybeFunctionType(); [EOL]     if (fnNode != null) { [EOL]         Node paramNode = NodeUtil.getFunctionParameters(fnNode).getFirstChild(); [EOL]         for (Node n : funType.getParameters()) { [EOL]             if (paramNode == null) { [EOL]                 break; [EOL]             } [EOL]             sb.append(" * "); [EOL]             appendAnnotation(sb, "param", getParameterNodeJSDocType(n)); [EOL]             sb.append(" ").append(paramNode.getString()).append("\n"); [EOL]             paramNode = paramNode.getNext(); [EOL]         } [EOL]     } [EOL]     JSType retType = funType.getReturnType(); [EOL]     if (retType != null && !retType.isUnknownType() && !retType.isEmptyType()) { [EOL]         sb.append(" * "); [EOL]         appendAnnotation(sb, "return", retType.toAnnotationString()); [EOL]         sb.append("\n"); [EOL]     } [EOL]     if (funType.isConstructor() || funType.isInterface()) { [EOL]         FunctionType superConstructor = funType.getSuperClassConstructor(); [EOL]         if (superConstructor != null) { [EOL]             ObjectType superInstance = funType.getSuperClassConstructor().getInstanceType(); [EOL]             if (!superInstance.toString().equals("Object")) { [EOL]                 sb.append(" * "); [EOL]                 appendAnnotation(sb, "extends", superInstance.toAnnotationString()); [EOL]                 sb.append("\n"); [EOL]             } [EOL]         } [EOL]         if (funType.isInterface()) { [EOL]             for (ObjectType interfaceType : funType.getExtendedInterfaces()) { [EOL]                 sb.append(" * "); [EOL]                 appendAnnotation(sb, "extends", interfaceType.toAnnotationString()); [EOL]                 sb.append("\n"); [EOL]             } [EOL]         } [EOL]         Set<String> interfaces = Sets.newTreeSet(); [EOL]         for (ObjectType interfaze : funType.getImplementedInterfaces()) { [EOL]             interfaces.add(interfaze.toAnnotationString()); [EOL]         } [EOL]         for (String interfaze : interfaces) { [EOL]             sb.append(" * "); [EOL]             appendAnnotation(sb, "implements", interfaze); [EOL]             sb.append("\n"); [EOL]         } [EOL]         if (funType.isConstructor()) { [EOL]             sb.append(" * @constructor\n"); [EOL]         } else if (funType.isInterface()) { [EOL]             sb.append(" * @interface\n"); [EOL]         } [EOL]     } [EOL]     if (fnNode != null && fnNode.getBooleanProp(Node.IS_DISPATCHER)) { [EOL]         sb.append(" * @javadispatch\n"); [EOL]     } [EOL]     sb.append(" */\n"); [EOL]     return sb.toString(); [EOL] } <line_num>: 88,180
private void appendAnnotation(StringBuilder sb, String name, String type) { [EOL]     sb.append("@").append(name).append(" {").append(type).append("}"); [EOL] } <line_num>: 182,184
private String getParameterNodeJSDocType(Node parameterNode) { [EOL]     JSType parameterType = parameterNode.getJSType(); [EOL]     String typeString; [EOL]     if (parameterType.isUnknownType()) { [EOL]         typeString = "*"; [EOL]     } else { [EOL]         if (parameterNode.isOptionalArg()) { [EOL]             typeString = parameterType.restrictByNotNullOrUndefined().toAnnotationString() + "="; [EOL]         } else if (parameterNode.isVarArgs()) { [EOL]             typeString = "..." + parameterType.restrictByNotNullOrUndefined().toAnnotationString(); [EOL]         } else { [EOL]             typeString = parameterType.toAnnotationString(); [EOL]         } [EOL]     } [EOL]     return typeString; [EOL] } <line_num>: 191,214
