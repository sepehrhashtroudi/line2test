public static void registerAtomicClass(Class beanClass) { [EOL]     byClass.put(beanClass, new JXPathBasicBeanInfo(beanClass, true)); [EOL] } <line_num>: 66,68
public static void registerDynamicClass(Class beanClass, Class dynamicPropertyHandlerClass) { [EOL]     JXPathBasicBeanInfo bi = new JXPathBasicBeanInfo(beanClass, dynamicPropertyHandlerClass); [EOL]     if (beanClass.isInterface()) { [EOL]         byInterface.put(beanClass, bi); [EOL]     } else { [EOL]         byClass.put(beanClass, bi); [EOL]     } [EOL] } <line_num>: 74,86
public static JXPathBeanInfo getBeanInfo(Class beanClass) { [EOL]     JXPathBeanInfo beanInfo = (JXPathBeanInfo) byClass.get(beanClass); [EOL]     if (beanInfo == null) { [EOL]         beanInfo = findDynamicBeanInfo(beanClass); [EOL]         if (beanInfo == null) { [EOL]             beanInfo = findInformant(beanClass); [EOL]             if (beanInfo == null) { [EOL]                 beanInfo = new JXPathBasicBeanInfo(beanClass); [EOL]             } [EOL]         } [EOL]         byClass.put(beanClass, beanInfo); [EOL]     } [EOL]     return beanInfo; [EOL] } <line_num>: 101,114
private static JXPathBeanInfo findDynamicBeanInfo(Class beanClass) { [EOL]     JXPathBeanInfo beanInfo = null; [EOL]     if (beanClass.isInterface()) { [EOL]         beanInfo = (JXPathBeanInfo) byInterface.get(beanClass); [EOL]         if (beanInfo != null && beanInfo.isDynamic()) { [EOL]             return beanInfo; [EOL]         } [EOL]     } [EOL]     Class[] interfaces = beanClass.getInterfaces(); [EOL]     if (interfaces != null) { [EOL]         for (int i = 0; i < interfaces.length; i++) { [EOL]             beanInfo = findDynamicBeanInfo(interfaces[i]); [EOL]             if (beanInfo != null && beanInfo.isDynamic()) { [EOL]                 return beanInfo; [EOL]             } [EOL]         } [EOL]     } [EOL]     Class sup = beanClass.getSuperclass(); [EOL]     if (sup != null) { [EOL]         beanInfo = (JXPathBeanInfo) byClass.get(sup); [EOL]         if (beanInfo != null && beanInfo.isDynamic()) { [EOL]             return beanInfo; [EOL]         } [EOL]         return findDynamicBeanInfo(sup); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 120,148
private static synchronized JXPathBeanInfo findInformant(Class beanClass) { [EOL]     String name = beanClass.getName() + "XBeanInfo"; [EOL]     try { [EOL]         return (JXPathBeanInfo) instantiate(beanClass, name); [EOL]     } catch (Exception ex) { [EOL]     } [EOL]     try { [EOL]         if (JXPathBeanInfo.class.isAssignableFrom(beanClass)) { [EOL]             return (JXPathBeanInfo) beanClass.newInstance(); [EOL]         } [EOL]     } catch (Exception ex) { [EOL]     } [EOL]     return null; [EOL] } <line_num>: 150,170
private static Object instantiate(Class sibling, String className) throws Exception { [EOL]     ClassLoader cl = sibling.getClassLoader(); [EOL]     if (cl != null) { [EOL]         try { [EOL]             Class cls = cl.loadClass(className); [EOL]             return cls.newInstance(); [EOL]         } catch (Exception ex) { [EOL]         } [EOL]     } [EOL]     Class cls = Class.forName(className); [EOL]     return cls.newInstance(); [EOL] } <line_num>: 177,196
