import java.util.ArrayList;
import java.util.Iterator;

public class Calculator {
        ArrayList<Main.Good> goodList = new ArrayList<>();

        float sum = 0;
        int quantityPersons;

        float getSum(ArrayList<Main.Good> goodList) {

            this.goodList = goodList;
            Iterator iterator = goodList.iterator();

            while(iterator.hasNext()){
                Main.Good good = (Main.Good) iterator.next();
                sum = sum + good.price;
            }
            return sum;
        }

        float getSumForPerson(int quantityPersons, float sum) {
            this.sum = sum;
            this.quantityPersons = quantityPersons;
            float sumForPerson = sum / quantityPersons;
            return sumForPerson;
        }

       /*

            System.out.println(String.format("Каждый должен заплатить " + f%.2f + " р.", sumForPerson));
*/


}
