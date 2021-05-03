var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];

function userNameAge(arr) {
    for (i=0;i<users.length;i++){
        console.log(arr[i].name + " - " + arr[i].age);
    }
}

userNameAge(users);