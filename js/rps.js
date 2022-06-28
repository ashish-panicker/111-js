/*
 * Rock Paper Scissors game using Javascript
 */

let userChoice = ''
let systemChoice = ''

let choices = ['r', 'p', 's']

function getRandomIndex(){
  return Math.floor(Math.random() * choices.length)
}

function getSystemChoice(){
  let random = getRandomIndex()
  return choices[random]
}

function getUserChoice(){
  let random = getRandomIndex()
  return choices[random]
}

function play(user, sys){
  let combined = user.trim() + sys.trim()

  switch(combined){
    // user win scenarios
    // r + s
    // p + r 
    // s + p
    case 'rs':
    case 'pr':
    case 'sp':
      console.log(`The user chose ${user} and system chose ${sys}, so the user wins.`)
      break;
    default:
      console.log('The system wins.')
  }
}


setUserChoice = getUserChoice()
systemChoice = getSystemChoice()

play(setUserChoice, systemChoice)
