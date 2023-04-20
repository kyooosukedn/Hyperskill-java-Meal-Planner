  package mealplanner;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Scanner;

  public class Main {
    static List<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);



    while (true) {
      System.out.println("What would you like to do (add, show, exit)?");
      String input = scanner.nextLine();
      mainMenu(input);

      if (input.equals("exit")) {
        System.out.println("Bye!");
        break;
      }

    }
  }

  private static void addMeal() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
    String category = scanner.nextLine();
    while (!isCategory(category)) {
      System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");

      category = scanner.nextLine();
      if (isCategory(category)) {
        break;
      }
    }

    System.out.println("Input the meal's name: ");
    String mealName = scanner.nextLine();
    while (wrongFormat(mealName)) {
      System.out.println("Wrong format. Use letters only!");
      mealName = scanner.nextLine();

    }
    System.out.println("Input the ingredients: ");
    String ingredientList = scanner.nextLine();
    String[] ingredients = ingredientList.split(",");
    while (true) {
      ingredientList = scanner.nextLine();
      ingredients = ingredientList.split(",");
      if (!wrongFormat(ingredientList)) {
        break;
      } else {
        System.out.println("Wrong format. Use letters only!");
        ingredientList = scanner.nextLine();
      }

      ingredientList = scanner.nextLine();
    }


    Meal meal = new Meal(category, mealName, ingredients);
    meals.add(meal);
    System.out.println("The meal has been added!");

  }

    private static boolean isCategory(String category) {
      return category.equalsIgnoreCase("breakfast") || category.equalsIgnoreCase("lunch") || category.equalsIgnoreCase("dinner");
    }

    private static void mainMenu(String input) {
    switch (input) {
      case "add":
        // Starts the meal input process and prompt users for the meal properties
        addMeal();
        break;
      case "show":
        // prints the list of saved meals with names, categories, and ingredients
        if (!meals.isEmpty()) {
          meals.stream().forEach(m -> printMeal(m));
          break;
        } else {
          System.out.println("No meals saved. Add a meal first.");
          break;
        }


      default:
        break;
    }
  }

  private static boolean wrongFormat(String input) {
    //return !input.matches("^[A-Za-z]+(?: [A-Za-z]+)*$");
    return !input.matches("^[a-zA-Z\\s]*$");
  }



  public static void printMeal(Meal meal) {
    System.out.println("Category: " + meal.getCategory());
    System.out.println("Name: " + meal.getName());
    System.out.println("Ingredients:");
    for (String i : meal.getIngredients()) {
      System.out.println(i);
    }
  }


}