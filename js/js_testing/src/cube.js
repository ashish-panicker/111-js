class Cube {
  constructor(length) {
    this.length = length;
  }

  getVolume() {
    return Math.pow(this.length, 3);
  }

  getSurfaceArea() {
    return 6 * Math.pow(this.length, 2);
  }

  getLength() {
    return this.length;
  }
}

module.exports = { Cube: Cube };
