from operator import ne
import re
import os
import sys
from sklearn.model_selection import train_test_split
import copy
root = './'
gold = "test_0.gold"
out = "test_0.output"


def prepare():
    f = open(root+"/"+gold)
    gold_lines = f.readlines()
    f.close()

    f = open(root+"/"+out)
    out_lines = f.readlines()
    f.close()

    global i
    i = 0

    def replace(m):
        global i
        i += 1
        test_name=m.group(0).split('(') 
        new_test_name =(str(i)+'(').join(test_name)
        return new_test_name
    
    new_tests = []
    for index, line in enumerate(gold_lines):
        if ".java" in line:
            out_lines[index] = line
        
    for line in out_lines:
        if ".java" in line:
            new_tests.append(line)
        else:
            line = re.sub('test\w+\(\)', replace, line)
            line = re.sub("\[EOL\]", '\n', line)
            new_tests.append(line)
    # print(new_test_body)
    with open("Final_tests_new1234589.java", "w") as Final_tests:
        Final_tests.write(" ".join(new_tests))
        

if __name__ == "__main__":
    prepare()


    
