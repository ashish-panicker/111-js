class StringUtils {
  constructor(str) {
    this.str = str;
  }

  // get the length of the string
  getLength() {
    return this.str.length;
  }

  // reverse the string
  reverse() {
    return this.str.split("").reverse().join("");
  }

  // check if the string is palindrome
  isPalindrome() {
    return this.str === this.reverse();
  }
}
module.exports = { StringUtils: StringUtils }
