console.log("page is loaded and ready");

const btnRock = document.querySelector("#btnRock");
const btnPaper = document.querySelector("#btnPaper");
const btnScissors = document.querySelector("#btnScissors");
const resultMessage = document.querySelector("#result");
const statusMessage = document.querySelector("#status");
const userWins = document.querySelector("#userWins");
const systemWins = document.querySelector("#systemWins");

let userChoice = "";
let systemChoice = "";
let win = 0;
let lose = 0;
let result = "";
let choices = ["r", "p", "s"];

btnRock.addEventListener("click", function () {
  setUserChoice("r");
});

btnPaper.addEventListener("click", function () {
  setUserChoice("p");
});

btnScissors.addEventListener("click", function () {
  setUserChoice("s");
});

function getRandomIndex() {
  return Math.floor(Math.random() * choices.length);
}

function setUserChoice(choice) {
  userChoice = choice;
  systemChoice = choices[getRandomIndex()];
  result = play(userChoice, systemChoice);
  setResult(result);
  setStatus();
}

function setStatus() {
  statusMessage.innerText = `Your choice: ${getChoiceName(
    userChoice
  )} | System Choice: ${getChoiceName(systemChoice)}`;
  userWins.innerText = `User  ${win}`;
  systemWins.innerText = `System  ${lose}`;
}

function setResult(result) {
  if (result === "win") {
    ++win;
    resultMessage.innerText = "You win!";
    resultMessage.classList.remove("text-danger");
    resultMessage.classList.remove("text-warning");
    resultMessage.classList.add("text-success");
  } else if (result === "loose") {
    ++lose;
    resultMessage.classList.remove("text-success");
    resultMessage.classList.remove("text-warning");
    resultMessage.classList.add("text-danger");
    resultMessage.innerText = "You lose!";
  } else {
    resultMessage.innerText = "Draw!";
    resultMessage.classList.remove("text-success");
    resultMessage.classList.remove("text-danger");
    resultMessage.classList.add("text-warning");
  }
}

function getChoiceName(c) {
  switch (c.toLowerCase()) {
    case "r":
      return "Rock";
    case "p":
      return "Paper";
    case "s":
      return "Scissors";
  }
}

function play(user, sys) {
  let combined = user.trim() + sys.trim();
  switch (combined) {
    case "rs":
    case "pr":
    case "sp":
      return "win";
    case "rr":
    case "pp":
    case "ss":
      return "draw";
    default:
      return "loose";
  }
}
