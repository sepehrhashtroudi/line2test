from ast import Bytes
import re
import os
import sys
from sklearn.model_selection import train_test_split
import copy
import json 
import pandas as pd


def text_preprocess (input):
  input = input.strip().replace(str.encode(" "), str.encode("")).replace(str.encode("[EOL]"),str.encode(""))
  input = input.split(str.encode("//"))[0]
  return input
method_names_path = "method_names/"
methods_path = "methods/"
context_path = "context/"

# if os.path.exists("src_lines.txt"):
#   os.remove("src_lines.txt")
# if os.path.exists("tests.txt"):
#   os.remove("tests.txt")
# if os.path.exists("test_path.txt"):
#   os.remove("test_path.txt")
# if os.path.exists("lines_covered.txt"):
#   os.remove("lines_covered.txt")
  
  

if __name__ == "__main__":



    f = open("Lang1f_line2test.txt")
    line2test = f.read()
    f.close()
    line2test = line2test.split("\n")
    i = 0
    src_code = 0
    class_name = 0
    function_found_flag = 0
    dataset = {}
    path = ""
    methods = ""
    line_plus_method = ""
    src_line_num = 0
    
    for line in line2test:
      # print(line)
      
      if "<src_file>" in line:
          if("Test" in line):
            print("test#########################################################")
          else:

            line_src_dict = {}
            path = line.split("/")[12:]
            class_name = line.split("/")[-1].split(".")[0]
            # print("src" + str(path))
            # print(class_name)
            # print(path)
            f = open("/".join(path),'rb')
            src_code = f.readlines()
            f.close()

            f = open(methods_path+"/".join(path),'rb')
            methods = f.readlines()
            f.close()

            f = open(context_path+"/".join(path),'rb')
            context = f.readlines()
            f.close()


            # f = open("src_lines.txt","ab")
            # f.write(str.encode("/".join(path) + "\n"))
            # f.close()

            # f = open("tests.txt","ab")
            # f.write(str.encode("/".join(path) + "\n"))
            # f.close()

            # f = open("test_path.txt",'ab')
            # f.write(str.encode("<SRC>"+"/".join(path) + "\n"))
            # f.close()

            # f = open("lines_covered.txt",'ab')
            # f.write(str.encode("/".join(path) + "\n"))
            # f.close()    
    
            methods2line = {}
            for method in methods:
              method_line_num_start = method.split(str.encode("<line_num>:"))[1].split(str.encode(","))[0]
              method_line_num_end = method.split(str.encode("<line_num>:"))[1].split(str.encode(","))[1]
              methods2line[method.split(str.encode("<line_num>:"))[0]] = {"start": int(method_line_num_start), "end": int(method_line_num_end)}
      if "<line>" in line: 
        line_num = int(line.split(":")[1]) #real line num starts from 1
        src_line_num = line_num
        src_line = src_code[line_num-1] # in array we should subtrac 1 because its an array and start at zero
        nearest_func = 0
        diff = 50000
        entered_loop_flag = 0
        function_found_flag = 0
        if len(methods2line) == 0:
          function_found_flag = 0
          print("zero methods")
          continue #if we dont have any methods in the file we continue until we get to the next file

        for key, value in methods2line.items():
          # print("line "+ str(line_num))
          # print("key"+str(key))
          if text_preprocess(src_line) in text_preprocess(key):
            function_found_flag = 2 #for debug
          if line_num >= value["start"]:
            if line_num <= value["end"]:
              nearest_func = key
              entered_loop_flag = 1 
              # if text_preprocess(src_line) in text_preprocess(methods2line[nearest_func]):
              #   function_found_flag = 2
              
                
          
        if entered_loop_flag == 1:
          if text_preprocess(src_line) in text_preprocess(nearest_func):
            function_found_flag = 1



        
        # print("/".join(path))
        # f = open("src_lines.txt","ab")
        if function_found_flag == 1 :
          line_plus_method = str.encode(" [LINE] ") + src_line.replace(str.encode("\n"), str.encode(" ")).strip() + str.encode(" [LINE] ") \
            + nearest_func + str.encode("; ").join(context).replace(str.encode("\n"), str.encode(""))
        elif entered_loop_flag == 1 and function_found_flag != 1:
          #if str.encode("@") not in src_line: #and str.encode("this") not in src_line\
          #   and str.encode("super") not in src_line and str.encode(path[-1].split(".")[0]) not in src_line :

          print("method not found")
          # print(" [LINE] " + str(src_line))
          # print(" [method] " + str(nearest_func))
          # print(" [path] " + str(path))
          # print(" [line] " + str(src_line_num))
          continue




      if "<test_name>" in line and function_found_flag == 1:
        test_path = line.split("<###>")[0]
        test_path = test_path.split(".")[3:-1]
        # print(line.split(".")[-1])
        # print(line.split(".")[-1])
        
        
        selected_test_name = line.split("<###>")[0].split(".")[-1].strip()+"()" #default test if no more related one is found
        test_names = line.split("<###>")
        for test_name in test_names:
          if class_name in test_name:
            selected_test_name = test_name.split(".")[-1].strip()+"()"
            test_path = test_name.split(".")[3:-1]
            # print("test_name ###########################################")
            break
        f = open("lang3_tests/" +"/".join(test_path[1:])+".java",'rb')
        tests = f.read()
        f.close()

        # f = open("test_path.txt","ab")
        # f.write(str.encode("/".join(test_path)+".java" +  "\n"))
        # f.close()

        tests = tests.split(str.encode("\n"))
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
            line_src_dict[str(src_line_num)] = {"src": line_plus_method , "test": test.split(str.encode("<line_num>"))[0],\
            "test_path": str.encode("/".join(test_path)+".java")}
            dataset["/".join(path)] = line_src_dict 
            # f = open("tests.txt","ab")
            # f.write(str.encode("@Test") + test.replace( str.encode("\n"), str.encode(" [EOL] "))+str.encode("\n"))
            # Y.append(str.encode("@Test") + test.replace(str.encode("\n"), str.encode(" [EOL] "))+str.encode("\n"))
            # f.close()
        
        if index == 0: 
          print("no tests found for a line")
          print(selected_test_name)
          print("/".join(test_path)+".java")

    # print(dataset)
    f = open("covered_lines_new.txt","wb")
    for key,value in dataset.items():
      f.write(str.encode(key +  "\n"))
      for line, _ in value.items():
        f.write(str.encode(line +  "\n"))
    f.close()


    df = pd.DataFrame(columns=['methods','tests','info'])

   
           
    for path,line_src_test in dataset.items():
      # f.write(str.encode(key +  "\n"))
        for line, src_test in line_src_test.items():
          # print(line)
          new_row = pd.DataFrame([{"methods":src_test["src"], "tests":src_test["test"], "info":str.encode("<line>: "+ line + "<path>: " + path  + "<test_path>: ") + src_test["test_path"]}],  )
          df = pd.concat([df,new_row],axis=0, ignore_index=True)
    
    # print(df)
    data_train, data_test = train_test_split(df, test_size=0.01, random_state=42)
    data_test_copy = data_test.copy(deep=True)
    data_train_copy = data_train.copy(deep=True)
 
    
    print(data_test)
    i == 0         
    
    for index_test, row_test in  data_test_copy.iterrows():
      for index_train, row_train in  data_train_copy.iterrows():
        if(row_test["tests"] == row_train["tests"]):
          # print(row_train)
          if index_train in data_train.index:
            new_row = pd.DataFrame([row_train],columns=["methods", "tests", "info"])
            data_test = pd.concat([data_test,new_row],keys=["methods", "tests", "info"],axis=0, ignore_index=True)
            data_train = data_train.drop(labels=index_train, axis=0, inplace=False)
          else:
            print("drop index not found")
          print("len train: {}".format(len(data_test_copy)))
          print("len train: {}".format(len(data_train_copy)))
          print("len train: {}".format(len(data_train)))
          print("len test: {}".format(len(data_test)))
        
    with open("train.methods","wb") as train_methods, open("train.tests","wb") as train_tests\
        , open("test.methods","wb") as test_methods, open("test.tests","wb") as test_tests\
        , open("test_info.txt","wb") as test_info, open("train_info.txt","wb") as train_info:
        for index_train, row_train in  data_train.iterrows():
          train_methods.write(row_train["methods"] +  str.encode("\n"))
          train_tests.write(row_train["tests"] +  str.encode("\n"))
          train_info.write(row_train['info']+ str.encode("\n"))
        for index_test, row_test in  data_test.iterrows():
          test_methods.write(row_test["methods"] +  str.encode("\n"))
          test_tests.write(row_test["tests"] +  str.encode("\n"))
          test_info.write(row_test['info']+ str.encode("\n"))

    


    # out = json.dumps(dataset)
    # with open('dataset.json', 'w') as f:
    #   json.dump(out, f)

    # with open("train.tests", "wb") as train_tests, open("train.methods", "wb") as train_methods , open("test.tests", "wb") as test_tests, open("test.methods", "wb") as test_methods:
    #     X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.20, random_state=42)    
    #     for i in X_train:
    #         train_methods.write(i)
    #     for i in X_test:
    #         test_methods.write(i)
    #     for i in y_train:
    #         train_tests.write(i)
    #     for i in y_test:
    #         test_tests.write(i)
        
    # with open("test.methods", "rb") as test_methods, open("test.tests","rb") as test_tests,\
    #   open("src_lines.txt","rb") as all_methods,\
    #   open("test_sorted.methods","wb") as test_methods_with_address,\
    #   open("test_sorted.tests","wb") as test_tests_with_address,\
    #   open("test_path.txt","rb") as  test_path,\
    #   open("test_path_sorted.txt","wb") as  test_path_sorted,\
    #   open("lines_covered.txt","rb") as  lines_covered,\
    #   open("lines_covered_test.txt","wb") as  lines_covered_test:
    #     all_method_lines = all_methods.readlines()
    #     test_method_lines = test_methods.readlines()
    #     test_tests_lines = test_tests.readlines()
    #     test_path_lines = test_path.readlines()
    #     lines_covered_lines = lines_covered.readlines()
    #     test_methods_sorted = []
    #     test_tests_sorted = []
    #     test_path_sorted_list = []
    #     lines_covered_test_list = []
    #     for aml_index, all_method_line  in enumerate(all_method_lines):
    #       if str.encode(".java") in all_method_line:
    #         test_methods_sorted.append(all_method_line)
    #         test_tests_sorted.append(all_method_line)
    #         test_path_sorted_list.append(str.encode("<SRC>: ") + all_method_line)
    #         lines_covered_test_list.append(all_method_line)
    #         continue
    #       found = 0
    #       for index, test_method_line in enumerate(test_method_lines):
    #         if test_method_line == all_method_line:
    #           test_tests_sorted.append(test_tests_lines[index])
    #           test_methods_sorted.append(all_method_line)
    #           test_path_sorted_list.append(test_path_lines[aml_index])
    #           lines_covered_test_list.append(lines_covered_lines[aml_index])
    #           test_method_lines.pop(index)
    #           test_tests_lines.pop(index)
    #           found =1
    #           break

    #     for i in test_methods_sorted:
    #       test_methods_with_address.write(i)
    #     for i in test_tests_sorted:
    #       test_tests_with_address.write(i)
    #     for i in test_path_sorted_list:
    #       test_path_sorted.write(i)
    #     for i in lines_covered_test_list:
    #       lines_covered_test.write(i)

           
    


