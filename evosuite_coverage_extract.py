from asyncio import open_unix_connection
import xml.etree.ElementTree as ET
import os
import json

if os.path.exists("lines_covered_evosuite.txt"):
   os.remove("lines_covered_evosuite.txt")


tree = ET.parse('evosuite_reports/clover_lang.xml')
root = tree.getroot()
line_coverage = {}
for package in root[0].findall('package'):
    for file in package.findall('file'):
        # print(file.get("path"))
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
            if line.get("type") == "stmt":
                if int(line.get("count")) > 0:
                    lines.append(line.get("num"))
            elif line.get("type") == "cond":
                if (int(line.get("falsecount")) + int(line.get("truecount"))) > 0:
                    lines.append(line.get("num"))
            elif line.get("type") == "method":
                if int(line.get("count")) > 0:
                    lines.append(line.get("num"))
            else:
                print("type: " + line.get("type"))
        # print(lines)
        if len(lines) > 0:
            line_coverage["/".join(file.get("path").split('/')[12:])] = lines

out = json.dumps(line_coverage)
# print(out)
with open('lines_covered_evosuite.json', 'w') as f:
    json.dump(out, f)

with open('lines_covered_evosuite.json', 'r') as f, open("lines_covered_evosuite.txt","w") as out:
    jsonObject = json.load(f)
    jsonObject = json.loads(jsonObject)
    for file in jsonObject.keys():
        out.write(file + "\n")
        for i in jsonObject[file]:
            out.write(i + "\n")

# print(jsonObject["lang3/builder/ReflectionToStringBuilder.java"])

