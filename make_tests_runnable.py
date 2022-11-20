from operator import ne
import re
import os
import sys
from sklearn.model_selection import train_test_split
import shutil
import copy
root = './model_predictions/'
gold = "test_0.gold"
info = "test_info.txt"
out = "test_0.output"


def prepare():

    f = open(root+"/"+out)
    out_lines = f.readlines()
    f.close()

    f = open(root+"/"+info)
    info_lines = f.readlines()
    f.close()

    global i
    i = 0

    def replace(m):
        global i
        i += 1
        test_name=m.group(0).split('(') 
        new_test_name =(str(i)+'(').join(test_name)
        return new_test_name
    
    if os.path.exists("runnable_tests/"):
        shutil.rmtree("runnable_tests/")
        
    for line,info_line in zip(out_lines, info_lines):
        line = re.sub('test\w+\(\)', replace, line)
        line = re.sub("\[EOL\]", '\n', line)
        os.makedirs(os.path.dirname("runnable_tests/"+info_line.split("<test_path>:")[-1]), exist_ok=True)
        with open("runnable_tests/"+info_line.split("<test_path>:")[-1], "a") as Final_tests:
            Final_tests.write(line)
        

if __name__ == "__main__":
    prepare()


    
