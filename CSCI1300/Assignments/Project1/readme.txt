#########################Sentence Generator##############################
This python program is able to generate a random sentence in based on 
a seed file. The generated sentences are remarkably similar to their seed
files. There is an interactive feature that allows the user to "help" the
computer finish the sentence, but that is not completely necessary.

It is important to start the program correctly and use the correct syntax.
It must be run from the command line and the argument needs to be the text
seed file. It will take a few seconds to generate the necessary dictionaries
(even for entire books). It is not ideal to have extensive line breaks
and unusual punctuation in the text files. However, the program formats it
extensively so that it will have minimal effect. Nearly any text copied from the
Internet will work with little to no formatting.

Once you run the program, you must supply it with an itial word. Then you can 
supply additional words to help the generator say what you want it to say.
You can also input an integer if you want the program to generate that many
more words.

At any time in the program, you can exit by typing '$q'. This will close the
program from the terminal.

Included are three sample seed files. Dicken's Tale of two cities, Romeo and Juliet
and a (complete?) list of Bob Dylan's song lyrics.

The program uses a third order markov process to model the sentence structure.
It constructs probabilities for the next word given a specific three letter phrase.

Enjoy!
#########################################################################
