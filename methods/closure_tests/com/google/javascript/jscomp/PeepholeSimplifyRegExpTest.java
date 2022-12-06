public final void testWaysOfMatchingEmptyString() { [EOL]     testSame("/(?:)/"); [EOL]     test("/(?:)/i", "/(?:)/"); [EOL]     test("/.{0}/i", "/(?:)/"); [EOL]     test("/[^\\0-\\uffff]{0}/", "/(?:)/"); [EOL]     testSame("/(){0}/"); [EOL] } <line_num>: 23,30
public final void testCharsetOptimizations() { [EOL]     testSame("/./"); [EOL]     test("/[\\0-\\uffff]/", "/[\\S\\s]/"); [EOL]     test("/[^\\0-\\uffff]/", "/(?!)/"); [EOL]     test("/[^\\0-\\x40\\x42-\\uffff]/", "/A/"); [EOL]     test("/[0-9a-fA-F]/i", "/[\\da-f]/i"); [EOL]     test("/[0-9a-zA-Z_$]/i", "/[\\w$]/"); [EOL]     test("/[()*+\\-,]/g", "/[(--]/g"); [EOL]     test("/[()*+\\-,z]/g", "/[(--z]/g"); [EOL]     test("/[\\-\\.\\/0]/g", "/[--0]/g"); [EOL]     test("/[\\-\\.\\/0\\n]/g", "/[\\n\\--0]/g"); [EOL]     test("/[\\[\\\\\\]]/g", "/[[-\\]]/g"); [EOL]     test("/[\\[\\\\\\]\\^]/g", "/[[-^]/g"); [EOL]     test("/[\\^`_]/g", "/[\\^-`]/g"); [EOL]     test("/[^\\^`_]/g", "/[^^-`]/g"); [EOL]     test("/^(?=[^a-z])/i", "/^(?=[\\W\\d_])/"); [EOL]     test("/^[^a-z0-9]/i", "/^[\\W_]/"); [EOL]     test("/[0-FA-Z]/", "/[0-Z]/"); [EOL]     test("/[0-9]/", "/\\d/"); [EOL]     test("/[^0-9]/", "/\\D/"); [EOL]     testSame("/\\D/"); [EOL]     test("/[_a-z0-9]/i", "/\\w/"); [EOL]     test("/[0-9_a-z]/i", "/\\w/"); [EOL]     test("/[_a-z0-9]/", "/[\\d_a-z]/"); [EOL]     test("/[_E-Za-f0-9]/i", "/\\w/"); [EOL]     test("/[E-Za-f]/i", "/[a-z]/i"); [EOL]     test("/[_E-Za-f0-9]/", "/[\\dE-Z_a-f]/"); [EOL]     test("/[\\u00ca\\u00ea]/", "/[\\xca\\xea]/"); [EOL]     test("/[\\u00ca\\u00ea]/i", "/\\xca/i"); [EOL]     testSame("/^[\\s\\xa0]*$/"); [EOL]     test("/^(?:\\s|\\xA0)*$/", "/^[\\s\\xa0]*$/"); [EOL] } <line_num>: 32,67
public final void testCharsetFixup() { [EOL]     testSame("/[a-z]/i"); [EOL]     test("/[^\\0-`{-\\uffff]/i", "/(?!)/"); [EOL]     test("/[^a-z]/i", "/[\\W\\d_]/"); [EOL] } <line_num>: 69,85
public final void testGroups() { [EOL]     testSame("/foo(bar)baz/"); [EOL] } <line_num>: 87,89
public final void testBackReferences() { [EOL]     testSame("/foo(bar)baz(?:\\1|\\x01)boo/"); [EOL]     test("/foo(?:bar)baz(?:\\1|\\x01)boo/", "/foobarbaz\\x01boo/"); [EOL]     test("/foo(?:bar)baz(?:\\8|8)boo/", "/foobarbaz8boo/"); [EOL]     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\12\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)" + "\\1(?:2)\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); [EOL]     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(?:\\1)0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)\\1(?:0)/"); [EOL]     test("/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\012\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/", "/(1?)(2?)(3?)(4?)(5?)(6?)(7?)(8?)(9?)(A?)(B?)(C?)" + "\\n\\11\\10\\9\\8\\7\\6\\5\\4\\3\\2\\1\\0/"); [EOL] } <line_num>: 91,114
public final void testSingleCharAlterations() { [EOL]     test("/a|B|c|D/i", "/[a-d]/i"); [EOL]     test("/a|B|c|D/", "/[BDac]/"); [EOL]     test("/a|[Bc]|D/", "/[BDac]/"); [EOL]     test("/[aB]|[cD]/", "/[BDac]/"); [EOL]     test("/a|B|c|D|a|B/i", "/[a-d]/i"); [EOL]     test("/a|A|/i", "/a?/i"); [EOL] } <line_num>: 116,123
public final void testAlterations() { [EOL]     testSame("/foo|bar/"); [EOL]     test("/Foo|BAR/i", "/foo|bar/i"); [EOL]     test("/Foo||BAR/", "/Foo||BAR/"); [EOL]     test("/Foo|BAR|/", "/Foo|BAR|/"); [EOL] } <line_num>: 125,130
public final void testNestedAlterations() { [EOL]     test("/foo|bar|(?:baz|boo)|far/", "/foo|bar|baz|boo|far/"); [EOL] } <line_num>: 132,134
public final void testEscapeSequencesAndNonLatinChars() { [EOL]     test("/\u1234/i", "/\\u1234/"); [EOL]     testSame("/\\u1234/"); [EOL]     test("/\u00A0/", "/\\xa0/"); [EOL]     test("/\\u00A0/", "/\\xa0/"); [EOL]     test("/\\u00a0/", "/\\xa0/"); [EOL] } <line_num>: 136,142
public final void testAnchors() { [EOL]     testSame("/foo(?!$)/gm"); [EOL]     test("/./m", "/./"); [EOL]     test("/\\^/m", "/\\^/"); [EOL]     test("/[\\^]/m", "/\\^/"); [EOL]     testSame("/(^|foo)bar/"); [EOL]     testSame("/^.|.$/gm"); [EOL]     test("/foo(?=)$/m", "/foo$/m"); [EOL]     test("/^foo$/g", "/^foo$/"); [EOL] } <line_num>: 144,156
public final void testRepetitions() { [EOL]     testSame("/a*/"); [EOL]     testSame("/a+/"); [EOL]     testSame("/a+?/"); [EOL]     testSame("/a?/"); [EOL]     testSame("/a{6}/"); [EOL]     testSame("/a{4,}/"); [EOL]     test("/a{3,}/", "/aaa+/"); [EOL]     testSame("/a{4,6}/"); [EOL]     testSame("/a{4,6}?/"); [EOL]     test("/(?:a?)?/", "/a?/"); [EOL]     test("/(?:a?)*/", "/a*/"); [EOL]     test("/(?:a*)?/", "/a*/"); [EOL]     test("/a(?:a*)?/", "/a+/"); [EOL]     test("/(?:a{2,3}){3,4}/", "/a{6,12}/"); [EOL]     test("/a{2,3}a{3,4}/", "/a{5,7}/"); [EOL]     testSame("/a{5,7}b{5,6}/"); [EOL]     test("/a{2,3}b{3,4}/", "/aaa?bbbb?/"); [EOL]     test("/a{3}b{3,4}/", "/aaabbbb?/"); [EOL]     testSame("/[a-z]{1,2}/"); [EOL]     test("/\\d{1,2}/", "/\\d\\d?/"); [EOL]     test("/a*a*/", "/a*/"); [EOL]     test("/a+a+/", "/aa+/"); [EOL]     test("/a+a*/", "/a+/"); [EOL]     testSame("/a\\{3,1}/"); [EOL]     test("/a(?:{3,1})/", "/a\\{3,1}/"); [EOL]     test("/a{3\\,1}/", "/a\\{3,1}/"); [EOL]     testSame("/a\\{3}/"); [EOL]     testSame("/a\\{3,}/"); [EOL]     testSame("/a\\{1,3}/"); [EOL]     testSame("/a{/"); [EOL]     testSame("/a{}/"); [EOL]     testSame("/a{x}/"); [EOL]     testSame("/a{-1}/"); [EOL]     testSame("/a{,3}/"); [EOL]     testSame("/{{[a-z]+}}/"); [EOL]     testSame("/{\\{0}}/"); [EOL]     testSame("/{\\{0?}}/"); [EOL] } <line_num>: 158,202
public final void testMoreCharsets() { [EOL]     test("var a = /[\\x00\\x22\\x26\\x27\\x3c\\x3e]/g", "var a = /[\\0\"&'<>]/g"); [EOL]     test("var b = /[\\x00\\x22\\x27\\x3c\\x3e]/g", "var b = /[\\0\"'<>]/g"); [EOL]     test("var c = /[\\x00\\x09-\\x0d \\x22\\x26\\x27\\x2d\\/\\x3c-\\x3e`" + "\\x85\\xa0\\u2028\\u2029]/g", "var c = /[\\0\\t-\\r \"&'/<->`\\x85\\xa0\\u2028\\u2029-]/g"); [EOL]     test("var d = /[\\x00\\x09-\\x0d \\x22\\x27\\x2d\\/\\x3c-\\x3e`" + "\\x85\\xa0\\u2028\\u2029]/g", "var d = /[\\0\\t-\\r \"'/<->`\\x85\\xa0\\u2028\\u2029-]/g"); [EOL]     test("var e = /[\\x00\\x08-\\x0d\\x22\\x26\\x27\\/\\x3c-\\x3e\\\\" + "\\x85\\u2028\\u2029]/g", "var e = /[\\0\\b-\\r\"&'/<->\\\\\\x85\\u2028\\u2029]/g"); [EOL]     test("var f = /[\\x00\\x08-\\x0d\\x22\\x24\\x26-\\/\\x3a\\x3c-\\x3f" + "\\x5b-\\x5e\\x7b-\\x7d\\x85\\u2028\\u2029]/g", "var f = /[\\0\\b-\\r\"$&-/:<-?[-^{-}\\x85\\u2028\\u2029]/g"); [EOL]     test("var g = /[\\x00\\x08-\\x0d\\x22\\x26-\\x2a\\/\\x3a-\\x3e@\\\\" + "\\x7b\\x7d\\x85\\xa0\\u2028\\u2029]/g", "var g = /[\\0\\b-\\r\"&-*/:->@\\\\{}\\x85\\xa0\\u2028\\u2029]/g"); [EOL]     test("var h = /^(?!-*(?:expression|(?:moz-)?binding))(?:[.#]?-?" + "(?:[_a-z0-9][_a-z0-9-]*)(?:-[_a-z][_a-z0-9-]*)*-?|-?" + "(?:[0-9]+(?:\\.[0-9]*)?|\\.[0-9])(?:[a-z]{1,2}|%)?|!important|)$/i", "var h = /^(?!-*(?:expression|(?:moz-)?binding))(?:[#.]?-?" + "\\w[\\w-]*(?:-[_a-z][\\w-]*)*-?|-?" + "(?:\\d+(?:\\.\\d*)?|\\.\\d)(?:[a-z]{1,2}|%)?|!important|)$/i"); [EOL]     test("var i = /^(?:(?:https?|mailto):|[^&:\\/?#]*(?:[\\/?#]|$))/i", "var i = /^(?:(?:https?|mailto):|[^#&/:?]*(?:[#/?]|$))/i"); [EOL]     test("var j = /^(?!style|on|action|archive|background|cite|classid" + "|codebase|data|dsync|href|longdesc|src|usemap)(?:[a-z0-9_$:-]*" + "|dir=(?:ltr|rtl))$/i", "var j = /^(?!style|on|action|archive|background|cite|classid" + "|codebase|data|dsync|href|longdesc|src|usemap)(?:[\\w$:-]*" + "|dir=(?:ltr|rtl))$/i"); [EOL]     test("var k = /^(?!script|style|title|textarea|xmp|no)[a-z0-9_$:-]*$/i", "var k = /^(?!script|style|title|textarea|xmp|no)[\\w$:-]*$/i"); [EOL]     test("var l = /<(?:!|\\/?[a-z])(?:[^>'\"]|\"[^\"]*\"|'[^']*')*>/gi", "var l = /<(?:!|\\/?[a-z])(?:[^\"'>]|\"[^\"]*\"|'[^']*')*>/gi"); [EOL] } <line_num>: 204,242
public final void testMoreRegularExpression() { [EOL]     testSame("/\"/"); [EOL]     testSame("/'/"); [EOL]     test("/(?:[^<\\/\"'\\s\\\\]|<(?!\\/script))+/i", "/(?:[^\\s\"'/<\\\\]|<(?!\\/script))+/i"); [EOL]     testSame("/-->/"); [EOL]     testSame("/<!--/"); [EOL]     testSame("/<\\/(\\w+)\\b/"); [EOL]     testSame("/<\\/?/"); [EOL]     test("/<script(?=[\\s>\\/]|$)/i", "/<script(?=[\\s/>]|$)/i"); [EOL]     test("/<style(?=[\\s>\\/]|$)/i", "/<style(?=[\\s/>]|$)/i"); [EOL]     test("/<textarea(?=[\\s>\\/]|$)/i", "/<textarea(?=[\\s/>]|$)/i"); [EOL]     test("/<title(?=[\\s>\\/]|$)/i", "/<title(?=[\\s/>]|$)/i"); [EOL]     test("/<xmp(?=[\\s>\\/]|$)/i", "/<xmp(?=[\\s/>]|$)/i"); [EOL]     testSame("/[\"']/"); [EOL]     test("/[\\\\)\\s]/", "/[\\s)\\\\]/"); [EOL]     test("/[\\f\\r\\n\\u2028\\u2029]/", "/[\\n\\f\\r\\u2028\\u2029]/"); [EOL]     test("/[\\n\\r\\f]/", "/[\\n\\f\\r]/"); [EOL]     testSame("/\\*\\//"); [EOL]     testSame("/\\//"); [EOL]     testSame("/\\/\\*/"); [EOL]     testSame("/\\/\\//"); [EOL]     testSame("/\\\\(?:\\r\\n?|[\\n\\f\"])/"); [EOL]     testSame("/\\\\(?:\\r\\n?|[\\n\\f'])/"); [EOL]     testSame("/\\burl\\s*\\(\\s*([\"']?)/i"); [EOL]     testSame("/\\s+/"); [EOL]     test("/^(?:[^'\\\\\\n\\r\\u2028\\u2029<]|\\\\(?:\\r\\n?|[^\\r<]" + "|<(?!\\/script))|<(?!\\/script))/i", "/^(?:[^\\n\\r'<\\\\\\u2028\\u2029]|\\\\(?:\\r\\n?|[^\\r<]" + "|<(?!\\/script))|<(?!\\/script))/i"); [EOL]     test("/^(?:[^\\\"\\\\\\n\\r\\u2028\\u2029<]|\\\\(?:\\r\\n?" + "|[^\\r<]|<(?!\\/script))|<(?!\\/script))/i", "/^(?:[^\\n\\r\"<\\\\\\u2028\\u2029]|\\\\(?:\\r\\n?" + "|[^\\r<]|<(?!\\/script))|<(?!\\/script))/i"); [EOL]     test("/^(?:[^\\[\\\\\\/<\\n\\r\\u2028\\u2029]|\\\\[^\\n\\r\\u2028\\u2029]" + "|\\\\?<(?!\\/script)|\\[(?:[^\\]\\\\<\\n\\r\\u2028\\u2029]|" + "\\\\(?:[^\\n\\r\\u2028\\u2029]))*|\\\\?<(?!\\/script)\\])/i", "/^(?:[^\\n\\r/<[\\\\\\u2028\\u2029]|\\\\." + "|\\\\?<(?!\\/script)|\\[(?:[^\\n\\r<\\\\\\]\\u2028\\u2029]|" + "\\\\.)*|\\\\?<(?!\\/script)])/i"); [EOL]     testSame("/^(?=>|\\s+[\\w-]+\\s*=)/"); [EOL]     test("/^(?=[\\/\\s>])/", "/^(?=[\\s/>])/"); [EOL]     test("/^(?=[^\"'\\s>])/", "/^(?=[^\\s\"'>])/"); [EOL]     testSame("/^/"); [EOL]     testSame("/^[^<]+/"); [EOL]     test("/^[a-z0-9:-]*(?:[a-z0-9]|$)/i", "/^[\\d:a-z-]*(?:[^\\W_]|$)/i"); [EOL]     testSame("/^[a-z]+/i"); [EOL]     testSame("/^\\s*\"/"); [EOL]     testSame("/^\\s*'/"); [EOL]     testSame("/^\\s*([a-z][\\w-]*)/i"); [EOL]     testSame("/^\\s*=/"); [EOL]     testSame("/^\\s*\\/?>/"); [EOL]     testSame("/^\\s+$/"); [EOL]     testSame("/^\\s+/"); [EOL] } <line_num>: 244,298
public final void testPrecedence() { [EOL]     testSame("/ab?/"); [EOL]     testSame("/(?:ab)?/"); [EOL]     testSame("/foo|bar/"); [EOL]     testSame("/f(?:oo|ba)r/"); [EOL] } <line_num>: 300,307
public final void testMalformedRegularExpressions() { [EOL]     test("/(?<!foo)/", "/(?<!foo)/", null, CheckRegExp.MALFORMED_REGEXP); [EOL]     test("/(/", "/(/", null, CheckRegExp.MALFORMED_REGEXP); [EOL]     test("/)/", "/)/", null, CheckRegExp.MALFORMED_REGEXP); [EOL]     test("/\\uabc/", "/\\uabc/", null, CheckRegExp.MALFORMED_REGEXP); [EOL]     test("/\\uabcg/", "/\\uabcg/", null, CheckRegExp.MALFORMED_REGEXP); [EOL] } <line_num>: 309,330
@Override [EOL] public void process(Node externs, Node root) { [EOL]     checker.process(externs, root); [EOL]     simplifier.process(externs, root); [EOL] } <line_num>: 339,343
@Override [EOL] protected CompilerPass getProcessor(Compiler compiler) { [EOL]     final CompilerPass simplifier = new PeepholeOptimizationsPass(compiler, new PeepholeSimplifyRegExp()); [EOL]     final CompilerPass checker = new CheckRegExp(compiler); [EOL]     return new CompilerPass() { [EOL]  [EOL]         @Override [EOL]         public void process(Node externs, Node root) { [EOL]             checker.process(externs, root); [EOL]             simplifier.process(externs, root); [EOL]         } [EOL]     }; [EOL] } <line_num>: 332,345