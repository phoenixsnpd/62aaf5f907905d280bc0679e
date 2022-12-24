package ua.ithillel.homework28;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Service
public class User {
    @Autowired
    Cart cart;

    public void start(ProductRepository repository) {
        Scanner scan = new Scanner(System.in);
        String request;
        while (true) {
            if (cart.getOrder().size() == 0) {
                System.out.println("If you want to add product type 'add' and select id");
                System.out.println("To end the session, type 'exit'");
            } else if (cart.getOrder().size() > 1) {
                System.out.println("If you want to add another product type 'add' and select id");
                System.out.println("If you want to remove product type 'del' and select id");
                System.out.println("To end the session, type 'exit'");
            }
            request = scan.nextLine();
            if (request.equals("exit")) {
                break;
            }
            String[] splitRequest = request.split(" ");
            if (splitRequest.length > 2) {
                System.out.println("Wrong command");
                continue;
            }
            if (splitRequest[0].equals("add")) {
                int id = Integer.parseInt(splitRequest[1]);
                for (Product prod : repository.getProducts()) {
                    if (prod.getId() == id) {
                        cart.add(prod);
                        System.out.println(prod + " added. Thanks for your choice!");
                    }
                }
            }
            else if (splitRequest[0].equals("del")) {
                int id = Integer.parseInt(splitRequest[1]);
                Product delProd = cart.delete(id);
                        System.out.println(delProd + " removed");
                    } else {
                System.out.println("Wrong command");
            }
        }
    }
}
