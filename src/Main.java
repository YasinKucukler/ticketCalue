import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int km;
        boolean isPositive = false;
        float perKmValue = 0.10f,
                totalAmount = 0f ,
                departure = 0f,
                age = 0f,
                discountAmount = 0f,
                twoWayDiscount = 0f;
        while(true) {
            System.out.println("Enter the road to travel:");
            km = input.nextInt();
            isPositive = ifEnteredValueIsNegative(km);
            if(isPositive)
            {break;}
        }
        while(true){
            System.out.println("Enter passenger's age:");
            age = input.nextFloat();
            isPositive = ifEnteredValueIsNegative((int) age);
            if (isPositive)
            {break;}
        }
        System.out.println("Select 1 for departure only and 2 for departure and return:");
        departure = input.nextFloat();
        twoWayDiscount = DiscountByWay(departure);

        //normal tutar hesaplanır
        totalAmount = km * perKmValue;
        //yaşa göre indirim hesaplanır
        discountAmount = totalAmount * DiscountByAge(age);
        totalAmount -= discountAmount;
        //tek yön veya gidiş dönüş seçimine göre indirim uygulanır
        twoWayDiscount *= totalAmount;
        totalAmount -=twoWayDiscount;
        //tek yön ise tutar 1 ile çift ise 2 ile çarpılır
        totalAmount *= departure;
        System.out.println("Total amount that you are going to pay is: " +
                            totalAmount);
}
    static boolean ifEnteredValueIsNegative(int n)
    {
        boolean isPositive;
        if (n <= 0)
        {
            System.out.println("Hatalı değer girdiniz! Lütfen pozitif bir değer giriniz!");
            return isPositive =false;
        }
        else {
            return isPositive = true;
        }
    }
    static float DiscountByAge(float age)
    {
        float discountPercent;
        if(age <12)
        {
            discountPercent= 0.5f;
        } else if (age <24) {
            discountPercent = 0.1f;
        } else if (age < 65) {
            discountPercent = 0f;
        }else
        {
            discountPercent = 0.3f;
        }

        return discountPercent;
    }
    static float DiscountByWay(float wayType)
    {
        float discount = 0f;
        if (wayType == 1)
        {
            discount = 0f;
        } else if (wayType == 2) {
            discount = 0.2f;
        }else {
            System.out.println("Hatalı değer girdiniz!");
        }
        return discount;
    }
}