#Markov sentence generator

#The structure of the code will be as follows.

#First we make a function that takes the previous n words and randomly
#generates the next word. 

#Create a function that makes a table (list) out of a text document
#This table will contain a list of n-word prefixes (1-3) and a list of "next 
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
#dictionaries will have the key be all consequetive sequences of words of each phrase (except the last one)
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
	return dictionary1

#This is the same as BrainDictionary2 except that the keys are two word lists
#Note that the key is actually a tuple. This was necessary for some reason					
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
	return dictionary2
	
def BrainDictionary3(filename):
	#get the phrases out
	phrases = GetFile(filename)
	#for each phrase, split it into lists
	#then take all the elements except the last two and put them into dictionary
	#in sets of two
	#then put the next word into its value as a list
	#if the phrase is already in the dictionary, append the next word to the
	#value
	dictionary3 = {}
	for p in phrases:
		pwords = p.split(" ")
		lenp = len(pwords)
		if lenp > 2:
			i = 1
			while i<lenp-1:
				if (pwords[i-2],pwords[i-1],pwords[i]) not in dictionary3:
					dictionary3[(pwords[i-2],pwords[i-1],pwords[i])] = [pwords[i+1]]
				else:
					dictionary3[(pwords[i-2],pwords[i-1],pwords[i])].append(pwords[i+1])
				i+=1
	return dictionary3
###############Making the next word################
#This function will take the brain and a word as input and generate a new word
#The number refers to how many words back the program looks

#Basically there are four ways to get a new word. You can either look at the 
#previous 3,2 or 1 word or to pick a completely random one. The following functions
#generate a random word based on the file input

#If newWord3 doesn't work, it calls newWord2 and so on... If newWord 1 doesn't work
#it just picks a random word from the list of keys

def newWord1(words, dictionary1):
	if words in dictionary1:
		newWord = random.choice(dictionary1[words])
	else:
		newWord = random.choice([keys for keys in dictionary1]) #fancy way to get a list of keys
	return newWord
	
def newWord2(words, dictionary1, dictionary2):
	#Find the highest dictionary it is it
	if words in dictionary2:
		newWord = random.choice(dictionary2[words])
	else:
		words = words[0]
		newWord = newWord1(words,dictionary1)
	return newWord

def newWord3(words, dictionary1, dictionary2, dictionary3):
	#Find the highest dictionary it is it
	if words in dictionary3:
		newWord = random.choice(dictionary3[words])
	else:
		words = (words[-2],words[-1])
		newWord = newWord2(words, dictionary1, dictionary2)
	return newWord
	
#Consolidate the three previous functions into something that takes your
#words, cuts off the last three and feeds them into it

def newWord(words, dictionary1, dictionary2, dictionary3):
	l = len(words)
	if l>=3:
		word3tuple = (words[-3],words[-2],words[-1])
	elif l == 2:
		word3tuple = (words[0],words[1])
	elif l==1:
		word3tuple = (words[0])
	new = newWord3(word3tuple, dictionary1, dictionary2, dictionary3)
	return new

##############Making the sentence##################
#This function will be the heart of the game
#It will either make a number of new words from the user generated input
#Or it will allow the user to quit or enter their own word

def userInput(words, dictionary1, dictionary2, dictionary3):
	#Make the words into a sentence
	sentence = " ".join(words)
	print("Your current sentence is: \n", sentence)
	inp = input("Please enter a word or a number or '$q': ")
	l=len(words)
	#This was the way to check if the input is an integer or not (from stackoverflow)
	
	#If it's an integer, it creates a new word that many times by iterating from the
	#size of the sentence to the desired size (num +l)
	try:
		num = int(inp)
		i = l
		while i<num+l:
			words.append(newWord(words, dictionary1, dictionary2, dictionary3))
			i+=1
			
	except ValueError:
			words.append(inp)


#This function will print the instructions
def Instructions():
	print("******************************************************************************\n******************************************************************************\nYou can make me talk by entering the number of words you would like me to say")
	print("Or you can persuade me to talk about something else by entering \nthe next word yourself")
	print("If you want to stop, you can press '$q' to quit at any time \n******************************************************************************\n******************************************************************************")
###############Running the game###############
#This is our game
def main():
	#The user must specify the seed file
	filename = sys.argv[1]
	#Our sentence is a list of words
	words = []
	#Generate our important dictionaries
	dic1 = BrainDictionary1(filename)
	dic2 = BrainDictionary2(filename)
	dic3 = BrainDictionary3(filename)
	#Instructions
	Instructions()
	#Get user input
	inp2 = input("Please enter the first word: \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
	words.append(inp2)
	#Enter loop to make sure the last word isn't $q
	#We use a dollar sign to make sure the list won't append the quit tag
	#by accident
	while words[-1]!= "$q":
		userInput(words, dic1, dic2, dic3)
	#Summarize output
	numwords = len(words)-1
	dicsize = len(dic1) + len(dic2) + len(dic3) 
	print("Your final sentence was:\n\n"," ".join(words),"\n\n")
	print("You made a",numwords,"words long sentence")
	print("Our dictionary had", dicsize ,"entries")
	


	
main()
