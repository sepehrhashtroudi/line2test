private TarArchiveEntry() { [EOL]     this.magic = new StringBuffer(TMAGIC); [EOL]     this.name = new StringBuffer(); [EOL]     this.linkName = new StringBuffer(); [EOL]     String user = System.getProperty("user.name", ""); [EOL]     if (user.length() > MAX_NAMELEN) { [EOL]         user = user.substring(0, MAX_NAMELEN); [EOL]     } [EOL]     this.userId = 0; [EOL]     this.groupId = 0; [EOL]     this.userName = new StringBuffer(user); [EOL]     this.groupName = new StringBuffer(""); [EOL]     this.file = null; [EOL] } <line_num>: 134,150
public TarArchiveEntry(String name) { [EOL]     this(); [EOL]     name = normalizeFileName(name); [EOL]     boolean isDir = name.endsWith("/"); [EOL]     this.devMajor = 0; [EOL]     this.devMinor = 0; [EOL]     this.name = new StringBuffer(name); [EOL]     this.mode = isDir ? DEFAULT_DIR_MODE : DEFAULT_FILE_MODE; [EOL]     this.linkFlag = isDir ? LF_DIR : LF_NORMAL; [EOL]     this.userId = 0; [EOL]     this.groupId = 0; [EOL]     this.size = 0; [EOL]     this.modTime = (new Date()).getTime() / MILLIS_PER_SECOND; [EOL]     this.linkName = new StringBuffer(""); [EOL]     this.userName = new StringBuffer(""); [EOL]     this.groupName = new StringBuffer(""); [EOL]     this.devMajor = 0; [EOL]     this.devMinor = 0; [EOL] } <line_num>: 158,179
public TarArchiveEntry(String name, byte linkFlag) { [EOL]     this(name); [EOL]     this.linkFlag = linkFlag; [EOL] } <line_num>: 187,190
public TarArchiveEntry(File file) { [EOL]     this(); [EOL]     this.file = file; [EOL]     String fileName = normalizeFileName(file.getPath()); [EOL]     this.linkName = new StringBuffer(""); [EOL]     this.name = new StringBuffer(fileName); [EOL]     if (file.isDirectory()) { [EOL]         this.mode = DEFAULT_DIR_MODE; [EOL]         this.linkFlag = LF_DIR; [EOL]         int nameLength = name.length(); [EOL]         if (nameLength == 0 || name.charAt(nameLength - 1) != '/') { [EOL]             this.name.append("/"); [EOL]         } [EOL]         this.size = 0; [EOL]     } else { [EOL]         this.mode = DEFAULT_FILE_MODE; [EOL]         this.linkFlag = LF_NORMAL; [EOL]         this.size = file.length(); [EOL]     } [EOL]     this.modTime = file.lastModified() / MILLIS_PER_SECOND; [EOL]     this.devMajor = 0; [EOL]     this.devMinor = 0; [EOL] } <line_num>: 198,225
public TarArchiveEntry(byte[] headerBuf) { [EOL]     this(); [EOL]     parseTarHeader(headerBuf); [EOL] } <line_num>: 233,236
public boolean equals(TarArchiveEntry it) { [EOL]     return getName().equals(it.getName()); [EOL] } <line_num>: 245,247
public boolean equals(Object it) { [EOL]     if (it == null || getClass() != it.getClass()) { [EOL]         return false; [EOL]     } [EOL]     return equals((TarArchiveEntry) it); [EOL] } <line_num>: 256,261
public int hashCode() { [EOL]     return getName().hashCode(); [EOL] } <line_num>: 268,270
public boolean isDescendent(TarArchiveEntry desc) { [EOL]     return desc.getName().startsWith(getName()); [EOL] } <line_num>: 280,282
public String getName() { [EOL]     return name.toString(); [EOL] } <line_num>: 289,291
public void setName(String name) { [EOL]     this.name = new StringBuffer(normalizeFileName(name)); [EOL] } <line_num>: 298,300
public void setMode(int mode) { [EOL]     this.mode = mode; [EOL] } <line_num>: 307,309
public String getLinkName() { [EOL]     return linkName.toString(); [EOL] } <line_num>: 316,318
public int getUserId() { [EOL]     return userId; [EOL] } <line_num>: 325,327
public void setUserId(int userId) { [EOL]     this.userId = userId; [EOL] } <line_num>: 334,336
public int getGroupId() { [EOL]     return groupId; [EOL] } <line_num>: 343,345
public void setGroupId(int groupId) { [EOL]     this.groupId = groupId; [EOL] } <line_num>: 352,354
public String getUserName() { [EOL]     return userName.toString(); [EOL] } <line_num>: 361,363
public void setUserName(String userName) { [EOL]     this.userName = new StringBuffer(userName); [EOL] } <line_num>: 370,372
public String getGroupName() { [EOL]     return groupName.toString(); [EOL] } <line_num>: 379,381
public void setGroupName(String groupName) { [EOL]     this.groupName = new StringBuffer(groupName); [EOL] } <line_num>: 388,390
public void setIds(int userId, int groupId) { [EOL]     setUserId(userId); [EOL]     setGroupId(groupId); [EOL] } <line_num>: 398,401
public void setNames(String userName, String groupName) { [EOL]     setUserName(userName); [EOL]     setGroupName(groupName); [EOL] } <line_num>: 409,412
public void setModTime(long time) { [EOL]     modTime = time / MILLIS_PER_SECOND; [EOL] } <line_num>: 420,422
public void setModTime(Date time) { [EOL]     modTime = time.getTime() / MILLIS_PER_SECOND; [EOL] } <line_num>: 429,431
public Date getModTime() { [EOL]     return new Date(modTime * MILLIS_PER_SECOND); [EOL] } <line_num>: 438,440
public File getFile() { [EOL]     return file; [EOL] } <line_num>: 447,449
public int getMode() { [EOL]     return mode; [EOL] } <line_num>: 456,458
public long getSize() { [EOL]     return size; [EOL] } <line_num>: 465,467
public void setSize(long size) { [EOL]     this.size = size; [EOL] } <line_num>: 474,476
public boolean isGNULongNameEntry() { [EOL]     return linkFlag == LF_GNUTYPE_LONGNAME && name.toString().equals(GNU_LONGLINK); [EOL] } <line_num>: 484,487
public boolean isDirectory() { [EOL]     if (file != null) { [EOL]         return file.isDirectory(); [EOL]     } [EOL]     if (linkFlag == LF_DIR) { [EOL]         return true; [EOL]     } [EOL]     if (getName().endsWith("/")) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 494,508
public TarArchiveEntry[] getDirectoryEntries() { [EOL]     if (file == null || !file.isDirectory()) { [EOL]         return new TarArchiveEntry[0]; [EOL]     } [EOL]     String[] list = file.list(); [EOL]     TarArchiveEntry[] result = new TarArchiveEntry[list.length]; [EOL]     for (int i = 0; i < list.length; ++i) { [EOL]         result[i] = new TarArchiveEntry(new File(file, list[i])); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 516,529
public void writeEntryHeader(byte[] outbuf) { [EOL]     int offset = 0; [EOL]     offset = TarUtils.getNameBytes(name, outbuf, offset, NAMELEN); [EOL]     offset = TarUtils.getOctalBytes(mode, outbuf, offset, MODELEN); [EOL]     offset = TarUtils.getOctalBytes(userId, outbuf, offset, UIDLEN); [EOL]     offset = TarUtils.getOctalBytes(groupId, outbuf, offset, GIDLEN); [EOL]     offset = TarUtils.getLongOctalBytes(size, outbuf, offset, SIZELEN); [EOL]     offset = TarUtils.getLongOctalBytes(modTime, outbuf, offset, MODTIMELEN); [EOL]     int csOffset = offset; [EOL]     for (int c = 0; c < CHKSUMLEN; ++c) { [EOL]         outbuf[offset++] = (byte) ' '; [EOL]     } [EOL]     outbuf[offset++] = linkFlag; [EOL]     offset = TarUtils.getNameBytes(linkName, outbuf, offset, NAMELEN); [EOL]     offset = TarUtils.getNameBytes(magic, outbuf, offset, MAGICLEN); [EOL]     offset = TarUtils.getNameBytes(userName, outbuf, offset, UNAMELEN); [EOL]     offset = TarUtils.getNameBytes(groupName, outbuf, offset, GNAMELEN); [EOL]     offset = TarUtils.getOctalBytes(devMajor, outbuf, offset, DEVLEN); [EOL]     offset = TarUtils.getOctalBytes(devMinor, outbuf, offset, DEVLEN); [EOL]     while (offset < outbuf.length) { [EOL]         outbuf[offset++] = 0; [EOL]     } [EOL]     long chk = TarUtils.computeCheckSum(outbuf); [EOL]     TarUtils.getCheckSumOctalBytes(chk, outbuf, csOffset, CHKSUMLEN); [EOL] } <line_num>: 536,567
public void parseTarHeader(byte[] header) { [EOL]     int offset = 0; [EOL]     name = TarUtils.parseName(header, offset, NAMELEN); [EOL]     offset += NAMELEN; [EOL]     mode = (int) TarUtils.parseOctal(header, offset, MODELEN); [EOL]     offset += MODELEN; [EOL]     userId = (int) TarUtils.parseOctal(header, offset, UIDLEN); [EOL]     offset += UIDLEN; [EOL]     groupId = (int) TarUtils.parseOctal(header, offset, GIDLEN); [EOL]     offset += GIDLEN; [EOL]     size = TarUtils.parseOctal(header, offset, SIZELEN); [EOL]     offset += SIZELEN; [EOL]     modTime = TarUtils.parseOctal(header, offset, MODTIMELEN); [EOL]     offset += MODTIMELEN; [EOL]     offset += CHKSUMLEN; [EOL]     linkFlag = header[offset++]; [EOL]     linkName = TarUtils.parseName(header, offset, NAMELEN); [EOL]     offset += NAMELEN; [EOL]     magic = TarUtils.parseName(header, offset, MAGICLEN); [EOL]     offset += MAGICLEN; [EOL]     userName = TarUtils.parseName(header, offset, UNAMELEN); [EOL]     offset += UNAMELEN; [EOL]     groupName = TarUtils.parseName(header, offset, GNAMELEN); [EOL]     offset += GNAMELEN; [EOL]     devMajor = (int) TarUtils.parseOctal(header, offset, DEVLEN); [EOL]     offset += DEVLEN; [EOL]     devMinor = (int) TarUtils.parseOctal(header, offset, DEVLEN); [EOL] } <line_num>: 574,602
private static String normalizeFileName(String fileName) { [EOL]     String osname = System.getProperty("os.name").toLowerCase(Locale.US); [EOL]     if (osname != null) { [EOL]         if (osname.startsWith("windows")) { [EOL]             if (fileName.length() > 2) { [EOL]                 char ch1 = fileName.charAt(0); [EOL]                 char ch2 = fileName.charAt(1); [EOL]                 if (ch2 == ':' && ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))) { [EOL]                     fileName = fileName.substring(2); [EOL]                 } [EOL]             } [EOL]         } else if (osname.indexOf("netware") > -1) { [EOL]             int colon = fileName.indexOf(':'); [EOL]             if (colon != -1) { [EOL]                 fileName = fileName.substring(colon + 1); [EOL]             } [EOL]         } [EOL]     } [EOL]     fileName = fileName.replace(File.separatorChar, '/'); [EOL]     while (fileName.startsWith("/")) { [EOL]         fileName = fileName.substring(1); [EOL]     } [EOL]     return fileName; [EOL] } <line_num>: 608,644