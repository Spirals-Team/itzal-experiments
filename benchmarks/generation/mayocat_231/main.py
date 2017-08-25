#!/bin/python

import requests
<<<<<<< Updated upstream

s = requests.Session()

r = s.get("http://172.17.0.3:8080")
print(r.status_code)
r = s.post("http://172.17.0.3:8080/cart/add", {"product": "product"})
print(r.status_code)
r = s.get("http://172.17.0.3:8080")
print(r.status_code)
=======
import urllib
import time

s = requests.Session()

nbExecution = 50

totalShadow= 0
totalOrigin = 0

start = time.time()
for x in xrange(0,nbExecution):
	nf = urllib.urlopen("http://172.17.0.72:8080")
	page = nf.read()
	nf.close()
end = time.time()
totalOrigin += end - start

start = time.time()
for x in xrange(0,nbExecution):
	nf = urllib.urlopen("http://localhost:9999/")
	page = nf.read()
	nf.close()
end = time.time()
totalShadow += end - start



execOrigin = totalOrigin/nbExecution
execShadow = totalShadow/nbExecution
print (totalShadow-totalOrigin)*100/(totalOrigin)
print "Origin: {0} {1} execution time (sec), {2} request/min".format(totalOrigin, totalOrigin/nbExecution, 60 / (execOrigin/nbExecution))
print "Shadow: {0} {1} execution time (sec), {2} request/min".format(totalShadow, totalShadow/nbExecution, 60 / (execShadow/nbExecution))
>>>>>>> Stashed changes
