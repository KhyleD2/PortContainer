HOW TO RUN 
in terminal>>  javac PortContainerManagement.java
>> javac PortContainerManagement




#Sample run

Requirements
1. Create ADT Classes
Container class

Fields: id, description, weight
Constructor to initialize values
toString() →
 
CT001 | Electronics | 500kg
 
Ship class

Fields: name, captain
Constructor to initialize values
toString() →
 
MV OceanStar | Capt. Reyes
2. Use Data Structures
ArrayDeque<Container> containerStack → to store containers (LIFO).
ArrayDeque<Ship> shipQueue → to store ships (FIFO).
3. Implement Menu Operations
 
=== Port Container Management System ===
[1] Store container (push)
[2] View port containers
[3] Register arriving ship (enqueue)
[4] View waiting ships
[5] Load next ship (pop container + poll ship)
[0] Exit
Behavior
[1] Store container

Ask for id, description, and weight.
Push to containerStack.
Sample Output:

 
Stored: CT002 | Fruits | 200kg
 
[2] View port containers

Show containers top to bottom.
 
TOP →
CT003 | Clothes     | 100kg
CT002 | Fruits      | 200kg
CT001 | Electronics | 500kg
← BOTTOM
[3] Register arriving ship

Ask for ship name and captain.
Enqueue to shipQueue.
Sample Output:

 
Registered: MV OceanStar | Capt. Reyes
 
[4] View waiting ships

Show ships front to rear.
 
FRONT →
MV OceanStar | Capt. Reyes
MV SeaWave   | Capt. Santos
← REAR
[5] Load next ship

Pop container from containerStack.
Poll ship from shipQueue.
Print loading result.
Sample Output:

 
Loaded: CT003 | Clothes | 100kg → MV OceanStar | Capt. Reyes
Remaining containers: 2
Remaining ships waiting: 1
[0] Exit

Ends program.
