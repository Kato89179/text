public class Main {
    public static void main(String[] args) {

        String[] items = {"昼食", "飲み物", "交通費"};
        int[] prices = {800, 150, 300};

        System.out.println("=== 家計簿アプリ ===");

        for (int i = 0; i < items.length; i++) {
            System.out.println(
                "項目：" + items[i]
                + " 金額：" + prices[i] + "円"
            );
        }
    }
}
