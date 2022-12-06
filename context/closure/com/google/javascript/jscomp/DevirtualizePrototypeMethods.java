 DevirtualizePrototypeMethods(AbstractCompiler compiler)
public void enableSpecialization(SpecializeModule.SpecializationState state)
public void process(Node externs, Node root)
public void process(Node externs, Node root, SimpleDefinitionFinder definitions)
private static boolean isCall(UseSite site)
private static boolean isPrototypeMethodDefinition(Node node)
private String getMethodName(Node node)
private String getRewrittenMethodName(String originalMethodName)
private void rewriteDefinitionIfEligible(DefinitionSite defSite, SimpleDefinitionFinder defFinder)
private boolean isEligibleDefinition(SimpleDefinitionFinder defFinder, DefinitionSite definitionSite)
private void rewriteCallSites(SimpleDefinitionFinder defFinder, Definition definition, String newMethodName)
private void rewriteDefinition(Node node, String newMethodName)
private void fixFunctionType(Node functionNode)
private void replaceReferencesToThis(Node node, String name)
AbstractCompiler compiler
SpecializeModule.SpecializationState specializationState