listoflists = [[1,2,3],[1,2,3,4]]
print(len(listoflists))
matrix = 5*[5*[0]]
print(matrix)
print(len(matrix))
spChars = "!@#$%^&*(),.?"
print(spChars.split())
dictionary = {"key1":[[1,2,3],[4,5,6],[7,8,9]],"key2":[["a1",'b1','c1'],["a2",'b2','c2'],["a3",'b3','c3']]}
dictionary["key1"].append("basdf")
print(dictionary)
pwordsi=dictionary["key1"]
matrix = [[1,2,3],[4,5,6],[7,8,9]]
print([row[2] for row in matrix])

print(pwordsi)
print([words[0] for words in pwordsi])


#import random
#keys = list(dictionary.keys())
#print(keys[0])
#print(type(keys))
##for i in range(5):
	##print(random.choice(keys))

list1 = []
if list1:
	print("ok")
