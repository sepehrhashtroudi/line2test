public PeepholeReplaceKnownMethodsTest() { [EOL]     super(""); [EOL] } <line_num>: 27,29
@Override [EOL] public void setUp() { [EOL]     enableLineNumberCheck(true); [EOL] } <line_num>: 31,34
@Override [EOL] public CompilerPass getProcessor(final Compiler compiler) { [EOL]     CompilerPass peepholePass = new PeepholeOptimizationsPass(compiler, new PeepholeReplaceKnownMethods(late)); [EOL]     return peepholePass; [EOL] } <line_num>: 36,41
public void testStringIndexOf() { [EOL]     fold("x = 'abcdef'.indexOf('b')", "x = 1"); [EOL]     fold("x = 'abcdefbe'.indexOf('b', 2)", "x = 6"); [EOL]     fold("x = 'abcdef'.indexOf('bcd')", "x = 1"); [EOL]     fold("x = 'abcdefsdfasdfbcdassd'.indexOf('bcd', 4)", "x = 13"); [EOL]     fold("x = 'abcdef'.lastIndexOf('b')", "x = 1"); [EOL]     fold("x = 'abcdefbe'.lastIndexOf('b')", "x = 6"); [EOL]     fold("x = 'abcdefbe'.lastIndexOf('b', 5)", "x = 1"); [EOL]     fold("x = 'abc1def'.indexOf(1)", "x = 3"); [EOL]     fold("x = 'abcNaNdef'.indexOf(NaN)", "x = 3"); [EOL]     fold("x = 'abcundefineddef'.indexOf(undefined)", "x = 3"); [EOL]     fold("x = 'abcnulldef'.indexOf(null)", "x = 3"); [EOL]     fold("x = 'abctruedef'.indexOf(true)", "x = 3"); [EOL]     foldSame("x = NaN.indexOf('bcd')"); [EOL]     foldSame("x = undefined.indexOf('bcd')"); [EOL]     foldSame("x = null.indexOf('bcd')"); [EOL]     foldSame("x = true.indexOf('bcd')"); [EOL]     foldSame("x = false.indexOf('bcd')"); [EOL]     foldSame("x = 'abcdef'.indexOf(/b./)"); [EOL]     foldSame("x = 'abcdef'.indexOf({a:2})"); [EOL]     foldSame("x = 'abcdef'.indexOf([1,2])"); [EOL] } <line_num>: 43,73
public void testStringJoinAddSparse() { [EOL]     fold("x = [,,'a'].join(',')", "x = ',,a'"); [EOL] } <line_num>: 75,77
public void testNoStringJoin() { [EOL]     foldSame("x = [].join(',',2)"); [EOL]     foldSame("x = [].join(f)"); [EOL] } <line_num>: 79,82
public void testStringJoinAdd() { [EOL]     fold("x = ['a', 'b', 'c'].join('')", "x = \"abc\""); [EOL]     fold("x = [].join(',')", "x = \"\""); [EOL]     fold("x = ['a'].join(',')", "x = \"a\""); [EOL]     fold("x = ['a', 'b', 'c'].join(',')", "x = \"a,b,c\""); [EOL]     fold("x = ['a', foo, 'b', 'c'].join(',')", "x = [\"a\",foo,\"b,c\"].join()"); [EOL]     fold("x = [foo, 'a', 'b', 'c'].join(',')", "x = [foo,\"a,b,c\"].join()"); [EOL]     fold("x = ['a', 'b', 'c', foo].join(',')", "x = [\"a,b,c\",foo].join()"); [EOL]     fold("x = ['a=', 5].join('')", "x = \"a=5\""); [EOL]     fold("x = ['a', '5'].join(7)", "x = \"a75\""); [EOL]     fold("x = ['a=', false].join('')", "x = \"a=false\""); [EOL]     fold("x = ['a', '5'].join(true)", "x = \"atrue5\""); [EOL]     fold("x = ['a', '5'].join(false)", "x = \"afalse5\""); [EOL]     fold("x = ['a', '5', 'c'].join('a very very very long chain')", "x = [\"a\",\"5\",\"c\"].join(\"a very very very long chain\")"); [EOL]     foldSame("x = ['', foo].join('-')"); [EOL]     foldSame("x = ['', foo, ''].join()"); [EOL]     fold("x = ['', '', foo, ''].join(',')", "x = [',', foo, ''].join()"); [EOL]     fold("x = ['', '', foo, '', ''].join(',')", "x = [',', foo, ','].join()"); [EOL]     fold("x = ['', '', foo, '', '', bar].join(',')", "x = [',', foo, ',', bar].join()"); [EOL]     fold("x = [1,2,3].join('abcdef')", "x = '1abcdef2abcdef3'"); [EOL]     fold("x = [1,2].join()", "x = '1,2'"); [EOL]     fold("x = [null,undefined,''].join(',')", "x = ',,'"); [EOL]     fold("x = [null,undefined,0].join(',')", "x = ',,0'"); [EOL]     foldSame("x = [[1,2],[3,4]].join()"); [EOL] } <line_num>: 84,129
public void testStringJoinAdd_b1992789() { [EOL]     fold("x = ['a'].join('')", "x = \"a\""); [EOL]     fold("x = [foo()].join('')", "x = '' + foo()"); [EOL]     fold("[foo()].join('')", "'' + foo()"); [EOL] } <line_num>: 131,135
public void testFoldStringSubstr() { [EOL]     fold("x = 'abcde'.substr(0,2)", "x = 'ab'"); [EOL]     fold("x = 'abcde'.substr(1,2)", "x = 'bc'"); [EOL]     fold("x = 'abcde'['substr'](1,3)", "x = 'bcd'"); [EOL]     fold("x = 'abcde'.substr(2)", "x = 'cde'"); [EOL]     foldSame("x = 'abcde'.substr(-1)"); [EOL]     foldSame("x = 'abcde'.substr(1, -2)"); [EOL]     foldSame("x = 'abcde'.substr(1, 2, 3)"); [EOL]     foldSame("x = 'a'.substr(0, 2)"); [EOL] } <line_num>: 137,148
public void testFoldStringSubstring() { [EOL]     fold("x = 'abcde'.substring(0,2)", "x = 'ab'"); [EOL]     fold("x = 'abcde'.substring(1,2)", "x = 'b'"); [EOL]     fold("x = 'abcde'['substring'](1,3)", "x = 'bc'"); [EOL]     fold("x = 'abcde'.substring(2)", "x = 'cde'"); [EOL]     foldSame("x = 'abcde'.substring(-1)"); [EOL]     foldSame("x = 'abcde'.substring(1, -2)"); [EOL]     foldSame("x = 'abcde'.substring(1, 2, 3)"); [EOL]     foldSame("x = 'a'.substring(0, 2)"); [EOL] } <line_num>: 150,161
public void testFoldStringCharAt() { [EOL]     fold("x = 'abcde'.charAt(0)", "x = 'a'"); [EOL]     fold("x = 'abcde'.charAt(1)", "x = 'b'"); [EOL]     fold("x = 'abcde'.charAt(2)", "x = 'c'"); [EOL]     fold("x = 'abcde'.charAt(3)", "x = 'd'"); [EOL]     fold("x = 'abcde'.charAt(4)", "x = 'e'"); [EOL]     foldSame("x = 'abcde'.charAt(5)"); [EOL]     foldSame("x = 'abcde'.charAt(-1)"); [EOL]     foldSame("x = 'abcde'.charAt(y)"); [EOL]     foldSame("x = 'abcde'.charAt()"); [EOL]     foldSame("x = 'abcde'.charAt(0, ++z)"); [EOL]     foldSame("x = 'abcde'.charAt(null)"); [EOL]     foldSame("x = 'abcde'.charAt(true)"); [EOL]     fold("x = '\\ud834\udd1e'.charAt(0)", "x = '\\ud834'"); [EOL]     fold("x = '\\ud834\udd1e'.charAt(1)", "x = '\\udd1e'"); [EOL] } <line_num>: 163,178
public void testFoldStringCharCodeAt() { [EOL]     fold("x = 'abcde'.charCodeAt(0)", "x = 97"); [EOL]     fold("x = 'abcde'.charCodeAt(1)", "x = 98"); [EOL]     fold("x = 'abcde'.charCodeAt(2)", "x = 99"); [EOL]     fold("x = 'abcde'.charCodeAt(3)", "x = 100"); [EOL]     fold("x = 'abcde'.charCodeAt(4)", "x = 101"); [EOL]     foldSame("x = 'abcde'.charCodeAt(5)"); [EOL]     foldSame("x = 'abcde'.charCodeAt(-1)"); [EOL]     foldSame("x = 'abcde'.charCodeAt(y)"); [EOL]     foldSame("x = 'abcde'.charCodeAt()"); [EOL]     foldSame("x = 'abcde'.charCodeAt(0, ++z)"); [EOL]     foldSame("x = 'abcde'.charCodeAt(null)"); [EOL]     foldSame("x = 'abcde'.charCodeAt(true)"); [EOL]     fold("x = '\\ud834\udd1e'.charCodeAt(0)", "x = 55348"); [EOL]     fold("x = '\\ud834\udd1e'.charCodeAt(1)", "x = 56606"); [EOL] } <line_num>: 180,195
public void testFoldStringSplit() { [EOL]     late = false; [EOL]     fold("x = 'abcde'.split('foo')", "x = ['abcde']"); [EOL]     fold("x = 'abcde'.split()", "x = ['abcde']"); [EOL]     fold("x = 'abcde'.split(null)", "x = ['abcde']"); [EOL]     fold("x = 'a b c d e'.split(' ')", "x = ['a','b','c','d','e']"); [EOL]     fold("x = 'a b c d e'.split(' ', 0)", "x = []"); [EOL]     fold("x = 'abcde'.split('cd')", "x = ['ab','e']"); [EOL]     fold("x = 'a b c d e'.split(' ', 1)", "x = ['a']"); [EOL]     fold("x = 'a b c d e'.split(' ', 3)", "x = ['a','b','c']"); [EOL]     fold("x = 'a b c d e'.split(null, 1)", "x = ['a b c d e']"); [EOL]     fold("x = 'aaaaa'.split('a')", "x = ['', '', '', '', '', '']"); [EOL]     fold("x = 'xyx'.split('x')", "x = ['', 'y', '']"); [EOL]     fold("x = 'abcde'.split('')", "x = ['a','b','c','d','e']"); [EOL]     fold("x = 'abcde'.split('', 3)", "x = ['a','b','c']"); [EOL]     fold("x = ''.split('')", "x = []"); [EOL]     fold("x = 'aaa'.split('aaa')", "x = ['','']"); [EOL]     fold("x = ' '.split(' ')", "x = ['','']"); [EOL]     foldSame("x = 'abcde'.split(/ /)"); [EOL]     foldSame("x = 'abcde'.split(' ', -1)"); [EOL]     late = true; [EOL]     foldSame("x = 'a b c d e'.split(' ')"); [EOL] } <line_num>: 197,227
public void testJoinBug() { [EOL]     fold("var x = [].join();", "var x = '';"); [EOL]     fold("var x = [x].join();", "var x = '' + x;"); [EOL]     foldSame("var x = [x,y].join();"); [EOL]     foldSame("var x = [x,y,z].join();"); [EOL]     foldSame("shape['matrix'] = [\n" + "    Number(headingCos2).toFixed(4),\n" + "    Number(-headingSin2).toFixed(4),\n" + "    Number(headingSin2 * yScale).toFixed(4),\n" + "    Number(headingCos2 * yScale).toFixed(4),\n" + "    0,\n" + "    0\n" + "  ].join()"); [EOL] } <line_num>: 229,243
public void testToUpper() { [EOL]     fold("'a'.toUpperCase()", "'A'"); [EOL]     fold("'A'.toUpperCase()", "'A'"); [EOL]     fold("'aBcDe'.toUpperCase()", "'ABCDE'"); [EOL] } <line_num>: 245,249
public void testToLower() { [EOL]     fold("'A'.toLowerCase()", "'a'"); [EOL]     fold("'a'.toLowerCase()", "'a'"); [EOL]     fold("'aBcDe'.toLowerCase()", "'abcde'"); [EOL] } <line_num>: 251,255
public void testFoldParseNumbers() { [EOL]     enableNormalize(); [EOL]     enableEcmaScript5(true); [EOL]     fold("x = parseInt('123')", "x = 123"); [EOL]     fold("x = parseInt(' 123')", "x = 123"); [EOL]     fold("x = parseInt('123', 10)", "x = 123"); [EOL]     fold("x = parseInt('0xA')", "x = 10"); [EOL]     fold("x = parseInt('0xA', 16)", "x = 10"); [EOL]     fold("x = parseInt('07', 8)", "x = 7"); [EOL]     fold("x = parseInt('08')", "x = 8"); [EOL]     fold("x = parseInt('0')", "x = 0"); [EOL]     fold("x = parseFloat('0')", "x = 0"); [EOL]     fold("x = parseFloat('1.23')", "x = 1.23"); [EOL]     fold("x = parseFloat('1.2300')", "x = 1.23"); [EOL]     fold("x = parseFloat(' 0.3333')", "x = 0.3333"); [EOL]     fold("x = parseFloat('0100')", "x = 100"); [EOL]     fold("x = parseFloat('0100.000')", "x = 100"); [EOL]     fold("x = parseInt(' 0xF', 16)", "x = 15"); [EOL]     fold("x = parseInt(' F', 16)", "x = 15"); [EOL]     fold("x = parseInt('17', 8)", "x = 15"); [EOL]     fold("x = parseInt('015', 10)", "x = 15"); [EOL]     fold("x = parseInt('1111', 2)", "x = 15"); [EOL]     fold("x = parseInt('12', 13)", "x = 15"); [EOL]     fold("x = parseInt(021, 8)", "x = 15"); [EOL]     fold("x = parseInt(15.99, 10)", "x = 15"); [EOL]     fold("x = parseFloat('3.14')", "x = 3.14"); [EOL]     fold("x = parseFloat(3.14)", "x = 3.14"); [EOL]     foldSame("x = parseInt('FXX123', 16)"); [EOL]     foldSame("x = parseInt('15*3', 10)"); [EOL]     foldSame("x = parseInt('15e2', 10)"); [EOL]     foldSame("x = parseInt('15px', 10)"); [EOL]     foldSame("x = parseInt('-0x08')"); [EOL]     foldSame("x = parseInt('1', -1)"); [EOL]     foldSame("x = parseFloat('3.14more non-digit characters')"); [EOL]     foldSame("x = parseFloat('314e-2')"); [EOL]     foldSame("x = parseFloat('0.0314E+2')"); [EOL]     foldSame("x = parseFloat('3.333333333333333333333333')"); [EOL]     foldSame("x = parseInt('0xa', 10)"); [EOL]     foldSame("x = parseInt('')"); [EOL]     enableEcmaScript5(false); [EOL]     foldSame("x = parseInt('08')"); [EOL] } <line_num>: 257,306
@Override [EOL] protected int getNumRepetitions() { [EOL]     return 2; [EOL] } <line_num>: 308,312
private void foldSame(String js) { [EOL]     testSame(js); [EOL] } <line_num>: 314,316
private void fold(String js, String expected) { [EOL]     test(js, expected); [EOL] } <line_num>: 318,320