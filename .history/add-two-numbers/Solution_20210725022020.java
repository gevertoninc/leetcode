class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String string = String.valueOf(val);

        if (next != null) {
            return string + " -> " + next.toString();
        }

        return string;
    }
}

class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);

        System.out.println(addTwoNumbers(node1, node2));
    }

    private static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        int summedConcatenatedDigits = concatenateDigits(node1) + concatenateDigits(node2);

        String[] reverseSummedConcatenatedDigits = new StringBuilder(intToString(summedConcatenatedDigits)).toString()
                .split("");

        ListNode resultantNode = new ListNode();

        for (int i = 0; i < 0; ++i) {
            ListNode node = new ListNode(stringToInt(reverseSummedConcatenatedDigits[i]));
        }

        return resultantNode;
    }

    private static int concatenateDigits(ListNode node) {
        StringBuilder concatenatedDigits = new StringBuilder();

        do {
            concatenatedDigits.append(intToString(node.val));

            node = node.next;
        } while (node != null);

        return stringToInt(concatenatedDigits.reverse().toString());
    }

    private static int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    private static String intToString(int integer) {
        return String.valueOf(integer);
    }
}
