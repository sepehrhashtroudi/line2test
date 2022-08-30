from ast import Bytes
import re
import os
import sys
from sklearn.model_selection import train_test_split
import copy

src_path= "lang3/"
method_names_path = "method_names/"
methods_path = "methods/"
context_path = "context/"

if os.path.exists("src_lines.txt"):
  os.remove("src_lines.txt")
if os.path.exists("tests.txt"):
  os.remove("tests.txt")
if os.path.exists("test_path.txt"):
  os.remove("test_path.txt")
if os.path.exists("lines_covered.txt"):
  os.remove("lines_covered.txt")
  
  
X = []
Y = []
if __name__ == "__main__":


    X = []
    Y = []
    f = open("Lang1f_line2test.txt")
    line2test = f.read()
    f.close()
    line2test = line2test.split("\n")
    i = 0
    src_code = 0
    class_name = 0
    function_found_flag = 0
    for line in line2test:
      # print(line)
      
      if "<src_file>" in line:
          if("Test" in line):
            print("test#########################################################")
          else:
            path = line.split("/")[12:]
            class_name = line.split("/")[-1].split(".")[0]
            # print(class_name)
            # print(path)
            f = open("/".join(path),'rb')
            src_code = f.readlines()
            f.close()

            f = open(methods_path+"/".join(path),'rb')
            methods = f.readlines()
            f.close()

            f = open("src_lines.txt","ab")
            f.write(str.encode("/".join(path) + "\n"))
            f.close()

            f = open("tests.txt","ab")
            f.write(str.encode("/".join(path) + "\n"))
            f.close()

            f = open("test_path.txt",'ab')
            f.write(str.encode("<SRC>"+"/".join(path) + "\n"))
            f.close()

            f = open("lines_covered.txt",'ab')
            f.write(str.encode("/".join(path) + "\n"))
            f.close()    
    
            methods2line = {}
            for method in methods:
              line_num = method.split(str.encode("<line_num>:"))[1]
              methods2line[int(line_num)] = method
      if "<line>" in line: 
        line_num = int(line.split(":")[1])-1
        src_line = src_code[line_num]
        nearest_func = 0
        diff = 50000
        function_found_flag = 0
        for key, value in methods2line.items():
          if line_num >= key:
            if line_num - key < diff:
              diff = line_num - key
              nearest_func = key
              if src_line.strip() in methods2line[nearest_func]:
                function_found_flag = 1
        
        # print("/".join(path))
        f = open("src_lines.txt","ab")
        if function_found_flag == 1:
          f.write(str.encode(" [LINE] ") + src_line.replace(str.encode("\n"), str.encode(" ")).strip() + str.encode(" [LINE] ") + methods2line[nearest_func].split(str.encode("<line_num>:"))[0] + str.encode("\n"))
          X.append(str.encode(" [LINE] ") + src_line.replace(str.encode("\n"), str.encode(" ")).strip() + str.encode(" [LINE] ") + methods2line[nearest_func].split(str.encode("<line_num>:"))[0] + str.encode("\n"))
          f = open("lines_covered.txt",'ab')
          f.write(str.encode(str(line_num+1) + "\n"))
          f.close()
        else:
          pass
          # f.write(src_line )
        f.close()



      if "<test_name>" in line and function_found_flag == 1:
        path = line.split("<###>")[0]
        path = path.split(".")[3:-1]
        # print(line.split(".")[-1])
        # print(line.split(".")[-1])
        
        
        selected_test_name = line.split("<###>")[0].split(".")[-1].strip()+"()" #default test if no more related one is found
        test_names = line.split("<###>")
        for test_name in test_names:
          if class_name in test_name:
            selected_test_name = test_name.split(".")[-1].strip()+"()"
            path = test_name.split(".")[3:-1]
            # print("test_name ###########################################")
            break
        f = open("/".join(path)+".java",'rb')
        tests = f.read()
        f.close()

        f = open("test_path.txt","ab")
        f.write(str.encode("/".join(path)+".java" +  "\n"))
        f.close()

        tests = tests.split(str.encode("@Test"))
        # print(tests)
        index = 0
        for test in tests:   
          # print("**********************************************************************")
          # print(str.encode(test_name))
          # print("**********************************************************************")
          # print(test)
          if str.encode(selected_test_name) in test.replace(str.encode(" "),str.encode("")): #for geting rid of spaces before () in some tests
            index += 1
            if(index>1):
              print(index)
              print("more than one test maped to one line")
              continue
            f = open("tests.txt","ab")
            f.write(str.encode("@Test") + test.replace( str.encode("\n"), str.encode(" [EOL] "))+str.encode("\n"))
            Y.append(str.encode("@Test") + test.replace(str.encode("\n"), str.encode(" [EOL] "))+str.encode("\n"))
            f.close()
        
        if index == 0: 
          print("no tests found for a line")
          print(selected_test_name)
          print("/".join(path)+".java")
          
    with open("train.tests", "wb") as train_tests, open("train.methods", "wb") as train_methods , open("test.tests", "wb") as test_tests, open("test.methods", "wb") as test_methods:
        X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.20, random_state=42)    
        for i in X_train:
            train_methods.write(i)
        for i in X_test:
            test_methods.write(i)
        for i in y_train:
            train_tests.write(i)
        for i in y_test:
            test_tests.write(i)
        
    with open("test.methods", "rb") as test_methods, open("test.tests","rb") as test_tests,\
      open("src_lines.txt","rb") as all_methods,\
      open("test_sorted.methods","wb") as test_methods_with_address,\
      open("test_sorted.tests","wb") as test_tests_with_address,\
      open("test_path.txt","rb") as  test_path,\
      open("test_path_sorted.txt","wb") as  test_path_sorted,\
      open("lines_covered.txt","rb") as  lines_covered,\
      open("lines_covered_test.txt","wb") as  lines_covered_test:
        all_method_lines = all_methods.readlines()
        test_method_lines = test_methods.readlines()
        test_tests_lines = test_tests.readlines()
        test_path_lines = test_path.readlines()
        lines_covered_lines = lines_covered.readlines()
        test_methods_sorted = []
        test_tests_sorted = []
        test_path_sorted_list = []
        lines_covered_test_list = []
        for aml_index, all_method_line  in enumerate(all_method_lines):
          if str.encode(".java") in all_method_line:
            test_methods_sorted.append(all_method_line)
            test_tests_sorted.append(all_method_line)
            test_path_sorted_list.append(str.encode("<SRC>: ") + all_method_line)
            lines_covered_test_list.append(all_method_line)
            continue
          found = 0
          for index, test_method_line in enumerate(test_method_lines):
            if test_method_line == all_method_line:
              test_tests_sorted.append(test_tests_lines[index])
              test_methods_sorted.append(all_method_line)
              test_path_sorted_list.append(test_path_lines[aml_index])
              lines_covered_test_list.append(lines_covered_lines[aml_index])
              test_method_lines.pop(index)
              test_tests_lines.pop(index)
              found =1
              break

        for i in test_methods_sorted:
          test_methods_with_address.write(i)
        for i in test_tests_sorted:
          test_tests_with_address.write(i)
        for i in test_path_sorted_list:
          test_path_sorted.write(i)
        for i in lines_covered_test_list:
          lines_covered_test.write(i)

           
    


