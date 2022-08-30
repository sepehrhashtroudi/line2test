import xml.etree.ElementTree as ET
import os

if os.path.exists("lines_covered_evosuite.txt"):
   os.remove("lines_covered_evosuite.txt")


tree = ET.parse('evosuite_reports/clover_lang.xml')
root = tree.getroot()

for file in root[0][1].findall('file'):
    print(file.get("path"))
    f = open("lines_covered_evosuite.txt",'a')
    f.write(file.get("path")+"\n")
    f.close()
    for line in file.findall("line"):
        print(line.get("num"))
        f = open("lines_covered_evosuite.txt",'a')
        f.write(line.get("num")+"\n")
        f.close()
    

