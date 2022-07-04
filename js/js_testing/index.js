
const Cube = require('./src/cube').Cube

console.log('Creating a cube with length of 2...');
let cube = new Cube(2);
console.log('The volume of the cube is:', cube.getVolume());
console.log('The surface area of the cube is:', cube.getSurfaceArea());
console.log('The length of the cube is:', cube.getLength());

console.log('Creating a cube with length of 3...');
cube = new Cube(3);
console.log("The volume of the cube is:", cube.getVolume());
console.log("The surface area of the cube is:", cube.getSurfaceArea());
console.log("The length of the cube is:", cube.getLength());

console.log('exiting')
