public class DogLauncher {
    public static void main(String[] args) {
        Dog smallDog = new Dog(5);
   		Dog mediumDog = new Dog(25);
        Dog hugeDog = new Dog(150);
        // smallDog.makeNoise();
        // hugeDog.makeNoise();
        // Dog[] dogs = new Dog[2];
        // dogs[0] = new Dog(8);
        // dogs[1] = new Dog(20);
        // dogs[0].makeNoise(); 
        // dogs[1].makeNoise();

 
   		Dog[] manyDogs = new Dog[3];  
        manyDogs[0] = smallDog;
   		manyDogs[1] = hugeDog;    	   
        manyDogs[2] = new Dog(130);
 
   		for (int i = 0; i < manyDogs.length; i++)
        {
       		Dog.maxDog(manyDogs[i], mediumDog).makeNoise();
        }
    }
}