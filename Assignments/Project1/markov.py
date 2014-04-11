#Markov sentence generator

#The structure of the code will be as follows.

#First we make a function that takes the previous three words and randomly
#generates the next word. This will be the most difficult part

#Create a function that makes a table (list) out of a text document
#This table will contain a list of n-word prefixes (1-4) and a list of "next 
#words" for each prefix

#Define a function that takes the previous n words as an input and 
#generates an output word

#This is the outline of the actual game:
	
	#Ask user to pick a provided seed file 

	#Ask for an input word

	#Computer will generate the next word

	#Return the entire sentence and ask for input'
	#4 choices
		#Return another word
		#Return multiple words
		#Allow user to input the next word
		#End the sentence
			#print the whole thing and ask user if he wants to play again
			

#Begin code

###############Learning to speak##############
#This section will compile a list that allows the computer to choose new 
#words

#Take the file and create a list of phrases
import re
import random

def GetFile(filename):
	fo = open(filename, "r")
	#make a list of the lines in the file
	lines = fo.readlines()
	lines2 =[]
	#remove newline characters
	for l in lines:
		lines2.append(l.rstrip("\n"))
	
	#split it into phrases
	
	#join everything
	lines2joined = " ".join(lines2)
	#split along characters and make everything lowercase
	phrases = splitspecial(lines2joined.lower())
	return phrases

#This function splits along special characters using regular expressions
def splitspecial(string):
	#return re.split("\,|\(|\)|\!|\;|\:|\?|\.|—",string)
	return re.split("[\,\(\)\!\;\:\?\.—]\s?",string)
	
#Generate the dictionary that has all the formatted data
#dictionary1 will have the key be the words of each phrase (except the last one)
#the value will be the list of all possible next words


def BrainDictionary1(filename):
	#get the phrases out
	phrases = GetFile(filename)
	#for each phrase, split it into lists
	#then take all the elements except the last and put them into dictionary
	#then put the next word into its value as a list
	#if the phrase is already in the dictionary, append the next word to the
	#value
	dictionary1 = {}
	for p in phrases:
		pwords = p.split(" ")
		lenp = len(pwords)
		if lenp > 1:
			i = 0
			while i<lenp-1:
				if pwords[i] not in dictionary1:
					dictionary1[pwords[i]] = [pwords[i+1]]
				else:
					dictionary1[pwords[i]].append(pwords[i+1])
				i+=1
	return dictionary1
					
#Possible alternative - instead of having the values be a list of words,
#make the value be a list of lists with the word as the first entry and
#the frequency as the second

#def BrainDictionary1b(filename):
	##get the phrases out
	#phrases = GetFile(filename)
	##for each phrase, split it into lists
	##then take all the elements except the last and put them into dictionary
	##then put the next word into its value as a list with 1
	##if the phrase is already in the dictionary, append the next word to the
	##value
	#dictionary1 = {}
	#for p in phrases:
		#pwords = p.split(" ")
		#lenp = len(pwords)
		#if lenp > 1:
			#i = 0
			#while i<lenp-1:
				##we can only initiate the variables below if they are 
				##in there
				#if pwords[i] in dictionary1:
					#pwordsi=dictionary1[pwords[i]] 
					##pwordsilist should be the list of words
					#pwordsilist = [words[0] for words in pwordsi]
				##if it's not in the dictionary, add it
				##make the value be a list of lists
				#if pwords[i] not in dictionary1:
					#dictionary1[pwords[i]] = [[pwords[i+1],1]]
				##if it's in the dictionary, but not a next word add it to the list
				#elif pwords[i+1] not in pwordsilist:
					#dictionary1[pwords[i]].append([pwords[i+1],1])
				##if it's in the dictionary and the list, add 1 to the counter
				#else:
					#ind = pwordsilist.index(pwords[i+1])
					#dictionary1[pwords[i]][ind][1]+=1
				
				#i+=1			

#A better way to do it
#This function is probably unneccesary
def addDictCount(dictionary):
	DictWithCount ={}
	for key in dictionary:
		wordsNoDupe = list(set(dictionary[key]))
		wordsNoDupe.sort()
		countlist = []
		for word in wordsNoDupe:
			countlist.append(dictionary[key].count(word))
		DictWithCount[key]=[wordsNoDupe,countlist]
	return DictWithCount


###############Making the next word################
#This function will take the brain and a word as input and generate a new word

def newWord1(word, dictionary1):
	if word in dictionary1:
		newWord = random.choice(dictionary1[key])
	
	
###############Running the game###############
#This is our game
def main():
	dic = BrainDictionary1("shorttext.txt")
	print(dic)
	dicCount=addDictCount(dic)
	print(dicCount)


	
main()
