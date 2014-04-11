#Markov sentence generator

#The structure of the code will be as follows.

#First we make a function that takes the previous n words and randomly
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
import sys

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
	return re.split('[\,\"\(\)\!\;\:\?\.—]\s?',string)
	
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
					dictionary1[(pwords[i])] = [pwords[i+1]]
				else:
					dictionary1[(pwords[i])].append(pwords[i+1])
				i+=1
	#print(dictionary1)
	return dictionary1

#This is the same as BrainDictionary2 except that the keys are two word lists					
def BrainDictionary2(filename):
	#get the phrases out
	phrases = GetFile(filename)
	#for each phrase, split it into lists
	#then take all the elements except the last two and put them into dictionary
	#in sets of two
	#then put the next word into its value as a list
	#if the phrase is already in the dictionary, append the next word to the
	#value
	dictionary2 = {}
	for p in phrases:
		pwords = p.split(" ")
		lenp = len(pwords)
		if lenp > 1:
			i = 1
			while i<lenp-1:
				if (pwords[i-1],pwords[i]) not in dictionary2:
					dictionary2[(pwords[i-1],pwords[i])] = [pwords[i+1]]
				else:
					dictionary2[(pwords[i-1],pwords[i])].append(pwords[i+1])
				i+=1
	#print(dictionary2)
	return dictionary2
	

###############Making the next word################
#This function will take the brain and a word as input and generate a new word

def newWord1(words, dictionary1):
	if words in [keys for keys in dictionary1]:
		newWord = random.choice(dictionary1[words])
	else:
		newWord = random.choice([keys for keys in dictionary1])
	return newWord
	
def newWord2(words, dictionary1, dictionary2):
	#Find the highest dictionary it is it
	if words in [keys for keys in dictionary2]:
		newWord = random.choice(dictionary2[(words)])
	else:
		newWord = random.choice([keys for keys in dictionary1])
	return newWord

##############Making the sentence##################
#This function will be the heart of the game
#It will either make a number of new words from the user generated input
#Or it will allow the user to quit or enter their own word

def userInput(words, dictionary1, dictionary2):
	#Make the words into a sentence
	sentence = " ".join(words)
	if len(words)>=2:
		print("Your current sentence is: \n", sentence)
		inp = input("Please enter a word or a number: ")
	#See if it's an integer, if it's not, then we use the input to make 
	#a new word (unless its $q)
		try:
			num = int(inp)
			i=0
			while i<num:
				words.append(newWord2((words[i-1],words[i]), dictionary1, dictionary2))
				i+=1
		except ValueError:
			words.append(inp)
	elif len(words) == 1:
		inp = input("Please enter a word or a number: ")
		try:
			num = int(inp)
			i=0
			while i<num:
				words.append(newWord1((words[i]), dictionary1))
				i+=1
		except ValueError:
			words.append(inp)
	else:
		inp = input("Please enter the first word: ")
		words.append(inp)
	return words

#This function will print the instructions
def Instructions():
	print("Please enter the first (or next) word of your sentence")
	print("If you want me to talk, please enter the number of words you would like me to say")
	print("If you want to stop, you can press '$q' to quit at any time")
###############Running the game###############
#This is our game
def main():
	filename = sys.argv[1]
	#Our sentence is a list of words
	words = []
	dic1 = BrainDictionary1(filename)
	dic2 = BrainDictionary2(filename)
	#Instructions
	Instructions()
	#Get user input
	userInput(words, dic1, dic2)
	#Enter loop to make sure the last word isn't $q
	while words[-1]!= "$q":
		userInput(words, dic1, dic2)
	


	
main()
