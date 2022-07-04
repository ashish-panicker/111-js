const largestOfTwo = (a, b) => {
  return a > b ? a : b;
};

const largestOfThree = (a, b, c) => {
  return largestOfTwo(a, b) > c ? largestOfTwo(a, b) : c;
};

module.exports = { largestOfTwo, largestOfThree };