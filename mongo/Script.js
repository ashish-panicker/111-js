show databases

use batch_111

show collections

use sampledb

show collections

use batch_111

db.mentors.insertOne
(
    {
        "name":"Ashish S", 
        "email":"ashish.s",
        "technologies": ["Java", "CSS"],
        "address": {
            "city":"TVPM", "state":"KL", "country":"IN"
        }
    }
)

db.mentors.find()

db.mentors.insertMany
([
    {
        "name":"Prasad D", 
        "email":"prasad.d",
        "technologies": ["Java", "Testing"],
        "address": {
            "city":"MUM", "state":"MH", "country":"IN"
        }
    },
    {
        "name":"Vaman D", 
        "email":"Vaman.d",
        "technologies": ["Java", "Angular"],
        "address": {
            "city":"HYD", "state":"TL", "country":"IN"
        }
    }
])

db.mentors.find()

db.items.insertMany
([
    { "item": "journal", "qty": 25, "size": { "h": 14, "w": 21, "uom": "cm" }, "status": "A" },
    { "item": "notebook", "qty": 50, "size": { "h": 8.5, "w": 11, "uom": "in" }, "status": "A" },
    { "item": "paper", "qty": 100, "size": { "h": 8.5, "w": 11, "uom": "in" }, "status": "D" },
    { "item": "planner", "qty": 75, "size": { "h": 22.85, "w": 30, "uom": "cm" }, "status": "D" },
    { "item": "postcard", "qty": 45, "size": { "h": 10, "w": 15.25, "uom": "cm" }, "status": "A" }
])

db.items.insertMany( [
   {
      "item": "nuts", "quantity": 30,
      "carrier": { "name": "Shipit", "fee": 3 }
   },
   {
      "item": "bolts", "quantity": 50,
      "carrier": { "name": "Shipit", "fee": 4 }
   },
   {
      "item": "washers", "quantity": 10,
      "carrier": { "name": "Shipit", "fee": 1 }
   }
] )

db.items.insertOne(    { "item": "letter", "qty": 87, "size": { "h": 9.5, "w": 14.25, "uom": "cm" }, "status": "B" }      )

db.items.find()

//find all items with status 'A'
db.items.find({"status": "A"})

//find all items where qty is 100
db.items.find({"qty": 100})

//find all items where status is either 'A' or 'D'
db.items.find({"status": { $in: ["A", "D"]}})

//find all items where status is neither 'A' or 'D'
db.items.find({"status": { $nin: ["A", "D"]}})

//find all items where quantity is more than 20
db.items.find({"qty": { $gt: 20}})

//find all items whose status is either 'A' or has qty less than 30
db.items.find( {  $or: [ {"status":"A"} , { qty: { $lt: 30 } } ]  } )

db.items.find()

//delete from items where item is 'washers'
db.items.deleteOne( { "item":"washers" } )
