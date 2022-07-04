const expect = require("chai").expect;
const Cube = require("../src/cube").Cube;

// test suite for cube
describe("Cube", function () {
  //test cases
  const cube = new Cube(2);

  it("should return volume of 8", function () {
    // code under test
    const volume = cube.getVolume();
    // expected result
    expect(volume).to.equal(8);
  });

  it("should return surface area of 24", function () {
    // code under test
    const surfaceArea = cube.getSurfaceArea();
    // expected result
    expect(surfaceArea).to.equal(24);
  });

  it("should return length of 2", function () {
    // code under test
    const length = cube.getLength();
    // expected result
    expect(length).to.equal(2);
  });
});
