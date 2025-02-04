import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to metric converter!\n");
        System.out.println("Please input your query. For example, 1 km = mile.\n");
        System.out.println("Enter 'exit' or '-1' to exit the program.\n");

        while (true) {
            System.out.print("Enter conversion query: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Goodbye!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3 || !parts[1].equals("=")) {
                System.out.println("Invalid input format. Please use format: '1 km = mile'");
                continue;
            }

            try {
                double value = Double.parseDouble(parts[0]);
                String unit = parts[2];
                convert(value, unit);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }
        }
        scanner.close();
    }

    public static void convert(double value, String unit) {
        switch (unit) {
            case "lb":
                System.out.printf("%.2f kg = %.2f lb\n", value, value * 2.20462);
                break;
            case "oz":
                System.out.printf("%.2f g = %.2f oz\n", value, value * 0.035274);
                break;
            case "mile":
                System.out.printf("%.2f km = %.2f miles\n", value, value * 0.621371);
                break;
            case "inch":
                System.out.printf("%.2f mm = %.2f inches\n", value, value * 0.0393701);
                break;
            default:
                System.out.println("Unsupported conversion. Try '1 km = mile' or '1 kg = lb'.");
        }
    }
}