private TarArchiveEntry()
public TarArchiveEntry(String name)
public TarArchiveEntry(String name, byte linkFlag)
public TarArchiveEntry(File file)
public TarArchiveEntry(byte[] headerBuf)
public boolean equals(TarArchiveEntry it)
public boolean equals(Object it)
public int hashCode()
public boolean isDescendent(TarArchiveEntry desc)
public String getName()
public void setName(String name)
public void setMode(int mode)
public String getLinkName()
public int getUserId()
public void setUserId(int userId)
public int getGroupId()
public void setGroupId(int groupId)
public String getUserName()
public void setUserName(String userName)
public String getGroupName()
public void setGroupName(String groupName)
public void setIds(int userId, int groupId)
public void setNames(String userName, String groupName)
public void setModTime(long time)
public void setModTime(Date time)
public Date getModTime()
public File getFile()
public int getMode()
public long getSize()
public void setSize(long size)
public boolean isGNULongNameEntry()
public boolean isDirectory()
public TarArchiveEntry[] getDirectoryEntries()
public void writeEntryHeader(byte[] outbuf)
public void parseTarHeader(byte[] header)
private static String normalizeFileName(String fileName)
StringBuffer name
int mode
int userId
int groupId
long size
long modTime
byte linkFlag
StringBuffer linkName
StringBuffer magic
StringBuffer userName
StringBuffer groupName
int devMajor
int devMinor
File file
int MAX_NAMELEN=Optional[31]
int DEFAULT_DIR_MODE=Optional[040755]
int DEFAULT_FILE_MODE=Optional[0100644]
int MILLIS_PER_SECOND=Optional[1000]