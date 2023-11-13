import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShoppingManager shoppingManager = ShoppingManager.getInstance();

        Observer BoardObserver = new BoardObserver();
        Observer CardObserver = new CardObserver();
        Observer removeFromBoardObserver = new RemoveFromBoardObserver();
        Observer payCheckObserver = new PayCheckObserver();

        shoppingManager.addObserver(BoardObserver);
        shoppingManager.addObserver(CardObserver);

        /*<----------------------------factory cakes---------------------------->*/
        CakeFactory chocolateCakeFactory = new ChocolateCakeFactory();
        Cake chocolateCake = chocolateCakeFactory.createCake();
        CakeDecorator chocolateCakeDecorator = new CakeDecorator(chocolateCake);

        CakeFactory strawberryCakeFactory = new StrawberryCakeFactory();
        Cake strawberryCake = strawberryCakeFactory.createCake();
        CakeDecorator strawberryCakeDecorator = new CakeDecorator(strawberryCake);
        /*<----------------------------factory cakes---------------------------->*/

        /*<----------------------------Prototype---------------------------->*/
        Cake clonedCake = new Cake();
        /*<----------------------------Prototype---------------------------->*/

        /*<----------------------------Pay Cake---------------------------->*/
        Cake payCake = new Cake();
        /*<----------------------------Pay Cake---------------------------->*/

        /*<----------------------------building cakes--------------------------->*/
        //Cake myOwnCake = new CakeBuilder("Strawberry", "Medium").withCream("Strawberry Cream").withFilling("Vanilla Filling").build();
        /*<----------------------------building cakes--------------------------->*/

        /*<--------------------------------Menu--------------------------------->*/
        System.out.println("Добро пожаловать в наш кондитерский магазин!\n Что желаете?\n1 - Выбрать готовый торт.\n2 - Создать свой торт");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if(x == 1){
            System.out.println("\n\n\nКакой торт выберете?\n1 - " + chocolateCakeDecorator.getCake() + "\n2 - " + strawberryCakeDecorator.getCake());
            sc.nextLine();
            x = sc.nextInt();
            if(x == 1){
                System.out.println("Отличный выбор!");
                shoppingManager.addToCart(chocolateCake);
                payCake = chocolateCake;
            }
            if(x == 2){
                System.out.println("Отличный выбор!");
                shoppingManager.addToCart(strawberryCake);
                payCake = strawberryCake;
            }
        }
        if(x == 2){
            System.out.println("Хотите создать новый торт или изменить существующий?\n1 - Создать с нуля\n2 - Изменить существующий");
            sc.nextLine();
            x = sc.nextInt();
            if(x == 1){
                System.out.println("Хорошо, введите характеристики торта через ', '!");
                sc.nextLine();
                String[] cakeParameters = sc.nextLine().split(", ");
                Cake myOwnCake = new CakeBuilder(cakeParameters[0], cakeParameters[1]).withCream(cakeParameters[2]).withFilling(cakeParameters[3]).build();
                System.out.println("Отличный выбор!");
                shoppingManager.addToCart(myOwnCake);
                payCake = myOwnCake;
            }
            if(x == 2){
                System.out.println("Какой торт вы хотите изменить?\n1 - " + chocolateCakeDecorator.getCake() + "\n2 - " + strawberryCakeDecorator.getCake());
                sc.nextLine();
                x = sc.nextInt();
                if(x == 1){
                    System.out.println("Что хотите изменить в этом торте?\n1 - Начинку\n2 - Крем");
                    sc.nextLine();
                    x = sc.nextInt();
                    clonedCake = chocolateCake.clone();
                    if(x == 1){
                        System.out.println("На какую начинку хотите заменить?\n1 - Chocolate Filling\n2 - Strawberry Filling\n3 - Vanilla Filling");
                        sc.nextLine();
                        x = sc.nextInt();
                        if(x == 1){
                            clonedCake.setFilling("Chocolate Filling");
                        }
                        if(x == 2){
                            clonedCake.setFilling("Strawberry Filling");
                        }
                        if(x == 3){
                            clonedCake.setFilling("Vanilla Filling");
                        }
                    }
                    else{
                        System.out.println("На какой крем хотите заменить?\n1 - Chocolate Cream\n2 - Strawberry Cream\n3 - Vanilla Cream");
                        sc.nextLine();
                        x = sc.nextInt();
                        if(x == 1){
                            clonedCake.setCream("Chocolate Cream");
                        }
                        if(x == 2){
                            clonedCake.setCream("Strawberry Cream");
                        }
                        if(x == 3){
                            clonedCake.setCream("Vanilla Cream");
                        }
                    }
                }
                else if(x == 2){
                    System.out.println("Что хотите изменить в этом торте?\n1 - Начинку\n2 - Крем");
                    sc.nextLine();
                    x = sc.nextInt();
                    clonedCake = strawberryCake.clone();
                    if(x == 1){
                        System.out.println("На какую начинку хотите заменить?\n1 - Chocolate Filling\n2 - Strawberry Filling\n3 - Vanilla Filling");
                        sc.nextLine();
                        x = sc.nextInt();
                        if(x == 1){
                            clonedCake.setFilling("Chocolate Filling");
                        }
                        if(x == 2){
                            clonedCake.setFilling("Strawberry Filling");
                        }
                        if(x == 3){
                            clonedCake.setFilling("Vanilla Filling");
                        }
                    }
                    else{
                        System.out.println("На какой крем хотите заменить?\n1 - Chocolate Cream\n2 - Strawberry Cream\n3 - Vanilla Cream");
                        sc.nextLine();
                        x = sc.nextInt();
                        if(x == 1){
                            clonedCake.setCream("Chocolate Cream");
                        }
                        if(x == 2){
                            clonedCake.setCream("Strawberry Cream");
                        }
                        if(x == 3){
                            clonedCake.setCream("Vanilla Cream");
                        }
                    }
                }
                System.out.println("Отличный выбор!");
                shoppingManager.addToCart(clonedCake);
                payCake = clonedCake;
            }
        }

        shoppingManager.removeObserver(BoardObserver);
        shoppingManager.removeObserver(CardObserver);

        shoppingManager.addObserver(removeFromBoardObserver);
        shoppingManager.addObserver(payCheckObserver);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        System.out.println("Как будете оплавичать?\n1 - Наличными\n2 - Картой");
        sc.nextLine();
        x = sc.nextInt();
        if(x == 1){
            paymentProcessor.processPayment(new CashPaymentStrategy());
        }
        if(x == 2){
            paymentProcessor.processPayment(new CardPaymentStrategy());
        }

        shoppingManager.ready(payCake);
        /*<--------------------------------Menu--------------------------------->*/

    }

}