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
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(addTwoNumbers(node1, node2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long summedConcatenatedDigits = concatenateDigits(l1) + concatenateDigits(l2);

        String[] reverseSummedConcatenatedDigits = new StringBuilder(longToString(summedConcatenatedDigits)).reverse()
                .toString().split("");

        ListNode nextNode = null;

        for (int i = reverseSummedConcatenatedDigits.length - 1; i > -1; --i) {
            ListNode currentNode = new ListNode(stringToInt(reverseSummedConcatenatedDigits[i]), nextNode);

            nextNode = currentNode;
        }

        return nextNode;
    }

    private static long concatenateDigits(ListNode node) {
        StringBuilder concatenatedDigits = new StringBuilder();

        do {
            concatenatedDigits.append(intToString(node.val));

            node = node.next;
        } while (node != null);

        return stringToLong(concatenatedDigits.reverse().toString());
    }

    private static int stringToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    private static long stringToLong(String stringNumber) {
        return Long.parseLong(stringNumber);
    }

    private static String intToString(int intNumber) {
        return String.valueOf(intNumber);
    }

    private static String longToString(long longNumber) {
        return String.valueOf(longNumber);
    }
}
