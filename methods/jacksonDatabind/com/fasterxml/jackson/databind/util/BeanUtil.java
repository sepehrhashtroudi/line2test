public static String okNameForGetter(AnnotatedMethod am) { [EOL]     String name = am.getName(); [EOL]     String str = okNameForIsGetter(am, name); [EOL]     if (str == null) { [EOL]         str = okNameForRegularGetter(am, name); [EOL]     } [EOL]     return str; [EOL] } <line_num>: 17,25
public static String okNameForRegularGetter(AnnotatedMethod am, String name) { [EOL]     if (name.startsWith("get")) { [EOL]         if ("getCallbacks".equals(name)) { [EOL]             if (isCglibGetCallbacks(am)) { [EOL]                 return null; [EOL]             } [EOL]         } else if ("getMetaClass".equals(name)) { [EOL]             if (isGroovyMetaClassGetter(am)) { [EOL]                 return null; [EOL]             } [EOL]         } [EOL]         return manglePropertyName(name.substring(3)); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 27,52
public static String okNameForIsGetter(AnnotatedMethod am, String name) { [EOL]     if (name.startsWith("is")) { [EOL]         Class<?> rt = am.getRawType(); [EOL]         if (rt != Boolean.class && rt != Boolean.TYPE) { [EOL]             return null; [EOL]         } [EOL]         return manglePropertyName(name.substring(2)); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 54,66
public static String okNameForSetter(AnnotatedMethod am) { [EOL]     String name = okNameForMutator(am, "set"); [EOL]     if (name != null) { [EOL]         if ("metaClass".equals(name)) { [EOL]             if (isGroovyMetaClassSetter(am)) { [EOL]                 return null; [EOL]             } [EOL]         } [EOL]         return name; [EOL]     } [EOL]     return null; [EOL] } <line_num>: 68,81
public static String okNameForMutator(AnnotatedMethod am, String prefix) { [EOL]     String name = am.getName(); [EOL]     if (name.startsWith(prefix)) { [EOL]         return manglePropertyName(name.substring(prefix.length())); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 83,90
protected static boolean isCglibGetCallbacks(AnnotatedMethod am) { [EOL]     Class<?> rt = am.getRawType(); [EOL]     if (rt == null || !rt.isArray()) { [EOL]         return false; [EOL]     } [EOL]     Class<?> compType = rt.getComponentType(); [EOL]     Package pkg = compType.getPackage(); [EOL]     if (pkg != null) { [EOL]         String pname = pkg.getName(); [EOL]         if (pname.startsWith("net.sf.cglib") || pname.startsWith("org.hibernate.repackage.cglib")) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 109,132
protected static boolean isGroovyMetaClassSetter(AnnotatedMethod am) { [EOL]     Class<?> argType = am.getRawParameterType(0); [EOL]     Package pkg = argType.getPackage(); [EOL]     if (pkg != null && pkg.getName().startsWith("groovy.lang")) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 138,146
protected static boolean isGroovyMetaClassGetter(AnnotatedMethod am) { [EOL]     Class<?> rt = am.getRawType(); [EOL]     if (rt == null || rt.isArray()) { [EOL]         return false; [EOL]     } [EOL]     Package pkg = rt.getPackage(); [EOL]     if (pkg != null && pkg.getName().startsWith("groovy.lang")) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 151,162
protected static String manglePropertyName(String basename) { [EOL]     int len = basename.length(); [EOL]     if (len == 0) { [EOL]         return null; [EOL]     } [EOL]     StringBuilder sb = null; [EOL]     for (int i = 0; i < len; ++i) { [EOL]         char upper = basename.charAt(i); [EOL]         char lower = Character.toLowerCase(upper); [EOL]         if (upper == lower) { [EOL]             break; [EOL]         } [EOL]         if (sb == null) { [EOL]             sb = new StringBuilder(basename); [EOL]         } [EOL]         sb.setCharAt(i, lower); [EOL]     } [EOL]     return (sb == null) ? basename : sb.toString(); [EOL] } <line_num>: 171,193