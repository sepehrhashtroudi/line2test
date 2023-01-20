public ArchiveInputStream createArchiveInputStream(final String archiverName, final InputStream in) throws ArchiveException { [EOL]     if (archiverName == null || in == null) { [EOL]         throw new IllegalArgumentException("Archivername must not be null."); [EOL]     } [EOL]     if ("ar".equalsIgnoreCase(archiverName)) { [EOL]         return new ArArchiveInputStream(in); [EOL]     } else if ("zip".equalsIgnoreCase(archiverName)) { [EOL]         return new ZipArchiveInputStream(in); [EOL]     } else if ("tar".equalsIgnoreCase(archiverName)) { [EOL]         return new TarArchiveInputStream(in); [EOL]     } else if ("jar".equalsIgnoreCase(archiverName)) { [EOL]         return new JarArchiveInputStream(in); [EOL]     } else if ("cpio".equalsIgnoreCase(archiverName)) { [EOL]         return new CpioArchiveInputStream(in); [EOL]     } [EOL]     throw new ArchiveException("Archiver: " + archiverName + " not found."); [EOL] } <line_num>: 56,75
public ArchiveOutputStream createArchiveOutputStream(final String archiverName, final OutputStream out) throws ArchiveException { [EOL]     if (archiverName == null || out == null) { [EOL]         throw new IllegalArgumentException("Archivername and stream must not be null."); [EOL]     } [EOL]     if ("ar".equalsIgnoreCase(archiverName)) { [EOL]         return new ArArchiveOutputStream(out); [EOL]     } else if ("zip".equalsIgnoreCase(archiverName)) { [EOL]         return new ZipArchiveOutputStream(out); [EOL]     } else if ("tar".equalsIgnoreCase(archiverName)) { [EOL]         return new TarArchiveOutputStream(out); [EOL]     } else if ("jar".equalsIgnoreCase(archiverName)) { [EOL]         return new JarArchiveOutputStream(out); [EOL]     } else if ("cpio".equalsIgnoreCase(archiverName)) { [EOL]         return new CpioArchiveOutputStream(out); [EOL]     } [EOL]     throw new ArchiveException("Archiver: " + archiverName + " not found."); [EOL] } <line_num>: 86,106
public ArchiveInputStream createArchiveInputStream(final InputStream in) throws ArchiveException { [EOL]     if (in == null) { [EOL]         throw new IllegalArgumentException("Stream must not be null."); [EOL]     } [EOL]     if (!in.markSupported()) { [EOL]         throw new IllegalArgumentException("Mark is not supported."); [EOL]     } [EOL]     final byte[] signature = new byte[12]; [EOL]     in.mark(signature.length); [EOL]     try { [EOL]         int signatureLength = in.read(signature); [EOL]         in.reset(); [EOL]         if (ZipArchiveInputStream.matches(signature, signatureLength)) { [EOL]             return new ZipArchiveInputStream(in); [EOL]         } else if (JarArchiveInputStream.matches(signature, signatureLength)) { [EOL]             return new JarArchiveInputStream(in); [EOL]         } else if (TarArchiveInputStream.matches(signature, signatureLength)) { [EOL]             return new TarArchiveInputStream(in); [EOL]         } else if (ArArchiveInputStream.matches(signature, signatureLength)) { [EOL]             return new ArArchiveInputStream(in); [EOL]         } else if (CpioArchiveInputStream.matches(signature, signatureLength)) { [EOL]             return new CpioArchiveInputStream(in); [EOL]         } [EOL]     } catch (IOException e) { [EOL]         throw new ArchiveException("Could not use reset and mark operations.", e); [EOL]     } [EOL]     throw new ArchiveException("No Archiver found for the stream signature"); [EOL] } <line_num>: 117,153
