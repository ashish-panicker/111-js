let fullName:string
let age:number
let address:string
let isTrained:boolean
let topics:string[]
let favourites:any[]

fullName = "Arun";
age = 21
address = 'Bangalore'
isTrained = false
topics = ["Angular", "TypeScript"]
favourites = [10, "Gone With the Wind", false]

console.log(`${fullName} is of age ${age} living at ${address} and is ${isTrained ? "trained" : "not trained"}`)
console.log(`${fullName} is interested in ${topics.join(", ")}`)
console.log('end of program')

let ram = new Student()
ram.name = "Ram"
ram.age = 21
ram.marks = 100
ram.topics = ["Angular", "TypeScript"]
ram.display()

let point1 = new Point()
