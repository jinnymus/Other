import copy
import re
from sys import stdin
import time
from datetime import datetime, date
import random


global names_m
global names_f
#file = open('HP-HP0-M48 quests-n-answrs.txt', 'r')
file_time = datetime.strftime(datetime.now(), "%Y.%m.%d_%H.%M.%S")

file = open('data_full_change3.txt', 'r')
print '[main] answers_file: ', file_time
answers_file = open('answers_' + file_time + '.dat', 'w')

def list2str( list ):
	ret = ''
	for ai in list:
		if (ret == ''):
			ret += ai
		else:	
			ret += ',' + ai
	return ret

answers = 0
questions = 0

begin_time = time.time()
answer=''
for line in file:
	line = line.rstrip()
	pattern = re.compile("^(Answer).*")
	if (re.match('^#.*', line)):
		list=[]
		list_cnt=[]
		list_cnt_true=[]
		cnt = 0
	if (re.match('^Answer.*', line)):
		questions += 1
		i = 1
		num = 1
		list_cnt_true=copy.copy(list_cnt)
		list_rnd=copy.copy(list) 
		random.shuffle(list_rnd)
		answer_true = line[line.find(':')+2::]
		answer_true_list = answer_true.split(',')
		answer_true_list.sort()
		k = 0
		ans_true=''
		for i in list_rnd:
			print list_cnt_true[k] + '. ' + i[i.find('.')+2::].strip()
			true = list_cnt_true[k].strip()
			for la in answer_true_list:
				if (re.match("^" + la + "\. .*", i)):
					if (ans_true == ''):
						ans_true += list_cnt_true[k]
					else:
						ans_true += ',' + list_cnt_true[k]
			k += 1
		#print 'true answer: ', ans_true
		answer = stdin.readline().strip().upper()
		print 'You entered: ' + answer
		answers_file.write('Answer: ' + answer + '\n')
		if (answer == ans_true):
			print 'You answer PASS'
			answers += 1
		else:
			print 'You answer WRONG'
		print 'True Answer: ', ans_true
	elif (re.match('(^[A-Z]\.).*', line)):
		cnt += 1
		letter = line[0:1:]
		list_cnt.append(letter)
		list.append(line)
		answers_file.write(line + '\n')
	else:
		print line
		answers_file.write('Answer: ' + answer + '\n')
		
end_time = time.time()

print "Questions: ", questions
print "Pass answers: ", answers
print "Pass percent: ", answers*100/questions, '%'
if (answers*100/questions > 80):
	print 'You pass the exam. Congratulations!'
else:
	print 'You fail the exam. Try else!'
print 'you spent ', (end_time - begin_time)/60, ' minutes'


