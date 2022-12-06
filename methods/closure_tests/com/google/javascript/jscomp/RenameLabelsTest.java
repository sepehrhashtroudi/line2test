@Override [EOL] protected CompilerPass getProcessor(Compiler compiler) { [EOL]     return new RenameLabels(compiler); [EOL] } <line_num>: 25,28
public void testRenameInFunction() { [EOL]     test("function x(){ Foo:a(); }", "function x(){ a(); }"); [EOL]     test("function x(){ Foo:{ a(); break Foo; } }", "function x(){ a:{ a(); break a; } }"); [EOL]     test("function x() { " + "Foo:{ " + "function goo() {" + "Foo: {" + "a(); " + "break Foo; " + "}" + "}" + "}" + "}", "function x(){function goo(){a:{ a(); break a; }}}"); [EOL]     test("function x() { " + "Foo:{ " + "function goo() {" + "Foo: {" + "a(); " + "break Foo; " + "}" + "}" + "break Foo;" + "}" + "}", "function x(){a:{function goo(){a:{ a(); break a; }} break a;}}"); [EOL] } <line_num>: 31,59
public void testRenameGlobals() { [EOL]     test("Foo:{a();}", "a();"); [EOL]     test("Foo:{a(); break Foo;}", "a:{a(); break a;}"); [EOL]     test("Foo:{Goo:a(); break Foo;}", "a:{a(); break a;}"); [EOL]     test("Foo:{Goo:while(1){a(); continue Goo; break Foo;}}", "a:{b:while(1){a(); continue b;break a;}}"); [EOL]     test("Foo:Goo:while(1){a(); continue Goo; break Foo;}", "a:b:while(1){a(); continue b;break a;}"); [EOL]     test("Foo:Bar:X:{ break Bar; }", "a:{ break a; }"); [EOL]     test("Foo:Bar:X:{ break Bar; break X; }", "a:b:{ break a; break b;}"); [EOL]     test("Foo:Bar:X:{ break Bar; break Foo; }", "a:b:{ break b; break a;}"); [EOL]     test("Foo:while (1){a(); break;}", "while (1){a(); break;}"); [EOL]     test("Foo:{a(); while (1) break;}", "a(); while (1) break;"); [EOL] } <line_num>: 61,86
public void testRenameReused() { [EOL]     test("foo:{break foo}; foo:{break foo}", "a:{break a};a:{break a}"); [EOL] } <line_num>: 88,90