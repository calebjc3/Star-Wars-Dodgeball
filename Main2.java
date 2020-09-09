import java.awt.Color;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Setup EZ graphics system
		EZ.initialize(1000, 600);

		//Set background picture
		EZ.addImage("space.png", 1000/2, 600/2);

		//Load sound effects for balls bouncing
		EZSound sound1 = EZ.addSound("ouch.wav");
		EZSound sound2 = EZ.addSound("Explosion1.wav");
		EZSound sound3 = EZ.addSound("Explosion2.wav");
		EZSound sound4 = EZ.addSound("plane1.wav");
		EZSound sound5 = EZ.addSound("buzz.wav");

		//Set color and fontsize of the text
		Color c = new Color(250, 200, 0);
		int fontsize = 50;

		//Make a text object labeled with "GO!"
		EZText text = EZ.addText(500, 100, "GO!", c, fontsize);
		text.setFont("starwars.TTF");

		//Set hits to zero
		int hits = 0;

		//Make a text object labeled with "HITS: 0 " and increase the value when player hit
		EZText text1 = EZ.addText(500, 560, "", c, fontsize);
		text1.setFont("starwars.TTF");
		text1.show();

		//Loads the xwing picture and assigns it to the variable playerPicture and positions it at 500, 300
		EZImage playerPicture = EZ.addImage("xwing.png", 500, 300);
		int width = playerPicture.getXCenter();
		int height = playerPicture.getYCenter();

		//Loads the fireball picture and assigns it to the variable object1 and positions it at 0, 0
		EZImage object1 = EZ.addImage("fireball.png", 0, 0);

		double distance = Math.sqrt((height*height)+(width*width));
		double directionX = 3;
		double directionY = 5;
		//Sets the initial position and direction of object1
		double posX = 0;
		double posY = 0;


		//Loads the deathstar picture and assigns it to the variable object2 and positions it at 1000, 0
		EZImage object2 = EZ.addImage("deathstar.png", 1000, 0);
		//Sets the initial position and direction of object2
		double pos2X = 1000;
		double pos2Y = 0;
		double direction2X = 3;
		double direction2Y = 5;

		//Loads the asteroid picture and assigns it to the variable object3 and positions it at 1000, 600
		EZImage object3 = EZ.addImage("asteroid.png", 1000, 600);
		//Sets the initial position and direction of object3
		double pos3X = 1000;
		double pos3Y = 600;
		double direction3X = 3;
		double direction3Y = 5;

		//Loads the tiefighter picture and assigns it to the variable object4 and positions it at 0, 600
		EZImage object4 = EZ.addImage("tiefighter.png", 0, 600);
		//Sets the initial position and direction of object4
		double pos4X = 0;
		double pos4Y = 600;
		double direction4X = 3;
		double direction4Y = 5;

		//Distance variables
		//double triangleWidth = (playerPicture.getXCenter()) - object1.getXCenter();
		//double triangleHeight = (playerPicture.getYCenter()) - object1.getYCenter();
		//double distance = Math.sqrt((triangleWidth*triangleWidth) + (triangleHeight*triangleHeight));

		//directionX = triangleWidth/distance;
		//directionY = triangleHeight/distance;

		//LOOP
		while (true) {

			text1.setMsg("Hits: "+ hits +"");
			EZ.app.pullToFront(text1);

			//Use the W,A,S,D keys to move the player
			if (EZInteraction.isKeyDown("d")) {
				playerPicture.moveForward(15);
			} else if (EZInteraction.isKeyDown("a")) {
				playerPicture.moveForward(-15);
			} else if (EZInteraction.isKeyDown("w")) {
				playerPicture.translateBy(0, -15);
			} else if (EZInteraction.isKeyDown("s")) {
				playerPicture.translateBy(0, 15); 
			}

			object1.translateTo(posX, posY); // Set the position of the fireball


			posX= posX+directionX;
			posY= posY+directionY;

			//Make the fireball switch directions when it hits the screen edge
			if (posX > 1000) {
				directionX = -directionX;
				sound2.play();
			}
			if (posX < 0) {
				directionX = -directionX;
				sound2.play();
			}
			if (posY > 600)	{
				directionY = -directionY;
				sound2.play();
			}
			if (posY < 5) {
				directionY = -directionY;
				sound2.play();
			}

			int w = 500;
			int h = 300;

			w = object1.getXCenter();
			h = object1.getYCenter();

			int w1 = playerPicture.getXCenter();
			int h1 = playerPicture.getYCenter();

			if (object1.isPointInElement(w1,h1)) {
				sound1.play();
				hits++;
				directionX = -directionX;
				//directionY = -directionY;
			}

			if (hits == 15) {
				text.setMsg("GAME OVER!");
				break;
			}

			object2.translateTo(pos2X, pos2Y); // Set the position of the lightsaber.

			//object1.rotateTo(rotationAngle); // Set the rotation angle of the lightsaber.

			pos2X= pos2X+direction2X;
			pos2Y= pos2Y+direction2Y;

			//Make the deathstar switch directions when it hits the screen edge
			if (pos2X > 1000) {
				direction2X = -direction2X;
				sound3.play();
			}
			if (pos2X < 0) {
				direction2X = -direction2X;
				sound3.play();
			}
			if (pos2Y > 600)	{
				direction2Y = -direction2Y;
				sound3.play();
			}
			if (pos2Y < 5) {
				direction2Y = -direction2Y;
				sound3.play();
			}


			w = object2.getXCenter();
			h = object2.getYCenter();

			int w2 = playerPicture.getXCenter();
			int h2 = playerPicture.getYCenter();

			if (object2.isPointInElement(w1,h1)) {
				sound1.play();
				hits++;
				direction2X = -direction2X;
				//direction2Y = -direction2Y;

			}
			object3.translateTo(pos3X, pos3Y); // Set the position of the lightsaber.

			//object1.rotateTo(rotationAngle); // Set the rotation angle of the lightsaber.

			pos3X= pos3X+direction3X;
			pos3Y= pos3Y+direction3Y;

			//Make the asteroid switch directions when it hits the screen edge
			if (pos3X > 1000) {
				direction3X = -direction3X;
				sound4.play();
			}
			if (pos3X < 0) {
				direction3X = -direction3X;
				sound4.play();
			}
			if (pos3Y > 600)	{
				direction3Y = -direction3Y;
				sound4.play();
			}
			if (pos3Y < 5) {
				direction3Y = -direction3Y;
				sound4.play();
			}


			w = object3.getXCenter();
			h = object3.getYCenter();

			int w3 = playerPicture.getXCenter();
			int h3 = playerPicture.getYCenter();

			if (object3.isPointInElement(w1,h1)) {
				sound1.play();
				hits++;
				direction3X = -direction3X;
				//direction3Y = -direction3Y;
			}

			if (hits == 15) {
				text.setMsg("GAME OVER!");
				break;
			}
			object4.translateTo(pos4X, pos4Y); // Set the position of the lightsaber.

			//object1.rotateTo(rotationAngle); // Set the rotation angle of the lightsaber.

			pos4X= pos4X+direction4X;
			pos4Y= pos4Y+direction4Y;

			//Make the tiefighter switch directions when it hits the screen edge
			if (pos4X > 1000) {
				direction4X = -direction4X;
				sound5.play();
			}
			if (pos4X < 0) {
				direction4X = -direction4X;
				sound5.play();
			}
			if (pos4Y > 600)	{
				direction4Y = -direction4Y;
				sound5.play();
			}
			if (pos4Y < 5) {
				direction4Y = -direction4Y;
				sound5.play();
			}
			w = object4.getXCenter();
			h = object4.getYCenter();

			int w4 = playerPicture.getXCenter();
			int h4 = playerPicture.getYCenter();

			if (object4.isPointInElement(w1,h1)) {
				sound1.play();
				hits++;
				direction4X = -direction4X;
				//direction4Y = -direction4Y;
			}

			if (hits >= 3) {
				text.setMsg("GAME OVER!");
				EZ.app.pullToFront(text);

				break;
			}


			// Make sure to do this or else the graphics won't refresh
			EZ.refreshScreen(); 

		}
	}
}
