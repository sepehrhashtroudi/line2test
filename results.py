from asyncio import open_unix_connection
import xml.etree.ElementTree as ET
import os
import json

if os.path.exists("lines_covered_evosuite.txt"):
   os.remove("lines_covered_evosuite.txt")

f = open("./generated_datasets/lang3_test_info.txt")
test_info = f.readlines()
f.close()

tree = ET.parse('model_gen_coverage/clover_lang_3.xml')
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
            line_coverage["/".join(file.get("path").split('/')[10:])] = lines


test_line_num = 0
covered_lines = 0
print(line_coverage.keys())
for line in test_info:
    file_path = line.split("<path>:")[-1].split("<test_path>:")[0].strip()
    # print(file_path)
    line_num = line.split("<path>:")[0].split(":")[-1].strip()
    test_line_num += 1
    if file_path in line_coverage.keys():
        if line_num in line_coverage[file_path]:
            covered_lines += 1
        else:
            
            print(line_coverage[file_path])
print(covered_lines/test_line_num)
# print(out)
out = json.dumps(line_coverage)
with open('lines_covered_evosuite.json', 'w') as f:
    json.dump(out, f)

# with open('lines_covered_evosuite.json', 'r') as f, open("lines_covered_evosuite.txt","w") as out:
#     jsonObject = json.load(f)
#     jsonObject = json.loads(jsonObject)
#     for file in jsonObject.keys():
#         out.write(file + "\n")
#         for i in jsonObject[file]:
#             out.write(i + "\n")


