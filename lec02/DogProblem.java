

public class DogProblem {
    public static Dog[] largerThanFourNeighbors(Dog[] dogs) {
        Dog[] returnDogs = new Dog[dogs.length];
        int count = 0;
        for (int i = 0; i < dogs.length; i++) {
            if (isBiggestOfFour(dogs, i)) {
                returnDogs[count] = dogs[i];
                count++;
            }
        }
        return returnDogs;
    }

    public static boolean isBiggestOfFour(Dog[] dogs, int index) {
        int count = 0;
        int shift = 1;
        boolean biggest = true;
        while (count < 4) {
            if (index - shift >= 0) {
                count++;
                if (dogs[index - shift].weightInPounds > dogs[index].weightInPounds) {
                    biggest = false;
                }
            }
            if (index + shift < dogs.length) {
                count++;
                if (dogs[index + shift].weightInPounds > dogs[index].weightInPounds) {
                    biggest = false;
                }
            }
            shift++;
        }
        return biggest;
    }

}