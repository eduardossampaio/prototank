//Motor A 
int dir1PinA = 13;
int dir2PinA = 12; 
int speedPinA = 10;

//motor B 
int dir1PinB = 11;
int dir2PinB = 8; 
int speedPinB = 9;

unsigned long time; 
int speed_; 
int dir; 
void setup() {

  pinMode (dir1PinA, OUTPUT); 
  pinMode (dir2PinA, OUTPUT); 
  pinMode (speedPinA, OUTPUT); 
  pinMode (dir1PinB, OUTPUT); 
  pinMode (dir2PinB, OUTPUT); 
  pinMode (speedPinB, OUTPUT); 
  time = millis (); 
  speed_ = 0; 
  dir = 1;

}

void loop() {

  speed_ = 255;
  analogWrite (speedPinA, speed_); 
  analogWrite (speedPinB, speed_);

  dir = 1;
  

  // set direction 
 
    digitalWrite (dir1PinA , LOW); 
    digitalWrite (dir2PinA, HIGH); 
    digitalWrite (dir1PinB, HIGH); 
    digitalWrite (dir2PinB, LOW);
  

}
