from asyncio import open_unix_connection
import xml.etree.ElementTree as ET
import os
import json

if os.path.exists("lines_covered_evosuite.txt"):
   os.remove("lines_covered_evosuite.txt")


tree = ET.parse('evosuite_reports/clover_lang.xml')
root = tree.getroot()
line_coverage = {}

for file in root[0][1].findall('file'):
    # print(file.get("path"))
    # f = open("lines_covered_evosuite.txt",'a')
    # f.write(file.get("path")+"\n")
    # f.close()
    
    lines = []
    for line in file.findall("line"):
        # print(line.get("num"))
        # f = open("lines_covered_evosuite.txt",'a')
        # f.write(line.get("num")+"\n")
        # f.close()
        lines.append(line.get("num"))
    # print(lines)
    if len(lines) > 0:
        line_coverage["/".join(file.get("path").split('/')[10:])] = lines

out = json.dumps(line_coverage)
# print(out)
with open('lines_covered_evosuite.json', 'w') as f:
    json.dump(out, f)

with open('lines_covered_evosuite.json', 'r') as f:
   jsonObject = json.load(f)
jsonObject = json.loads(jsonObject)
print(jsonObject["apache/commons/lang3/builder/ReflectionToStringBuilder.java"])

