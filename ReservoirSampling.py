import random

n=1000
k=10
stream=[random.randrange(n) for x in xrange(n)]
result=[0]*k

for i in xrange(k):
  result[i]=stream[i]

for i in xrange(k,n):
  r=random.randrange(1,i)
  if r<k:
    result[r]=stream[i]

print result 

