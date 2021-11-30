package utils;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Unionist;

public class AddUnionServiceFee {
    Scanner scanf = new Scanner(System.in);

    public void addServiceFee(ArrayList<Unionist> unionistList){
        System.out.println("|~ Type the unionist ID: ");
        Unionist foundUnionist = FindEmployee.findUnionist(scanf.nextLine(), unionistList);
        ListAllEmployee.listUnionist(foundUnionist);
        System.out.println("|~ Type the increase [XX,XX]: ");
        foundUnionist.setUnionFee(scanf.nextDouble());
    }
}
