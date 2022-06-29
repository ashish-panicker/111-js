function sayHello(){
  console.log('welcome to java script')
}

function print(name, message){
  console.log(message + ' to ' + name)
  //console.log(message . 'to ' . name)
  console.log(`${message} to ${name}`)
}

function largerOfTwo(first, second){

  console.log(`first is a ${typeof first} and second is a ${typeof second}`)

  if(first > second){
    console.log(`${first} is larger than ${second}`)
  }else if(first === +second){
    console.log(`${first} is equal to ${second}`)
  }else{
    console.log(`${first} is smaller than ${second}`)
  }

}




//sayHello()

//print('ashish', 'say hello')

//largerOfTwo(5, 10)

//largerOfTwo(10, 5)

largerOfTwo(10, 10)

largerOfTwo(10, '10')

