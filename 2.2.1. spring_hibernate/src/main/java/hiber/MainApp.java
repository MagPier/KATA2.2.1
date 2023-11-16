package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      Car car1 = new Car("Toyota Corolla", 2021);
      Car car2 = new Car("Mersedes GLE", 2009);
      Car car3 = new Car("Audi Q7", 2020);
      Car car4 = new Car("Subaru Outback", 2008);



      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",car4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Mersedes GLE", 2009));

      context.close();
   }
}
