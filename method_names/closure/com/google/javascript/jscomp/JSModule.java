public JSModule(String name)
public String getName()
public List<String> getProvides()
public List<String> getRequires()
public String getPathRelativeToClosureBase()
public void add(SourceFile file)
public void addFirst(SourceFile file)
public void add(CompilerInput input)
 void addAndOverrideModule(CompilerInput input)
public void addFirst(CompilerInput input)
public void addAfter(CompilerInput input, CompilerInput other)
public void addDependency(JSModule dep)
public void remove(CompilerInput input)
public void removeAll()
public List<JSModule> getDependencies()
 List<String> getSortedDependencyNames()
public Set<JSModule> getAllDependencies()
public Set<JSModule> getThisAndAllDependencies()
public List<CompilerInput> getInputs()
public CompilerInput getByName(String name)
public boolean removeByName(String name)
public String toString()
public void clearAsts()
public void sortInputsByDeps(Compiler compiler)
public static JSModule[] sortJsModules(Collection<JSModule> modules) throws CircularDependencyException
public void setDepth(int dep)
public int getDepth()
