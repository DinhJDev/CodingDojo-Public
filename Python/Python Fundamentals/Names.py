students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def fullNames(arr):
    for x in range(0,len(arr)):
        print(arr[x]['first_name'] + " " + arr[x]['last_name'])

fullNames(students)