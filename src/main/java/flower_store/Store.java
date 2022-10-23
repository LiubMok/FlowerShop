package flower_store;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Store {
    private final IInventory inventory;
    private SellManager sellManager;

    public Store(IInventory inventory, SellManager sellManager) {
        this.inventory = inventory;
        this.sellManager = sellManager;
    }

    //TODO    створити тимчасовий бакет який буде формуватись протягом підбору квітів
//    public void add(FlowerBucket flowerBucket) {
//        inventory.addFlowerPack(flowerBucket);
//    }

    /**
     * method has to check whether such flowerPack is in the program
     * and return amount of such flowers in the shop
     */
    public int search(Flower flower) {
        FlowerPack flowerPackToFind = new FlowerPack(flower, 1);
        if (inventory.isExist(flowerPackToFind)) {
            return inventory.getFlowerPack(flowerPackToFind).getQuantity();
        }
        return 0;
    }

    public void endOrder(FlowerBucket order) {
        for (FlowerPack flowerPack : order.getBucket()) {
            sellManager.sellFlowerPack(flowerPack);
        }
    }

    public void formOrder() {
        Scanner communicator = new Scanner(System.in);
        System.out.print("What is your budget for the bucket: ");
        int budget = communicator.nextInt();
        Order order = new Order(inventory, budget);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Ok, let's form you a bucket!!!");
        while (true) {
            Flower flower = new Flower();
            System.out.println("Which type of flowers would you like to add to the bucket");
            List<FlowerType> flowerTypes = inventory.getAllFlowerPacks()
                    .stream()
                    .map(flowerPack -> flowerPack.getFlower().getFlowerType())
                    .distinct()
                    .collect(Collectors.toList());
            while (true) {
                int counter = 1;
                for (FlowerType flowerType : flowerTypes) {
                    System.out.println(counter++ + ". " + flowerType);
                }
                int flowerTypeIndex = communicator.nextInt() - 1;
                if (flowerTypeIndex < flowerTypes.toArray().length) {
                    flower.setFlowerType(flowerTypes.get(flowerTypeIndex));
                    break;
                }
                System.out.println("Sorry, but I've chosen not existed flower int the store...");
                System.out.println("P.s please, enter the number of flower that you'd like to add)");
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Now let's choose a color");
            List<FlowerColor> flowerColors = inventory.getAllFlowerPacks()
                    .stream()
                    .filter(flowerPack -> flowerPack.getFlower().getFlowerType().equals(flower.getFlowerType()))
                    .map(flowerPack -> flowerPack.getFlower().getColor())
                    .distinct()
                    .collect(Collectors.toList());
            while (true) {
                int counter = 1;
                for (FlowerColor color : flowerColors) {
                    System.out.println(counter + ". " + color);
                }
                int flowerColorIndex = communicator.nextInt() - 1;
                if (flowerColorIndex < flowerColors.toArray().length) {
                    flower.setColor(flowerColors.get(flowerColorIndex));
                    break;
                }
                System.out.println("--------------------------------------------------------------");
                System.out.println("Sorry, but I've chosen not existed color within flowers...");
                System.out.println("P.s please, enter the number of flower that you'd like to add)");
                System.out.println("--------------------------------------------------------------");
            }
            int amountInTheStore = search(flower);
            int affordableAmount = budget / inventory.getFlowerPack(new FlowerPack(flower, 1)).getFlower().getPrice();
            System.out.println(affordableAmount);
            int amountToBuy;
            while (true) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("For your budget you can afford to buy " + affordableAmount + " of " + flower.getColor().toString() + " " + flower.getFlowerType().toString() + "s");
                System.out.println("The are " + search(flower) + " " + flower.getColor() + " " + flower.getFlowerType() + "s in the store");
                System.out.println("--------------------------------------------------------------");
                System.out.println("Please write the amount of flowers you want to add");
                amountToBuy = communicator.nextInt();
                if (amountToBuy <= search(flower) && amountToBuy <= affordableAmount) {
                    System.out.println("Ok, pack of " + flower.getFlowerType() + " is added to your bucket");
                    break;
                } else if (amountToBuy > search(flower)) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Sorry but there are only " + amountInTheStore + " of " + flower.getFlowerType() + " in the shop");
                    System.out.println("Maybe you will by less flowers?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int answer = communicator.nextInt();
                    System.out.println("--------------------------------------------------------------");
                    if (answer != 1) {
                        break;
                    }
                } else {
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Sorry, but you can not afford that amount of " + flower.getFlowerType() + " to buy");
                    System.out.println("P.s please, enter the number from the range of your ability");
                }
            }
            FlowerPack flowerPackToBucket = new FlowerPack(flower, amountToBuy);
            int priceOfFlower = inventory.getFlowerPack(flowerPackToBucket).getFlower().getPrice();
            flowerPackToBucket.getFlower().setPrice(priceOfFlower);
            if (inventory.isExist(flowerPackToBucket)) {
                budget = order.setFlowerToOrder(flowerPackToBucket);
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Would you like to add more packs?");
            System.out.println(1 + ". Yes");
            System.out.println(2 + ". No");
            int endOrNot = communicator.nextInt();
            if (endOrNot == 2) {
                break;
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("You have " + budget + " on your budget");
            System.out.println("Your order: " + order.getOrder());
        }
        endOrder(order.getOrder());
        System.out.println(order.getOrder());
    }
}