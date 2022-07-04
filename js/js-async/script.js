const even = (num) => console.log(`Success, ${num} is even.`);

const odd = (num) => console.log(`Error, ${num} is odd.`);

const checkNumber = (num, e, o) => {
  if (num % 2 === 0) {
    e(num);
  } else {
    o(num);
  }
};

document.getElementById("check").addEventListener("click", () => {
  const num = document.getElementById("number").value;
  checkNumber(
    num,
    (n) => console.log(`Success, ${n} is an even number`),
    (n) => console.log(`Error, ${n} is an odd number`)
  );
});

document.addEventListener("DOMContentLoaded", async () => {
  let number = Math.floor(Math.random() * 100);
  console.log(number);
  //   someAsyncFunction(number).then((result) => {
  //     console.log(result);
  //   });

  let result = await someAsyncFunction(number);
  console.log(result);

  palindromPromise
    .then((result) => {
      console.log(result);
    })
    .catch((err) => {
      console.log(err);
    });
});

// promise to check odd or even
const palindromPromise = new Promise((resolve, reject) => {
  const palindrom = "hello";
  if (palindrom === palindrom.split("").reverse().join("")) {
    resolve(`${palindrom} is a palindrom`);
  } else {
    reject(`${palindrom} is not a palindrom`);
  }
});

const someAsyncFunction = async (number) => {
  if (number % 2 === 0) {
    return "Even";
  }
  return "Odd";
};
