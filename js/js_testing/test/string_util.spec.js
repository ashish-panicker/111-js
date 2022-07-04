const StringUtils = require('../src/string_util').StringUtils
const expect = require('chai').expect

describe('StringUtils',  () => {

    const util = new StringUtils('hello')

    it('should return the length of the string', () => {
        expect(util.getLength()).to.equal(5)
    })

    it('should reverse the string', () => {
        expect(util.reverse()).to.equal('olleh')
    })

    it('should check if the string is not palindrome', () => {
        expect(util.isPalindrome()).to.equal(false)
    })
})