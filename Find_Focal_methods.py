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
X = []
Y = []
if __name__ == "__main__":

    # for (root,dirs,files) in os.walk(source_file_path, topdown=True):
    #     # print (root)
    #     # print (files)
    #     # print ('--------------------------------')
    #     for file in files:
    #       # print(root+'/'+file)
    #       if os.path.exists(root+"/"+file) \
    #           and os.path.exists(method_names_path + "/".join(root.split('/')[1:])+"/"+file)\
    #           and os.path.exists(context_path + "/".join(root.split('/')[1:])+"/"+file):
    #           # print(src_path)

    #           f = open(root+"/"+file,"rb")
    #           # print("methods")
    #           # print(root+"/"+file)
    #           methods_body = f.read()
    #           f.close()
    #           methods_body = methods_body.split(str.encode('\n'))

    #           f = open("/".join(root.split('/')[1:])+"/"+file,"rb")
    #           # print("src")
    #           # print("/".join(root.split('/')[1:])+"/"+file)
    #           src_files = f.read()
    #           f.close()
    #           src_files = src_files.split(str.encode('\n'))

              
    #           # print(src_files)
    #           # src_files = src_files.split(str.encode("\n"))
    #           # print(src_files)
    #           # print(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
    #           # print(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
    #           f = open(method_names_path + "/".join(root.split('/')[1:])+"/"+file,"rb")
    #           m_names = f.read()
    #           f.close()
    #           m_names = m_names.split(str.encode('\n'))

    #           f = open(context_path + "/".join(root.split('/')[1:])+"/"+file,"rb")
    #           context = f.read()
    #           f.close()
    #           context = context.split(str.encode('\n'))

              
    #           # tests = tests.split('@Test')[1:]
    #           # tests[-1] = tests[-1][0:-2] #omiting last }
    #           # method_name_list = []
    #           # method_name_list = [i.replace('(','') for i in re.findall('\w+\(',m_names)]
    #           # print(method_name_list)
    #           methods2line = {}
    #           for m_name in m_names:
    #             flag = 0

    #             if(len(m_name) >1):
    #               m_name = (b"".join(m_name.split(str.encode("("))[0].split(str.encode(" "))[-2:]) + str.encode("(") + m_name.split(str.encode("("))[1]).replace(str.encode(" "),str.encode(""))
    #             else:
    #               continue
    #             # print(m_name)
    #             # m_name = m_name.replace(str.encode(" "),str.encode(""))
    #             for i,line in enumerate(src_files):
    #               # line = line.replace(str.encode(" "),str.encode(""))
    #               if m_name in line.replace(str.encode(" "),str.encode("")):
    #                 flag += 1  
    #                 # print(line)
    #                 methods2line[str(file)+str(m_name)] = i
    #             if flag == 0:
    #               # pass
    #               print("not found")
    #               print(m_name)
    #               print("/".join(root.split('/')[1:])+"/"+file)
    #             if flag > 1:
    #               pass
    #               print(flag)
    #               print(m_name)
    #               print("more than 1 found")
    #               print("/".join(root.split('/')[1:])+"/"+file)


    #           # methods_line_dict = dict(zip(method_name_list, methods_body))






    X = []
    Y = []
    f = open("line2test.txt")
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
            path = line.split("/")[11:]
            class_name = line.split("/")[-1].split(".")[0]
            # print(class_name)
            # print(path)
            f = open("/".join(path),'rb')
            src_code = f.readlines()
            f.close()

            f = open(methods_path+"/".join(path),'rb')
            methods = f.readlines()
            f.close()
            methods2line = {}
            for method in methods:
              line_num = method.split(str.encode("<line_num>:"))[1]
              methods2line[int(line_num)] = method
      if "<line>" in line: 
        line_num = int(line.split(":")[1])
        src_line = src_code[line_num-1]
        nearest_func = 0
        diff = 50000
        function_found_flag = 0
        for key, value in methods2line.items():
          if line_num-1 >= key:
            if line_num-1 - key < diff:
              diff = line_num-1 - key
              nearest_func = key
              if src_line.strip() in methods2line[nearest_func]:
                function_found_flag = 1
        
        # print("/".join(path))
        f = open("src_lines.txt","ab")
        if function_found_flag == 1:
          f.write(str.encode(" [LINE] ") + src_line.replace(str.encode("\n"), str.encode(" ")).strip() + str.encode(" [LINE] ") + methods2line[nearest_func].split(str.encode("<line_num>:"))[0] + str.encode("\n"))
          X.append(str.encode(" [LINE] ") + src_line.replace(str.encode("\n"), str.encode(" ")).strip() + str.encode(" [LINE] ") + methods2line[nearest_func].split(str.encode("<line_num>:"))[0] + str.encode("\n"))
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
        

    # for (root,dirs,files) in os.walk(source_file_path, topdown=True):
    #     # print (root)
    #     # print (files)
    #     # print ('--------------------------------')
    #     for file in files:
    #         try:
    #             # print(root+'/'+file)
    #             if os.path.exists(root+"/"+file) \
    #                 and os.path.exists(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java") \
    #                 and os.path.exists(method_names_path + "/".join(root.split('/')[1:])+"/"+file)\
    #                 and os.path.exists(context_path + "/".join(root.split('/')[1:])+"/"+file):


    #                 f = open(root+"/"+file)
    #                 methods_body = f.read()
    #                 f.close()
    #                 # print(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
    #                 f = open(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
    #                 tests = f.read()
    #                 f.close()
    #                 # print(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
    #                 f = open(context_path + "/".join(root.split('/')[1:])+"/"+file)
    #                 m_names = f.read()
    #                 f.close()

    #                 f = open(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
    #                 context = f.read()
    #                 f.close()
    #                 context = context.split('\n')

    #                 methods_body = methods_body.split('\n')
    #                 tests = tests.split('@Test')[1:]
    #                 tests[-1] = tests[-1][0:-2] #omiting last }
    #                 method_name_list = []
    #                 method_name_list = [i.replace('(','') for i in re.findall('\w+\(',m_names)]
    #                 # print(method_name_list)


    #                 methods_dict = dict(zip(method_name_list, methods_body))

    #                 # print(len(methods))
                    
    #                 method_test = {}
    #                 all_methods = []
    #                 all_tests = []
    #                 for test in tests:
    #                     # print(test)
    #                     for key,value in methods_dict.items():
    #                         if test.find(key)!=-1:
    #                             context_copy = copy.deepcopy(context)
    #                             for i,m in enumerate(context_copy):  #find the method name in the context and replace it with method body at the begining of the list
    #                                 if key+'(' in m:
    #                                     context_copy.pop(i)
    #                                     context_copy.insert(1,value)

    #                             test_s = test.split('\n')
    #                             new_test = []
    #                             if(test.count('assert')==1):
    #                                 for i in test_s:
    #                                     new_test.append(i)
    #                             elif(test.count('assert')>1):
    #                                 # print("########################")
    #                                 for i in test_s:
    #                                     if i.find('assert') != -1 and i.find(key) == -1:
    #                                         pass
    #                                     else:
    #                                         new_test.append(i)
    #                             new_test = '\n'.join(new_test)
    #                             # print(new_test)
                                
    #                             if(len(new_test)>0):
    #                                 test_name = re.findall('test\d+',new_test)[0]
    #                                 if(new_test.find('assert')!=-1):
    #                                     # method_test['@Test' + new_test.replace(test_name,"test"+key)] = "\n".join(context_copy)
    #                                     all_methods.append("\n".join(context_copy))
    #                                     all_tests.append('@Test' + new_test.replace(test_name,"test"+key))

                                    

                        
    #                 # for key , value in method_test.items():
    #                 #     print(key,value)
    #                 #     print('\n\n\n')
                        

    #                 with open("Evosuit.tests", "a") as f1, open("Evosuit.Methods", "a") as f2:
    #                     f1.write(root+"/"+file+'\n')
    #                     f2.write(root+"/"+file+'\n')
    #                     for value  in all_methods:
    #                         X.append(value.replace('\n',' [EOL] ') +'\n')
    #                         f2.write(value.replace('\n',' [EOL] ') +'\n')
    #                     for key  in all_tests:
    #                         Y.append(key.replace('\n',' [EOL] ') + '\n')
    #                         f1.write(key.replace('\n',' [EOL] ') + '\n')
                
    #         except:
    #             print("new_test")
    #             print(new_test)
    #             print(sys.exc_info())

    #         print(root+"/"+file)
    # with open("Evosuit_train.tests", "w") as Evosuit_train_tests, open("Evosuit_train.methods", "w") as Evosuit_train_methods , open("Evosuit_test.tests", "w") as Evosuit_test_tests, open("Evosuit_test.methods", "w") as Evosuit_test_methods:
    #     X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.20, random_state=42)    
    #     for i in X_train:
    #         Evosuit_train_methods.write(i)
    #     for i in X_test:
    #         Evosuit_test_methods.write(i)
    #     for i in y_train:
    #         Evosuit_train_tests.write(i)
    #     for i in y_test:
    #         Evosuit_test_tests.write(i)
            

            




            



        


