package Lesson1DZ.five;

public class main {

        static Animal[] animals = new Animal[8];
        static  int distance = 500;
        static float barier = 2f;
        static int pool = 50;

        private static void listCreater () {
            Dog oneDog = new Dog("Sharic", "White", 2018);
            Dog twoDog = new Dog("Tuzik", "Black", 2015);
            Cat oneCat = new Cat("Vaska", "Red", 2021);
            Cat twoCat = new Cat("Tichka", "Braun", 2019);
            Horse oneHorse = new Horse("Napaleon", "Voronoy", 2010);
            Horse twoHorse = new Horse("Molnia", "Gnedoy", 2012);
            Bird oneBird = new Bird("Pirat", "Pestriy", 2020);
            Bird twoBird = new Bird("Kecha", "Obchipaniy", 2021);

            animals[0] = oneDog;
            animals[1] = twoDog;
            animals[2] = oneCat;
            animals[3] = twoCat;
            animals[4] = oneHorse;
            animals[5] = twoHorse;
            animals[6] = oneBird;
            animals[7] = twoBird;
        }


       private static void testAnimals () {
        for (int i = 0; i < animals.length; i++) {
            String plavuchect = animals[i].swimmingLimit > 0 ? "и проплыл" : ", участник испугался воды, результат ";
            System.out.printf("Участник %s возрастом %d %s цвета, \nна испытаниях показавший %d м бег, %.2f м прыжок %s %d\n",animals[i].name, animals[i].age,animals[i].colour,
                    animals[i].runLimit,animals[i].jumpLimit,plavuchect,animals[i].swimmingLimit);
        }
           System.out.println();
           System.out.println();
        for (int j = 0; j < animals.length; j++) {
            if (animals[j].runLimit > distance) System.out.println(animals[j].name + " прошел дистанцию");
            else System.out.println(animals[j].name + " не добежал");
            if (animals[j].jumpLimit > barier) System.out.println(animals[j].name + " преодолел барьер");
            else System.out.println(animals[j].name + " прыгнул низко");
            if (animals[j].swimmingLimit > pool) System.out.println(animals[j].name + " переплыл");
            else System.out.println(animals[j].name + " участок оказался не преодолимым");
        }
    }

    public static void main (String[] args) {
        listCreater();
        testAnimals();
    }


}
